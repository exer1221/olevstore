package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
