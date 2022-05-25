package mitglied;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AktivesMitglied extends Mitglied {
    public AktivesMitglied(String name, Date gebDat, Date beitritt) {
        super(name, gebDat, beitritt);
    }

    public AktivesMitglied() {

    }
}
