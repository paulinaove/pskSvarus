package lt.vu.usecases;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.SynchronizationType;

@ApplicationScoped
public class Resources {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    @Default
    private EntityManager createDefaultEntityManager() {
        System.out.println("Sukuriau paprasta EntityManager :)");
        return emf.createEntityManager(SynchronizationType.SYNCHRONIZED);
    }

    @Produces
    @ConversationScoped
    @Palaidas
    private EntityManager createUnsynchronizedEntityManager() {
        System.out.println("Sukuriau palaida EntityManager :)");
        return emf.createEntityManager(SynchronizationType.UNSYNCHRONIZED);
    }

    private void closeUnsynchronizedEntityManager(@Disposes @Any EntityManager em) {
        em.close();
        System.out.println("Sunaikinau kazkoki EntityManager...");
    }

}
