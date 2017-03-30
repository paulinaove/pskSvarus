package dao;



import jpa.Darbuotojas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by paulinaoveraite on 2017-03-18.
 */
@ApplicationScoped
public class DarbuotojasDAO {
    @Inject
    private EntityManager em;

    public void create(Darbuotojas darb) {
        em.persist(darb);
    }

    public List<Darbuotojas> getAllDarbuotojai() {
        return em.createNamedQuery("Darbuotojas.findAll", Darbuotojas.class).getResultList();
    }
}

