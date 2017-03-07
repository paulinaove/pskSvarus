package lt.vu.usecases.simple;

import lt.vu.entities.Student;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class StudentDAO {
    @Inject
    private EntityManager em;

    public void create(Student student) {
        em.persist(student);
    }

    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }
}
