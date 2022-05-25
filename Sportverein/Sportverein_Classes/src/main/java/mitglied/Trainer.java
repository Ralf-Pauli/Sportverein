package mitglied;

import sport.Mannschaft;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Trainer extends AktivesMitglied {
    //region Attributes
    @OneToMany
    private List<Mannschaft> mannschaften = new ArrayList<>();
    private Trainerlizenz trainerlizenz;
    //endregion

    //region Constructor
    public Trainer(String name, Date gebDat, Date beitritt, List<Mannschaft> mannschaften) {
        super(name, gebDat, beitritt);
        setMannschaften(mannschaften);
    }

    public Trainer() {

    }
    //endregion

    //region Getter/Setter
    public List<Mannschaft> getMannschaften() {
        return mannschaften;
    }

    public void setMannschaften(List<Mannschaft> mannschaften) {
        this.mannschaften = mannschaften;
    }

    public Trainerlizenz getTrainerlizenz() {
        return trainerlizenz;
    }

    public void setTrainerlizenz(Trainerlizenz trainerlizenz) {
        this.trainerlizenz = trainerlizenz;
    }
    //endregion
}
