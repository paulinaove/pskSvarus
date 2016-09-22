package lt.vu.collaboration;

import lombok.Getter;
import lt.vu.entities.Course;
import lt.vu.entities.Student;
import org.omnifaces.util.Messages;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

@Named
@ConversationScoped
@Stateful
public class UseCaseController implements Serializable {

    private static final String PAGE_INDEX_REDIRECT = "index?faces-redirect=true";

    private enum CURRENT_FORM {
        CREATE_COURSE, CREATE_STUDENT, CONFIRMATION
    }

    @PersistenceContext(type = PersistenceContextType.EXTENDED, synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    @Inject
    @Getter
    private Conversation conversation;

    @Inject
    private CourseService courseService;
    @Inject
    private StudentService studentService;

    @Getter
    private Course course = new Course();
    @Getter
    private Student student = new Student();

    private CURRENT_FORM currentForm = CURRENT_FORM.CREATE_COURSE;
    public boolean isCurrentForm(CURRENT_FORM form) {
        return currentForm == form;
    }

    public void createCourse() {
        if (!conversation.isTransient()) {
            conversation.end();
            currentForm = CURRENT_FORM.CREATE_COURSE;
            return;
        }

        conversation.begin();
        courseService.create(course);

        currentForm = CURRENT_FORM.CREATE_STUDENT;
    }

    public void createStudent() {
        if (conversation.isTransient()) {
            currentForm = CURRENT_FORM.CREATE_COURSE;
            return;
        }

        studentService.create(student);
        student.getCourseList().add(course);
        course.getStudentList().add(student);

        currentForm = CURRENT_FORM.CONFIRMATION;
    }

    // Tai paskutinis žingsnis - naudojame JSF navigaciją su redirect:
    public String ok() {
        if (conversation.isTransient()) {
            return PAGE_INDEX_REDIRECT;
        }
        try {
            em.joinTransaction();
            em.flush();
            conversation.end();
            return PAGE_INDEX_REDIRECT;
        } catch (OptimisticLockException ole) {
            // Kažkas kitas buvo greitesnis...
            em.clear();
            // Šį pranešimą parodo h:messages arba p:messages komponentas:
            Messages.addGlobalWarn("Pabandykite iš naujo, nors tai dar neįgyvendinta...");
            return null;
        } catch (PersistenceException pe) {
            // Kitokios bėdos su DB - dažniausiai tai programuotojo kaltė.
            em.clear();
            // Šį pranešimą parodo h:messages arba p:messages komponentas:
            Messages.addGlobalError("Finita la commedia");
            return null;
        }
    }

    // Tai paskutinis žingsnis - naudojame JSF navigaciją su redirect:
    public String cancel() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return PAGE_INDEX_REDIRECT;
    }

}
