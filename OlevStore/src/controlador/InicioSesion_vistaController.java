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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InicioSesion_vistaController implements Initializable {

    @FXML
    private Pane btnApple;
    @FXML
    private Pane btnGoogle;
    @FXML
    private TextField txtPassword;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paneCrearCuenta.setVisible(false);
        paneInicioSesion.setVisible(true);
    }

    @FXML
    private void btnIngresar_Clicked(MouseEvent event) {
        if (txtCorreoIngreso.getText().isEmpty() && txtPassword.getText().isEmpty()) {
            textoError1.setVisible(true);
            textoError1.setText("Ingrese su correo");
            textoError2.setVisible(true);
            textoError2.setText("Ingrese su password");
        } else if (txtCorreoIngreso.getText().isEmpty()) {
            textoError1.setVisible(true);
            textoError1.setText("Ingrese su correo");
        } else if (txtPassword.getText().isEmpty()) {
            textoError2.setVisible(true);
            textoError2.setText("Ingrese su password");
        } // Agrega la Logica para usuario no encontrado y la de password Incorrecta
        else {
            textoError1.setVisible(false);
            textoError2.setVisible(false);
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
                Logger.getLogger(InicioSesion_vistaController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        if(txtCorreoCuentaNueva.getText().isEmpty()){
            textoError3.setVisible(true);
            textoError3.setText("Ingrese un correo valido");
        }
        else{
            paneCrearCuenta.setVisible(false);
            paneInicioSesion.setVisible(true);
            
            textoError3.setVisible(false);
            txtCorreoCuentaNueva.clear();
        }
    }
    
}
