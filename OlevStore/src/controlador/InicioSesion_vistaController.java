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
import javafx.scene.control.Alert;
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
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Inicio de sesión");
            alerta.setHeaderText(null);
            alerta.setContentText("¡Bienvenido, " + correo + "!");
            alerta.showAndWait();

            // Aquí muestro la página principal
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PestañaPrincipal_vista.fxml"));
                Parent root = loader.load();

                PestañaPrincipal_vistaController controller = loader.getController();
                controller.setCorreoUsuario(correo); // <--- aquí se pasa el correo del usuario

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
                //No se, una excepcion xD
            }

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Credenciales incorrectas");
            alerta.setHeaderText(null);
            alerta.setContentText("Correo o contraseña incorrectos.");
            alerta.showAndWait();

            textoError1.setText("Error detectado en el correo");
            textoError2.setText("Error detectado en la password");

            textoError1.setVisible(true);
            textoError2.setVisible(true);
        }

    }

    //Este es le metodo para registrar un nuevo usuario :v
    private boolean registrarUsuario() {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        String correo = txtCorreoCuentaNueva.getText().trim();
        String pass = txtPasswordCrear.getText().trim();

        if (correo.isEmpty() || pass.isEmpty()) {
            alerta.setTitle("Campos Vacíos");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, completa todos los campos.");
            alerta.showAndWait();
            return false;
        }

        if (!esCorreoValido(correo)) {
            alerta.setTitle("Correo Inválido");
            alerta.setHeaderText(null);
            alerta.setContentText("El formato del correo ingresado no es válido.");
            alerta.showAndWait();
            return false;
        }

        listaUsuarios.agregarUsuario(correo, pass);
        listaUsuarios.guardarEnArchivo(RUTA);

        alerta.setTitle("Registro Exitoso");
        alerta.setHeaderText(null);
        alerta.setContentText("El usuario ha sido registrado correctamente.");
        alerta.showAndWait();

        return true;
    }

    //Esto es para validar si realmente lo que esta ingresando es un correo y no una simple cadena de texto :v
    private boolean esCorreoValido(String correo) {
        String regexCorreo = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return correo.matches(regexCorreo);
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
