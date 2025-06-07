package Aplicacion;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/InicioSesion_vista.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
