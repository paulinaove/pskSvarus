package dao;



import jpa.Suniukas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by paulinaoveraite on 2017-03-18.
 */
@ApplicationScoped
public class SuniukasDAO {
    @Inject
    private EntityManager em;

    public void create(Suniukas suo) {
        em.persist(suo);
    }

    public List<Suniukas> getAllSuniukas() {
        return em.createNamedQuery("Suniukas.findAll", Suniukas.class).getResultList();
    }
}
