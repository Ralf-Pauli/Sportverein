package mitglied;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class PassivesMitglied extends Mitglied {
    //region Attributes
    private LocalDate kariereEnde;
    //endregion

    //region Constructor
    public PassivesMitglied(String name, Date gebDat, Date beitritt, LocalDate kariereEnde) {
        super(name, gebDat, beitritt);
        this.kariereEnde = kariereEnde;
    }

    public PassivesMitglied() {

    }
    //endregion

    //region Getter/Setter
    public LocalDate getKariereEnde() {
        return kariereEnde;
    }

    public void setKariereEnde(LocalDate kariereEnde) {
        this.kariereEnde = kariereEnde;
    }
    //endregion
}
