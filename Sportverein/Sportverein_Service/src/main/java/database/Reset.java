package database;

import mitglied.Mitglied;
import sport.Mannschaft;
import sport.Sparte;
import sport.Sportart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

import static sport.Art.Einzelsport;
import static sport.Art.Teamsport;


public class Reset {
    public static void main(String[] args) {
        //region Mitglider
        List<Mitglied> mitglieder = Arrays.asList(
                new Mitglied("Aans", new Date(1990 - 1900, 1, 1), new Date(2015 - 1900, 1, 1)),
                new Mitglied("Bans", new Date(1991 - 1900, 3, 9), new Date(2020 - 1900, 6, 8)),
                new Mitglied("Cans", new Date(1992 - 1900, 6, 6), new Date(2011 - 1900, 9, 5)),
                new Mitglied("Dans", new Date(1993 - 1900, 2, 4), new Date(2018 - 1900, 3, 4)),
                new Mitglied("Eans", new Date(1994 - 1900, 1, 1), new Date(2015 - 1900, 1, 2)),
                new Mitglied("Fans", new Date(1995 - 1900, 3, 9), new Date(2020 - 1900, 6, 8)),
                new Mitglied("Gans", new Date(1996 - 1900, 6, 6), new Date(2011 - 1900, 9, 5)),
                new Mitglied("Hans", new Date(1997 - 1900, 2, 4), new Date(2018 - 1900, 3, 4)),
                new Mitglied("Ians", new Date(1998 - 1900, 1, 1), new Date(2015 - 1900, 1, 2)),
                new Mitglied("Jans", new Date(1999 - 1900, 3, 9), new Date(2020 - 1900, 6, 8)),
                new Mitglied("Kans", new Date(2000 - 1900, 6, 6), new Date(2011 - 1900, 9, 5)),
                new Mitglied("Lans", new Date(2001 - 1900, 2, 4), new Date(2018 - 1900, 3, 4)),
                new Mitglied("Mans", new Date(2002 - 1900, 1, 1), new Date(2015 - 1900, 1, 2)),
                new Mitglied("Nans", new Date(2003 - 1900, 3, 9), new Date(2020 - 1900, 6, 8)),
                new Mitglied("Oans", new Date(2004 - 1900, 6, 6), new Date(2011 - 1900, 9, 5)),
                new Mitglied("Pans", new Date(2005 - 1900, 2, 4), new Date(2018 - 1900, 3, 4)));
        //endregion

        //region Mitglieder Lists
        List<Mitglied> l1 = new ArrayList<>();
        l1.add(mitglieder.get(0));
        l1.add(mitglieder.get(1));

        List<Mitglied> l2 = new ArrayList<>();
        l2.add(mitglieder.get(2));
        l2.add(mitglieder.get(3));

        List<Mitglied> l3 = new ArrayList<>();
        l3.add(mitglieder.get(4));
        l3.add(mitglieder.get(5));

        List<Mitglied> l4 = new ArrayList<>();
        l4.add(mitglieder.get(6));
        l4.add(mitglieder.get(7));

        List<Mitglied> l5 = new ArrayList<>();
        l5.add(mitglieder.get(8));
        l5.add(mitglieder.get(9));

        List<Mitglied> l6 = new ArrayList<>();
        l6.add(mitglieder.get(10));
        l6.add(mitglieder.get(11));

        List<Mitglied> l7 = new ArrayList<>();
        l7.add(mitglieder.get(12));
        l7.add(mitglieder.get(13));

        List<Mitglied> l8 = new ArrayList<>();
        l8.add(mitglieder.get(14));
        l8.add(mitglieder.get(15));
        //endregion

        //region Mannschaft
        List<Mannschaft> mannschaften1 = Arrays.asList(
                new Mannschaft("Aber", l1),
                new Mannschaft("Bber", l2));
        List<Mannschaft> mannschaften2 = Arrays.asList(
                new Mannschaft("Cber", l3),
                new Mannschaft("Dber", l4));
        List<Mannschaft> mannschaften3 = Arrays.asList(
                new Mannschaft("Eber", l5),
                new Mannschaft("Fber", l6));
        List<Mannschaft> mannschaften4 = Arrays.asList(
                new Mannschaft("Gber", l7),
                new Mannschaft("Hber", l8));
        //endregion

        //region Sparten
        List<Sparte> sparten = Arrays.asList(
                new Sparte("Ballsport"),
                new Sparte("Wintersport"));
        //endregion

        //region Sportarten
        List<Sportart> sportarten = Arrays.asList(
                new Sportart("Fußball", Teamsport, sparten.get(0), mannschaften1),
                new Sportart("Basketball", Teamsport, sparten.get(0), mannschaften2),
                new Sportart("Skispringen", Einzelsport, sparten.get(1), mannschaften3),
                new Sportart("Ice Hockey", Teamsport, sparten.get(1), mannschaften4));


        //endregion

        //region JPA
        Properties einstellungen = new Properties();
        einstellungen.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportvereinPU", einstellungen);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        mitglieder.forEach((mitglied -> persist(em, mitglied)));
        mannschaften1.forEach(mannschaft -> persist(em, mannschaft));
        mannschaften2.forEach(mannschaft -> persist(em, mannschaft));
        mannschaften3.forEach(mannschaft -> persist(em, mannschaft));
        mannschaften4.forEach(mannschaft -> persist(em, mannschaft));
        sparten.forEach(sparte -> persist(em, sparte));
        sportarten.forEach(sportart -> persist(em, sportart));

        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Fertig");
        //endregion
    }

    public static void persist(EntityManager em, Object... o) {
        for (Object obj : o) {
            em.persist(obj);
        }
    }
}
