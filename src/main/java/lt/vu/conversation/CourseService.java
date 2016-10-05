package lt.vu.conversation;

import lt.vu.entities.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;

@Stateless
public class CourseService {
    @PersistenceContext(synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    public void create(Course course) {
        em.persist(course);
    }
}
