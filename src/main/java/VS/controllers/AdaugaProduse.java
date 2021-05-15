package VS.Controller;

import VS.Services.ProduseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class AdaugaProduse {
    @FXML
    public TextField numeprodus;

    @FXML
    private TextField pretprodus;
    @FXML
    private TextField categorieprodus;
    @FXML
    private Button add;

    public void handleAddAction(ActionEvent actionEvent) {
        ProduseService.addProduse(numeprodus.getText(),pretprodus.getText(),categorieprodus.getText());
    }
}
