import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.StringConverter;
import mitglied.Mitglied;
import sport.Mannschaft;
import sport.Sparte;
import sport.Sportart;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class SportvereinController implements Initializable {

    //region FXML
    @FXML
    private ChoiceBox<Sparte> cbSparte;
    @FXML
    private Button btnSparte;
    @FXML
    private ChoiceBox<Sportart> cbSportart;
    @FXML
    private Button btnSportart;
    @FXML
    private ChoiceBox<Mannschaft> cbMannschaft;
    @FXML
    private Button btnMannschaft;
    @FXML
    private TableView<Mitglied> tblSportverein;
    @FXML
    private TableColumn<Mitglied, String> tcName;
    @FXML
    private TableColumn<Mitglied, Date> tcGeburtsdatum;
    @FXML
    private TableColumn<Mitglied, String> tcRole;
    @FXML
    private TableColumn<Mitglied, Date> tcBeitritt;
    //endregion

    private Client client;
    private WebTarget webTarget;
    private Gson gson;
    private String uri = "http://localhost:8080/Sportverein_Service/Sport/Verein";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        client = ClientBuilder.newClient();
        gson = new GsonBuilder().create();
        setConverter();
        addListener();
        fillChoiceBoxes();
    }

    private void setConverter() {
        cbSparte.setConverter(new StringConverter<Sparte>() {
            @Override
            public String toString(Sparte object) {
                return object.getBezeichnung();
            }

            @Override
            public Sparte fromString(String string) {
                return null;
            }
        });

        cbSportart.setConverter(new StringConverter<Sportart>() {
            @Override
            public String toString(Sportart object) {
                return object.getName();
            }

            @Override
            public Sportart fromString(String string) {
                return null;
            }
        });

        cbMannschaft.setConverter(new StringConverter<Mannschaft>() {
            @Override
            public String toString(Mannschaft object) {
                return object.getId() + ". " + object.getName();
            }

            @Override
            public Mannschaft fromString(String string) {
                return null;
            }
        });
    }

    private void fillChoiceBoxes() {
        try {
            ObservableList<Sparte> sparten = FXCollections.observableArrayList();
            sparten.addAll(getAll(Sparte.class));
            cbSparte.setItems(sparten);

            ObservableList<Sportart> sportarten = FXCollections.observableArrayList();
            sportarten.addAll(getAll(Sportart.class));
            cbSportart.setItems(sportarten);

            ObservableList<Mannschaft> mannschaft = FXCollections.observableArrayList();
            mannschaft.addAll(getAll(Mannschaft.class));
            cbMannschaft.setItems(mannschaft);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private <T> List<T> getAll(Class<T> tClass) throws ClassNotFoundException, JsonProcessingException {
        if (Sparte.class.equals(tClass)) {
            uri += "/getAllSparten";
        } else if (Mannschaft.class.equals(tClass)) {
            uri += "/getAllMannschaften";
        } else if (Sportart.class.equals(tClass)) {
            uri += "/getAllSportarten";
        } else {
            throw new ClassNotFoundException("Sparte, Mannschaft, Spoartar müssen übergeben werden");
        }
        webTarget = client.target(uri);
        return gson.fromJson(webTarget.request(MediaType.APPLICATION_JSON).get(String.class), TypeToken.getParameterized(ArrayList.class, tClass).getType());
    }

    private void addListener() {
        cbSparte.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sparte>() {
            @Override
            public void changed(ObservableValue<? extends Sparte> observable, Sparte oldValue, Sparte newValue) {
                cbSportart.setItems(getSportartenBySparte());
            }
        });
    }

    private ObservableList<Sportart> getSportartenBySparte() {
        webTarget = client.target(uri + "/getSportartenBySparte/" + cbSparte.getSelectionModel().getSelectedItem().getId());
        return gson.fromJson(webTarget.request(MediaType.APPLICATION_JSON).get(String.class), TypeToken.getParameterized(ArrayList.class, Sportart.class).getType());
    }


}
