package configuracionItems;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Transaction;

import goburgertpv.database.connection.Funciones;
import goburgertpv.database.tables.Users;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;

public class AnadirUsuarioController implements Initializable {
	
	//model
	private UsuariosModel usuario = new UsuariosModel(); 
	
	//view
	@FXML
    private GridPane view;
	
	@FXML
    private PasswordField pswdContrasena;

    @FXML
    private PasswordField pswdConfirmada;

    @FXML
    private TextField txtNombreUsuario;
    
    @FXML
    private CheckBox chkAdmin;
    
    @FXML
    private Button btnAnadir;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		usuario.usuarioProperty().bind(txtNombreUsuario.textProperty());
		usuario.contraseñaProperty().bind(pswdContrasena.textProperty());
		usuario.confirmarContraseñaProperty().bind(pswdConfirmada.textProperty());
		chkAdmin.setOnAction(e -> onSelectedAction());
	}
	
	private void onSelectedAction() {
		if (chkAdmin.isSelected()) {
			usuario.setAdministrador(true);
		} else {
			usuario.setAdministrador(false);
		}
	}

	public AnadirUsuarioController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vistasConfiguracion/AnadirUsuario.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@FXML
    void onClickAnadirAction(ActionEvent event) {
		if (usuario.getContraseña().equals(usuario.getConfirmarContraseña())) {
			Transaction transaction=Funciones.getSession().beginTransaction();
			Users user=new Users();
			user.setUsuario(usuario.getUsuario());
			user.setPassword(DigestUtils.md2Hex(usuario.getContraseña()));
			user.setAdministrador(usuario.isAdministrador());
			transaction=Funciones.getSession().beginTransaction();
			Funciones.getSession().save(user);
			transaction.commit();
		} else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Añadir Usuario");
			alerta.setHeaderText("Añadir usuario denegado");
			alerta.setContentText("El usuario y/o contraseña no son validos o no coinciden.");

			alerta.showAndWait();
		}
    }
	
	public GridPane getView() {
		return view;
	}
	
}
