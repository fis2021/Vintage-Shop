package VS.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import VS.exceptions.IncorrectPasswordException;
import VS.exceptions.InvalidUsernameException;
import VS.services.UserService;
import javafx.scene.control.TextField;

import java.io.IOException;
//import java.awt.*;

public class LoginController {
    @FXML
    private Label logMessage;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button logButton;
    @FXML
    private Button regButton;

    public void handleRegistrationView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage scene= (Stage) logButton.getScene().getWindow();
        scene.setTitle("Welcome");
        scene.setScene(new Scene(root,725,490));
    }

    public void  handleLoginAction() throws IOException {
        try
        {
            UserService.userExists(usernameField.getText(),passwordField.getText());
<<<<<<< Updated upstream
         //   logMessage.setText("Successful log in");
=======
            //   logMessage.setText("Successful log in");
>>>>>>> Stashed changes
            if(UserService.checkIsAdmin(usernameField.getText())==true)
            {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AdminPage.fxml"));
                Stage scene= (Stage) logButton.getScene().getWindow();
                scene.setTitle("Admin");
                scene.setScene(new Scene(root,720,490));
                scene.setResizable(true);
                //scene.setMinHeight(1080);
                //scene.setMinWidth(1920);
                //scene.setMaxHeight(1080);
<<<<<<< Updated upstream
               //scene.setMaxWidth(1920);
=======
                //scene.setMaxWidth(1920);
>>>>>>> Stashed changes
                //scene.setTitle("Client");
                //scene.setFullScreen(true);


            }
            else
            {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ClientPage.fxml"));
                Stage scene= (Stage) logButton.getScene().getWindow();
                scene.setScene(new Scene(root,720,490));
                scene.setResizable(true);
<<<<<<< Updated upstream
              //  scene.setMinHeight(1080);
               // scene.setMinWidth(1920);
               // scene.setMaxHeight(1080);
=======
                //  scene.setMinHeight(1080);
                // scene.setMinWidth(1920);
                // scene.setMaxHeight(1080);
>>>>>>> Stashed changes
                //scene.setMaxWidth(1920);
                //scene.setTitle("Client");
                //scene.setFullScreen(true);

            }


        }
        catch(InvalidUsernameException e)
        {
<<<<<<< Updated upstream
         //   logMessage.setText(e.getMessage());

        }catch(IncorrectPasswordException e)
        {
         //   logMessage.setText(e.getMessage());
=======
            //   logMessage.setText(e.getMessage());

        }catch(IncorrectPasswordException e)
        {
            //   logMessage.setText(e.getMessage());
>>>>>>> Stashed changes
        }

    }


}
