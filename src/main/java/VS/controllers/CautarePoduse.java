package VS.controllers;
import VS.services.CartServices;
import VS.model.Produs;
import VS.services.ProduseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CautarePoduse {

    public ChoiceBox cc;
    @FXML
    private TableView<Produs> tabelproduse;
    @FXML
    private TableColumn<Produs, String> nume;
    @FXML
    private TableColumn<Produs, String> pret;
    @FXML
    private TableColumn<Produs, String> categorieprodus;


    private ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<String> items2 = FXCollections.observableArrayList();

    public void initialize() {
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        pret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        categorieprodus.setCellValueFactory(new PropertyValueFactory<>("categorieprodus"));

        //tabelproduse.setItems(produse);

    }

    @FXML
    public void cbOnAction(ActionEvent event)throws IOException {
        ProduseService.getProduseHaine(items);
        cc.getItems().addAll(items);

    }
    @FXML
    public void seeOnAction(ActionEvent event)throws IOException{
        if(cc.getSelectionModel().getSelectedItem()!=null){
            String piele=cc.getSelectionModel().getSelectedItem().toString();
            ObservableList<Produs> produse1 = FXCollections.observableArrayList(ProduseService.getProduseSelectate(piele));
            tabelproduse.setItems(produse1);
        }
    }


    //ObservableList<Produs> produse = FXCollections.observableArrayList(ProduseService.getProduseSelectate());

    public void handleButonInapoi() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ClientPage.fxml"));
        Stage stage = (Stage) tabelproduse.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void handleAdaugareCos() {
        ObservableList<Produs> typesSelected;
        typesSelected = tabelproduse.getSelectionModel().getSelectedItems();
        for(Produs pr: typesSelected)
        {
            CartServices.add(pr);
        }
    }
}
