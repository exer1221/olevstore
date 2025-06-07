package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class InicioSesion_vistaController implements Initializable {

    @FXML
    private TextField txtCorreo;
    @FXML
    private Pane btnApple;
    @FXML
    private Pane btnGoogle;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnRegistrarse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
