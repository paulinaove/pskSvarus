package lt.vu.usecases.conversation.cdi;

import lt.vu.entities.Course;
import lt.vu.usecases.Palaidas;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class CoursePalaidasDAO {
    @Inject
    @Palaidas
    private EntityManager em;

    public void create(Course course) {
        em.persist(course);
    }
}
