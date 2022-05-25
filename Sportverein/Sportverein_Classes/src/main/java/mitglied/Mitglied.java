package mitglied;

import sport.Mannschaft;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "S_Mitglied")
@NamedQueries({
        @NamedQuery(name = "Mitglieder.findAll", query = "select m from Mitglied m")
})
public class Mitglied {
    //region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date geburtsdatum;
    private Date beitritt;
    @ManyToOne
    private Mannschaft mannschaft;
    //endregion

    //region Constructor
    public Mitglied(String name, Date geburtsdatum, Date beitritt) {
        setName(name);
        setGeburtsdatum(geburtsdatum);
        setBeitritt(beitritt);
    }

    public Mitglied() {

    }
    //endregion

    //region Getter/Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mannschaft getMannschaft() {
        return mannschaft;
    }

    public void setMannschaft(Mannschaft mannschaft) {
        this.mannschaft = mannschaft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Date getBeitritt() {
        return beitritt;
    }

    public void setBeitritt(Date beitritt) {
        this.beitritt = beitritt;
    }

    //endregion
}
