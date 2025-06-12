package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Carrito;
import modelo.Producto;
import javafx.geometry.Insets;

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
    private String correoUsuario;
    @FXML
    private VBox contenedorProductos;

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
        
        //Aqui ando cargando el carrito :v
        
        cargarProductosCarrito(correoUsuario);
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

        File carpeta = new File("src/ArchivosTXT");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, false))) {
            for (Producto p : carrito.getProductos()) {
                writer.write(p.toString() + "\n");
            }
            System.out.println("Archivo actualizado: " + new File(nombreArchivo).getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCorreoUsuario(String correo) {
        this.correoUsuario = correo;
    }

    private void procesarProducto(String nombre, double precio, String rutaImagen) {
        Producto producto = new Producto(nombre, precio, rutaImagen);
        carrito.agregarProducto(producto);

        registroCarrito(carrito, correoUsuario);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Producto agregado");
        alerta.setHeaderText(null);
        alerta.setContentText(nombre + " agregado al carrito.");
        alerta.showAndWait();
    }

    private void finalizarCompra(ActionEvent event) {
        if (!carrito.estaVacio()) {
            registroCarrito(carrito, correoUsuario);
            carrito.vaciar();

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Compra finalizada");
            alerta.setHeaderText(null);
            alerta.setContentText("Compra registrada exitosamente.");
            alerta.showAndWait();
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Carrito vacío");
            alerta.setHeaderText(null);
            alerta.setContentText("No hay productos en el carrito.");
            alerta.showAndWait();
        }
    }

    //APARTIR DE AQUI EMPIEZO A HACER DIABLURAS JAJAJAJKJKAJKA
    public void cargarProductosCarrito(String correoUsuario) {
        String nombreArchivo = "src/ArchivosTXT/carrito_" + correoUsuario + ".txt";
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            System.out.println("No existe el archivo del carrito.");
            return;
        }

        contenedorProductos.getChildren().clear(); // Limpiar productos anteriores

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Producto producto = Producto.fromString(linea);
                if (producto != null) {
                    HBox item = crearItemProducto(producto);
                    contenedorProductos.getChildren().add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HBox crearItemProducto(Producto producto) {
        HBox caja = new HBox(10);
        caja.setAlignment(Pos.CENTER_LEFT);
        caja.setPadding(new Insets(5));
        caja.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5; -fx-background-color: #fcffff;");

        ImageView imagen = new ImageView();
        try {
            imagen.setImage(new Image(getClass().getResourceAsStream("/" + producto.getRutaImagen())));
        } catch (Exception e) {
            System.out.println("No se encontró la imagen: " + producto.getRutaImagen());
        }
        imagen.setFitHeight(60);
        imagen.setFitWidth(60);

        VBox texto = new VBox(5);
        Label nombre = new Label(producto.getNombre());
        Label precio = new Label("$" + producto.getPrecio());

        nombre.setStyle("-fx-font-weight: bold;");
        precio.setStyle("-fx-text-fill: green;");

        texto.getChildren().addAll(nombre, precio);
        caja.getChildren().addAll(imagen, texto);

        return caja;
    }

    @FXML
    private void AggControlXboxCarrito(ActionEvent event) {
        procesarProducto("Control XBOX Series S", 350000, "imagen/productos/controlXbox.png");
    }

    @FXML
    private void AgregarMouseSharkCarrito(ActionEvent event) {
        procesarProducto("Mouse Attack Shark x3", 150000, "imagen/productos/mouseSharkTank.png");
    }

    @FXML
    private void AgregarMouseLogitechCarrito(ActionEvent event) {
        procesarProducto("Mouse Logitech G203", 110000, "imagen/productos/mouseLogitech.png");
    }

    @FXML
    private void AgregarControlPlayStationCarrito(ActionEvent event) {
        procesarProducto("Control Play 5 Pro", 380000, "imagen/productos/mandoPlayStation.png");
    }

    @FXML
    private void AgregarTecladoNegroCarrito(ActionEvent event) {
        procesarProducto("Teclado Gamer Óptico", 540000, "imagen/productos/tecladoNegro.png");
    }

    @FXML
    private void AgregarTecladoBlancoCarrito(ActionEvent event) {
        procesarProducto("Teclado Gamer Redragon", 350000, "imagen/productos/tecladoBlanco.png");
    }

    @FXML
    private void AgregarAuricularesG335Carrito(ActionEvent event) {
        procesarProducto("Auriculares Logitech G335", 270000, "imagen/productos/cascos.png");
    }

    @FXML
    private void AgregarMonitorGamerCarrito(ActionEvent event) {
        procesarProducto("Monitor Gamer 32", 400000, "imagen/productos/monitor.png");
    }

    @FXML
    private void AgregarAuricularesG935Carrito(ActionEvent event) {
        procesarProducto("Logitech G935", 750000, "imagen/productos/AuricularesG935.png");
    }

    @FXML
    private void AgregarMonitorAOCCarrito(ActionEvent event) {
        procesarProducto("Monitor Gamer AOC", 700000, "imagen/productos/monitor2.png");
    }

    @FXML
    private void AgregarMicrofonoCarrito(ActionEvent event) {
        procesarProducto("Micrófono VSG Omkara", 239000, "imagen/productos/microfono.png");
    }

    @FXML
    private void agregarCamaraWebCarrito(ActionEvent event) {
        procesarProducto("Camara Web C270 HD", 120000, "imagen/productos/Camara.png");
    }

}
