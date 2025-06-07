package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PestañaPrincipal_vistaController implements Initializable {

    @FXML
    private Pane paneCatalogo;
    @FXML
    private ImageView btnCarritoCompra;
    @FXML
    private ImageView btnListaDeseados;
    @FXML
    private Pane paneBarrasBusqueda;
    @FXML
    private TextField txtBarraBusqueda;
    @FXML
    private ImageView btnUsuario;
    @FXML
    private Pane pnBtnCarritoCompra;
    @FXML
    private Pane pnBtnListaDeseados;
    @FXML
    private Pane pnBtnInicio;
    @FXML
    private ImageView btnInicio;
    @FXML
    private Pane pnDescControlXBOX;
    @FXML
    private Button btnAñadirAlCarrito;
    @FXML
    private Pane pnDescMouseAttack;
    @FXML
    private Button btnAñadirAlCarrito1;
    @FXML
    private Pane pnDescMouseLogitech;
    @FXML
    private Button btnAñadirAlCarrito11;
    
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    public void closeWindow() {
        stage.close();
    }

    @FXML
    private void btnCarritoCompra_Clicked(MouseEvent event) {
    }

    @FXML
    private void btnListaDeseados_Clicked(MouseEvent event) {
    }

    @FXML
    private void btnUsuario_Clicked(MouseEvent event) {
    }

    @FXML
    private void btnInicio_Clicked(MouseEvent event) {
    }
    
}
