package org.loose.fis.sre.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.h2.mvstore.cache.CacheLongKeyLIRS;
import org.loose.fis.sre.exceptions.incorrectPassword;
import org.loose.fis.sre.exceptions.invalidUsername;
import org.loose.fis.sre.services.UserService;
import javafx.scene.control.TextField;

import javax.swing.*;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Objects;
//import java.awt.*;

public class LoginController {
    @FXML
    private Label loginMessage;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    public void handleRegistrationView() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
        Stage scene= (Stage) loginButton.getScene().getWindow();
        scene.setTitle("Welcome");
        scene.setScene(new Scene(root,725,490));
    }

    public void  handleLoginAction() throws IOException {
        try
        {
            UserService.userExists(usernameField.getText(),passwordField.getText());
            //   loginMessage.setText("Successful login");
            if(UserService.checkIsAdmin(usernameField.getText()))
            {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("AdminPage.fxml")));
                Stage scene= (Stage) loginButton.getScene().getWindow();
                scene.setTitle("Admin");
                scene.setScene(new Scene(root,1920,1080));
                scene.setResizable(false);
                scene.setMinHeight(1080);
                scene.setMinWidth(1920);
                scene.setMaxHeight(1080);
                scene.setMaxWidth(1920);
                scene.setTitle("Client");
                scene.setFullScreen(true);


            }
            else
            {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ClientPage.fxml")));
                Stage scene= (Stage) loginButton.getScene().getWindow();
                scene.setScene(new Scene(root,1920,1080));
                scene.setResizable(false);
                scene.setMinHeight(1080);
                scene.setMinWidth(1920);
                scene.setMaxHeight(1080);
                scene.setMaxWidth(1920);
                scene.setTitle("Client");
                scene.setFullScreen(true);

            }


        }
        catch(invalidUsername e)
        {
            //   loginMessage.setText(e.getMessage());

        }catch(incorrectPassword e)
        {
            //   loginMessage.setText(e.getMessage());
        }

    }

}
