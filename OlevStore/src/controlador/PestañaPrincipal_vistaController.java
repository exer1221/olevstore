package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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

    @FXML
    private Text textoTitular;
    @FXML
    private Pane paneCarritoCompras;
    @FXML
    private Pane paneListaDeseados;
    @FXML
    private Pane pnPasarelaPago;
    @FXML
    private Pane confNequi;
    @FXML
    private Pane confPaypal;
    @FXML
    private Pane confMasterCard;
    @FXML
    private Pane pnPagoMasterCard;
    @FXML
    private Pane pnPagoNequiPaypal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnBtnCarritoCompra.setVisible(true);
        pnBtnListaDeseados.setVisible(true);
        paneBarrasBusqueda.setVisible(true);

        pnBtnInicio.setVisible(false);
        textoTitular.setVisible(false);

        //Siempre tengo que iniciar en el catalogo (true) y las demas dejarlas false, por seguridad xD
        ventanasFalse();

        paneCatalogo.setVisible(true);
        paneCatalogo.toFront();

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void ventanasFalse() {
        pnDescControlXBOX.setVisible(false);
        pnDescMouseAttack.setVisible(false);
        pnDescMouseLogitech.setVisible(false);
        paneCarritoCompras.setVisible(false);
        paneListaDeseados.setVisible(false);

        pnPasarelaPago.setVisible(false);
    }

    public void closeWindow() {
        stage.close();
    }

    @FXML
    private void btnCarritoCompra_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
        textoTitular.setVisible(true);
        textoTitular.setText("Carrito De Compras");

        //Ventana
        paneCarritoCompras.setVisible(true);

        paneBarrasBusqueda.setVisible(false);
    }

    @FXML
    private void btnListaDeseados_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        paneBarrasBusqueda.setVisible(false);
        textoTitular.setVisible(true);
        textoTitular.setText("Lista De Deseos");
        paneListaDeseados.setVisible(true);

        pnBtnInicio.setVisible(true);
        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
    }

    @FXML
    private void btnUsuario_Clicked(MouseEvent event) {
    }

    @FXML
    private void btnInicio_Clicked(MouseEvent event) {

        //Creo que con este metodo es mejor (Que flojera estar cambiandole el estado a todo de nuevo)
        ventanasFalse();

        paneCatalogo.setVisible(true);

        pnBtnInicio.setVisible(false);
        pnBtnCarritoCompra.setVisible(true);
        pnBtnListaDeseados.setVisible(true);

        textoTitular.setVisible(false);
        paneBarrasBusqueda.setVisible(true);
    }

    @FXML
    private void btnControlXBOX_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescControlXBOX.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnMouseAttack_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescMouseAttack.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnMouseLogitech(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescMouseLogitech.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnNequi_Clicked(MouseEvent event) {
        cerrarMetodoPago();
        
        confNequi.setVisible(true);
        confMasterCard.setVisible(false);
        confPaypal.setVisible(false);

        pnPagoNequiPaypal.setVisible(true);
    }

    @FXML
    private void btnPaypal_Click(MouseEvent event) {
        cerrarMetodoPago();
        
        confNequi.setVisible(false);
        confMasterCard.setVisible(false);
        confPaypal.setVisible(true);

        pnPagoNequiPaypal.setVisible(true);
    }

    @FXML
    private void btnMasterCard_Clicked(MouseEvent event) {
        cerrarMetodoPago();
        
        confNequi.setVisible(false);
        confMasterCard.setVisible(true);
        confPaypal.setVisible(false);

        pnPagoMasterCard.setVisible(true);
    }

    @FXML
    private void btnPagar_Clicked(MouseEvent event) {
        abrirPasarelaPago();
    }

    @FXML
    private void btnPagarTodo_Clicked(MouseEvent event) {
        abrirPasarelaPago();
    }
    
    public void cerrarMetodoPago() {
        pnPagoNequiPaypal.setVisible(false);
        pnPagoMasterCard.setVisible(false);
    }

    public void abrirPasarelaPago() {
        paneCarritoCompras.setVisible(false);
        pnPasarelaPago.setVisible(true);
        textoTitular.setVisible(true);
        textoTitular.setText("Pasarela De Pago");

        //Hice esto para no tener que repetir mucho codigo, se ve feo :v
        cerrarMetodoPago();
        
        confNequi.setVisible(false);
        confMasterCard.setVisible(false);
        confPaypal.setVisible(false);

        
    }

}
