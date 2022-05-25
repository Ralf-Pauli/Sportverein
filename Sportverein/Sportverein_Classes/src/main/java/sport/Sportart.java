package sport;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "S_Sportart")
@NamedQueries({
        @NamedQuery(name = "Sportart.findAll", query = "select s from Sportart s"),
        @NamedQuery(name = "Sportart.findMannschaften", query = "select s.mannschafts from Sportart s where s.id = :id"),
        @NamedQuery(name = "Sportart.findBySparte", query = "select s from Sportart s where s.sparte.id = :id")
})
public class Sportart {

    //region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Art art;
    @ManyToOne
    private Sparte sparte;
    @OneToMany
    private List<Mannschaft> mannschafts;
    //endregion

    //region Constructors

    public Sportart(String name, Art art, Sparte sparte, List<Mannschaft> mannschaften) {
        this.name = name;
        this.art = art;
        this.sparte = sparte;
        setMannschaften(mannschaften);
    }

    public Sportart() {

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

    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }

    public Sparte getSparte() {
        return sparte;
    }

    public void setSparte(Sparte sparte) {
        this.sparte = sparte;
    }

    public List<Mannschaft> getMannschaften() {
        return mannschafts;
    }

    public void setMannschaften(List<Mannschaft> mannschaften) {
        this.mannschafts = mannschaften;
    }

//endregion

}
