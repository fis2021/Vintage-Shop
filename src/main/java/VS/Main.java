import VS.Controller.AfisareProduse;
import VS.Services.CartServices;
import VS.Services.ProduseService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import VS.Services.UserService;
import VS.Services.FileSystemService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import VS.Controller.AfisareProduse;
public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            initDirectory();
            CartServices.initProdusDatabase();
            ProduseService.initProdusDatabase();
            UserService.initDatabase();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Login.fxml")));
            primaryStage.setTitle("Welcome");
            primaryStage.setScene(new Scene(root, 725, 490));
            primaryStage.show();
        }

        private void initDirectory() {

            Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
            if (!Files.exists(applicationHomePath))
                applicationHomePath.toFile().mkdirs();
        }


        public static void main(String[] args) {
            launch(args);
        }

    }



