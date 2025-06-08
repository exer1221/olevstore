package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.ListaUsuarios;

public class InicioSesion_vistaController implements Initializable {

    @FXML
    private Pane btnApple;
    @FXML
    private Pane btnGoogle;
    @FXML
    private TextField txtPasswordIngreso;
    @FXML
    private Button btnRegistrarse;
    @FXML
    private Pane paneInicioSesion;
    @FXML
    private TextField txtCorreoIngreso;
    @FXML
    private Button btnIngresar;
    @FXML
    private Pane paneCrearCuenta;
    @FXML
    private Button btnCrearCuenta;
    @FXML
    private Pane btnApple1;
    @FXML
    private Pane btnGoogle1;
    @FXML
    private Text textoError1;
    @FXML
    private Text textoError2;
    @FXML
    private Text textoError3;
    @FXML
    private TextField txtCorreoCuentaNueva;

    //Aqui estoy haciendo lo del registro de usuarios con Nodos y Listas Dobles
    private final String RUTA = "src\\ArchivosTXT\\usuarios.txt";
    private ListaUsuarios listaUsuarios = new ListaUsuarios();
    @FXML
    private TextField txtPasswordCrear;
    @FXML
    private Text textoError4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paneCrearCuenta.setVisible(false);
        paneInicioSesion.setVisible(true);

        listaUsuarios.cargarDesdeArchivo(RUTA);
    }

    private void iniciarSesion() {
        String correo = txtCorreoIngreso.getText().trim();
        String pass = txtPasswordIngreso.getText().trim();
        if (listaUsuarios.validarUsuario(correo, pass)) {
            System.out.println("Bienvenido " + correo);

            //Aqui muestro la paginaPrincipal
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PestañaPrincipal_vista.fxml"));
                Parent root = loader.load();

                PestañaPrincipal_vistaController controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow();
                });
                stage.show();

                Stage miStage = (Stage) this.btnIngresar.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                //Logger.getLogger(InicioSesion_vistaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            textoError1.setText("Error detectado en el correo");
            textoError2.setText("Error detectado en la password");

            textoError1.setVisible(true);
            textoError2.setVisible(true);
        }
    }

    //Este es le metodo para registrar un nuevo usuario :v
    private boolean registrarUsuario() {
        String correo = txtCorreoCuentaNueva.getText().trim();
        String pass = txtPasswordCrear.getText().trim();

        if (!correo.isEmpty() && !pass.isEmpty()) {
            listaUsuarios.agregarUsuario(correo, pass);
            listaUsuarios.guardarEnArchivo(RUTA);
            System.out.println("Usuario registrado.");
            return true;
        } else {
            System.out.println("Error, posibles campos vacíos");
            return false;
        }
    }

    @FXML
    private void btnApple_Clicked(MouseEvent event) {
    }

    @FXML
    private void btnGoogle_Clicked(MouseEvent event) {
    }

    @FXML
    private void btnRegistrarse_Clicked(MouseEvent event) {
        paneInicioSesion.setVisible(false);
        paneCrearCuenta.setVisible(true);
    }

    @FXML
    private void btnCrearCuenta_Clicked(MouseEvent event) {

        if (txtCorreoCuentaNueva.getText().isEmpty() || txtPasswordCrear.getText().isEmpty()) {
            if (txtCorreoCuentaNueva.getText().isEmpty()) {
                textoError3.setText("Campo vacío");
                textoError3.setVisible(true);
            } else {
                textoError3.setVisible(false);
            }

            if (txtPasswordCrear.getText().isEmpty()) {
                textoError4.setText("Campo vacío");
                textoError4.setVisible(true);
            } else {
                textoError4.setVisible(false);
            }
        } else {
            try {
                if (registrarUsuario()) {

                    paneCrearCuenta.setVisible(false);
                    paneInicioSesion.setVisible(true);

                    txtCorreoIngreso.clear();
                    txtCorreoCuentaNueva.clear();
                    txtPasswordCrear.clear();

                    textoError1.setVisible(false);
                    textoError2.setVisible(false);
                    textoError3.setVisible(false);
                    textoError4.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void btnIngresar_Clicked(MouseEvent event) {
        try {
            //Aqui hago la validacion

            iniciarSesion();

        } catch (Exception e) {
        }
    }

    @FXML
    private void btnApagarPrograma(MouseEvent event) {
        Platform.exit();
    }

}
