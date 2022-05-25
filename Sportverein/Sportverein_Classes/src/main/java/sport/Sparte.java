package sport;

import javax.persistence.*;

@Entity
@Table(name = "S_Sparte")
@NamedQueries({
        @NamedQuery(name = "Sparte.findAll", query = "select s from Sparte s")
})
public class Sparte {

    //region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "bezeichnung")
    private String bezeichnung;
    // endregion

    //region Constructors
    public Sparte( String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Sparte() {

    }
    //endregion

    //region Getter/Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    //endregion
}
