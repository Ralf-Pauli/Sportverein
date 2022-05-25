package sport;

import mitglied.Mitglied;
import mitglied.Trainer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "S_Mannschaft")
@NamedQueries({
        @NamedQuery(name = "Mannschaft.findAll", query = "select m from Mannschaft m"),
        @NamedQuery(name = "Mannschaft.findMitglieder", query = "select m.mitglieder from Mannschaft m where m.id = :id")
})
public class Mannschaft {
    //region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<Mitglied> mitglieder = new ArrayList<>();

    @ManyToOne
    private Sportart sportart;

    @ManyToOne
    private Trainer trainer;
    // endregion

    //region Constructors
    public Mannschaft(String name, List<Mitglied> mitglieder) {
        setName(name);
        setMitglieder(mitglieder);
    }

    public Mannschaft() {
    }

    //endregion

    //region Getter/Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Sportart getSportart() {
        return sportart;
    }

    public void setSportart(Sportart sportart) {
        this.sportart = sportart;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Mitglied> getMitglieder() {
        return mitglieder;
    }

    public void setMitglieder(List<Mitglied> mitglieder) {
        this.mitglieder = mitglieder;
    }
    //endregion

}
