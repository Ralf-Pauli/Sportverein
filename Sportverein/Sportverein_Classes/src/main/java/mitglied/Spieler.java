package mitglied;

import sport.Mannschaft;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Spieler extends AktivesMitglied {
    //region Attributes
    @ManyToOne
    private Mannschaft mannschaft;
    private int trikotgroesse;
    //endregion

    //region Constructors
    public Spieler(String name, Date gebDat, Date beitritt, Mannschaft mannschaft, int trikotgroesse) {
        super(name, gebDat, beitritt);
        setMannschaft(mannschaft);
        setTrikotgroesse(trikotgroesse);
    }

    public Spieler() {

    }
    //endregion

    //region Getter/Setter
    public Mannschaft getMannschaft() {
        return mannschaft;
    }

    public void setMannschaft(Mannschaft mannschaft) {
        this.mannschaft = mannschaft;
    }

    public int getTrikotgroesse() {
        return trikotgroesse;
    }

    public void setTrikotgroesse(int trikotgroesse) {
        this.trikotgroesse = trikotgroesse;
    }

    //endregion
}
