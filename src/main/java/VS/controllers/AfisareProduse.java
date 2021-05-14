package VS.Controller;

import VS.Model.Produs;
import VS.Services.ProduseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AfisareProduse {

    @FXML
    private TableView<Produs> tabelproduse;
    @FXML
    private TableColumn<Produs, String> nume;
    @FXML
    private TableColumn<Produs, String> pret;
    @FXML
    private TableColumn<Produs, String> categorieprodus;

    public void initialize() {
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        pret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        categorieprodus.setCellValueFactory(new PropertyValueFactory<>("categorieprodus"));

        tabelproduse.setItems(produse);

    }

    ObservableList<Produs> produse = FXCollections.observableArrayList(ProduseService.getProduse());

    public void handleButonInapoi() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ClientPage.fxml"));
        Stage stage = (Stage) tabelproduse.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


}
