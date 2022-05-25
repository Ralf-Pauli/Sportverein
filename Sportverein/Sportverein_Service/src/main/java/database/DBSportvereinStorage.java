package database;

import mitglied.Mitglied;
import sport.Mannschaft;
import sport.Sparte;
import sport.Sportart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked")
public class DBSportvereinStorage {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public DBSportvereinStorage() {
        emf = Persistence.createEntityManagerFactory("SportvereinPU");
        em = emf.createEntityManager();
    }

    public List<Mitglied> getAllMitglieder() {
        Query q = em.createNamedQuery("Mitglieder.findAll");
        return q.getResultList();
    }

    public List<Sparte> getAllSparten() {
        Query q = em.createNamedQuery("Sparte.findAll");
        return q.getResultList();
    }

    public List<Sportart> getAllSportarten() {
        Query q = em.createNamedQuery("Sportart.findAll");
        return q.getResultList();
    }

    public List<Mannschaft> getAllMannschaften() {
        Query q = em.createNamedQuery("Mannschaft.findAll");
        return q.getResultList();
    }

    public List<Mitglied> getMitgliederByMannschaft() {
        Query q = em.createNamedQuery("Mannschaft.findMitglieder");
        return q.getResultList();
    }

    public List<Mannschaft> getMannschaftBySportart() {
        Query q = em.createNamedQuery("Sportart.findMannschaften");
        return q.getResultList();
    }

    public List<Sportart> getSportartenBySparte(int id) {
//        Query q = em.createNamedQuery("Sportart.findBySparte");
        Query q = em.createQuery("select id,sparte from Sportart where Sparte.id = :id");
        q.setParameter("id", id);
        System.out.println("test");
        return q.getResultList();
    }


}
