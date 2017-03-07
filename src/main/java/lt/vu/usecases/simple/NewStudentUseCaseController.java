package lt.vu.usecases.simple;

import lombok.Getter;
import lt.vu.entities.Student;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Transactional
public class NewStudentUseCaseController {

    @Getter
    private Student student = new Student();

    @Inject
    private StudentDAO studentDAO;

    public void createStudent() {
        studentDAO.create(student);
        student = new Student();
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
