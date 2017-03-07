package lt.vu.usecases.conversation.cdi;

import lt.vu.entities.Student;
import lt.vu.usecases.Palaidas;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class StudentPalaidasDAO {
    @Inject
    @Palaidas
    private EntityManager em;

    public void create(Student student) {
        em.persist(student);
    }

    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }
}
