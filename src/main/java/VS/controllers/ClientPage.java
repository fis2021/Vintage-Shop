package VS.Controller;

//import com.sun.javafx.tk.quantum.PaintRenderJob;
import VS.Model.Produs;
import VS.Model.User;
import VS.Services.CartServices;
import VS.Services.ProduseService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

//import java.awt.event.ActionEvent;
import java.io.IOException;

public class ClientPage {
    @FXML
    private Button butonCreareCont;
    @FXML
    private Button butonVizualizareStatus;
    @FXML
    private Button butonDeconectare;
    @FXML
    private Button butonVizualizareListaServiciiSiPreturi;
    @FXML
    private Button AlegereOptiuneDorita;
    @FXML
    private Button buttonCreate;
    @FXML
    private Text registrationMessage;

    @FXML
    private User user;

    public void setUser(User user)
    {
        this.user=user;
    }


    public void handleCreareCont() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("crearecont.fxml"));
            Stage stage = (Stage) (butonCreareCont.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }
    public void handleAlegereAngajat() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("clientAlegereAngajat.fxml"));
            Stage stage = (Stage) (butonVizualizareStatus.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }

    public void handleVizualizareListaServiciiSiPreturi(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AfisareProdus.fxml"));
            Stage stage = (Stage) (butonVizualizareStatus.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }
    @FXML
    ListView<String> list1=new ListView<String>();
    private ObservableList<String> items_list1 = FXCollections.observableArrayList();
    @FXML
    public void handleProduse()throws IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AfisareProdus.fxml"));
        Stage stage = (Stage) (butonVizualizareStatus.getScene().getWindow());
        stage.setScene(new Scene(root));
    }

    public void handleAlegereOptiuneDorita() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("clientAlegereOptiune.fxml"));
            Stage stage = (Stage) (butonVizualizareStatus.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }

    public void handleDeconectare() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
            Stage stage = (Stage) (butonDeconectare.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }
    @FXML
    public void handleRegisterAction() throws Exception{
        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage stage = (Stage) (buttonCreate.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            registrationMessage.setText("eroare!");
        }
    }

    public void handleCautare() throws IOException {
        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("CautareProduse.fxml"));
            Stage stage = (Stage) (buttonCreate.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            registrationMessage.setText("eroare!");
        }


    }


    public void handleVizualizareCos() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AfisareCos.fxml"));
        Stage stage = (Stage) (butonVizualizareStatus.getScene().getWindow());
        stage.setScene(new Scene(root));

    }

    public void handleVizualizareStatus() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("VizualizareStatusComanda.fxml"));
        Stage stage = (Stage) (butonVizualizareStatus.getScene().getWindow());
        stage.setScene(new Scene(root));
    }
}
