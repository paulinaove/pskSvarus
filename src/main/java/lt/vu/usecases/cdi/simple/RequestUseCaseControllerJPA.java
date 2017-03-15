package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Course;
import lt.vu.entities.Student;
import lt.vu.usecases.cdi.dao.CourseDAO;
import lt.vu.usecases.cdi.dao.StudentDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Course course = new Course();
    @Getter
    private Student student = new Student();

    @Inject
    private CourseDAO courseDAO;
    @Inject
    private StudentDAO studentDAO;

    @Transactional
    public void createCourseStudent() {
        student.getCourseList().add(course);
        course.getStudentList().add(student);
        courseDAO.create(course);
        studentDAO.create(student);
        log.info("Maybe OK...");
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
