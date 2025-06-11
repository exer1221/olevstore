package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Carrito;
import modelo.Producto;

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
    @FXML
    private Text textoUsuario1;
    @FXML
    private Pane paneContentLoggout;
    @FXML
    private Text textoUsuario2;

    InicioSesion_vistaController InicioSesion_vistaController;
    @FXML
    private Pane pnDescControlPlay;
    @FXML
    private Button btnAñadirAlCarrito2;
    @FXML
    private Pane pnDescTecladoGamerOptico;
    @FXML
    private Button btnAñadirAlCarrito21;
    @FXML
    private Pane pnDescTecladoGamerRedragon;
    @FXML
    private Button btnAñadirAlCarrito211;
    @FXML
    private Pane pnDescAuricularesLogitech;
    @FXML
    private Button btnAñadirAlCarrito2111;
    @FXML
    private Pane pnDescMonitorGamer;
    @FXML
    private Button btnAñadirAlCarrito21111;
    @FXML
    private Pane pnDescAuricularesG935;
    @FXML
    private Button btnAñadirAlCarrito211111;
    @FXML
    private Pane pnDescMonitorAOC;
    @FXML
    private Button btnAñadirAlCarrito2111111;
    @FXML
    private Pane pnDescMicrofono;
    @FXML
    private Button btnAñadirAlCarrito21111111;
    @FXML
    private Pane pnDescCamaraWeb;
    @FXML
    private Button btnAñadirAlCarrito211111111;

    //Cositas del carrito de compras
    private Carrito carrito = new Carrito();
    private String correoUsuario = "usuario@ejemplo.com";

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
        pnDescControlPlay.setVisible(false);
        pnDescTecladoGamerOptico.setVisible(false);
        pnDescTecladoGamerRedragon.setVisible(false);
        pnDescAuricularesLogitech.setVisible(false);
        pnDescMonitorGamer.setVisible(false);
        pnDescAuricularesG935.setVisible(false);
        pnDescMonitorAOC.setVisible(false);
        pnDescMicrofono.setVisible(false);
        pnDescCamaraWeb.setVisible(false);

        paneCarritoCompras.setVisible(false);
        paneListaDeseados.setVisible(false);
        paneContentLoggout.setVisible(false);

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
        boolean visibleAhora = !paneContentLoggout.isVisible();
        paneContentLoggout.setVisible(visibleAhora);

        if (visibleAhora) {
            paneContentLoggout.toFront();
        }
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

    //Aqui inicio con los eventos del catalogo, que diavlura
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
    private void btnControlPlay_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescControlPlay.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnTecladoGamerOptico_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescTecladoGamerOptico.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnTecladoGamerReDragon_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescTecladoGamerRedragon.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnAuricularesG335_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescAuricularesLogitech.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnMonitorGamer_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescMonitorGamer.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnAuricularesG935_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescAuricularesG935.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnMonitorAOC_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescMonitorAOC.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnMicrofono_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescMicrofono.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    @FXML
    private void btnCamaraWeb_Clicked(MouseEvent event) {
        paneCatalogo.setVisible(false);
        pnDescCamaraWeb.setVisible(true);

        pnBtnCarritoCompra.setVisible(false);
        pnBtnListaDeseados.setVisible(false);
        pnBtnInicio.setVisible(true);
    }

    //Cositas de la pasarela de pago
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

    @FXML
    private void btnCerrarSesion_Clicked(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioSesion_vista.fxml"));
            Parent root = loader.load();

            Stage nuevoStage = new Stage();
            nuevoStage.setScene(new Scene(root));
            nuevoStage.show();

            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageActual.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Aqui voy a empezar a trabajar en el carrito de compras
    public void registroCarrito(Carrito carrito, String correoUsuario) {
        String nombreArchivo = "src/ArchivosTXT/carrito_" + correoUsuario + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write("----- Compra realizada -----\n");
            for (Producto p : carrito.getProductos()) {
                writer.write(p.toString() + "\n");
            }
            writer.write("----------------------------\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarProductoAlCarrito(String nombre, double precio) {
        Producto producto = new Producto(nombre, precio);
        carrito.agregarProducto(producto);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Producto agregado");
        alerta.setHeaderText(null);
        alerta.setContentText(nombre + " agregado al carrito.");
        alerta.showAndWait();
    }

}
