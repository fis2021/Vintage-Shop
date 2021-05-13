package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Vintage Shop");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
    /*
    public static void changeScene(Button source, String fxml_file) throws IOException {
        ((Stage) source.getScene().getWindow()).setScene(new Scene(loadFXML(fxml_file), 1280, 720));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        return new FXMLLoader(Main.class.getResource(fxml + ".fxml")).load();
    }
    */

    public static void main(String[] args) {
        launch(args);
    }
}
