package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class ConfiguracionController implements Initializable {
	
	//controller
	private TPVController tpv = new TPVController();
	
	//view
	@FXML
	private GridPane view;

	@FXML
	private ToggleButton btnModoNocturno;

	@FXML
	private Button btnAñadirUsuario;

	@FXML
	private Button btnEliminarUsuario;

	@FXML
	private Button btnSalir;

	@FXML
	private ToggleButton btnTamaño;

	@FXML
	private Button btnEliminarProducto;

	@FXML
	private Button btnAñadirProducto;

	@FXML
	private Button btnCambiarUsuario;

	public ConfiguracionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Configuracion.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void onClickAñadirProducto(ActionEvent event) {

	}

	@FXML
	void onClickAñadirUsuario(ActionEvent event) {

	}

	@FXML
	void onClickCambiarTamaño(ActionEvent event) {
		if(btnTamaño.isSelected()) {
			btnTamaño.setText("Si");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/LetraPequeña.css");
			
			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/LetraPequeña.css");
			
		} else {
			btnTamaño.setText("No");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/LetraNormal.css");
			
			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/LetraNormal.css");
		}
	}

	@FXML
	void onClickCambiarUsuario(ActionEvent event) {

	}

	@FXML
	void onClickEliminarProducto(ActionEvent event) {

	}

	@FXML
	void onClickEliminarUsuario(ActionEvent event) {

	}

	@FXML
	void onClickModoNocturno(ActionEvent event) {
		if(btnModoNocturno.isSelected()) {
			btnModoNocturno.setText("Si");
			view.setStyle(" -fx-background-color: #3b3b3b;");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/ModoNocturno.css");
			
			tpv.getView().setStyle("-fx-background-color: #3b3b3b;");
			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/ModoNocturno.css");
		} else {
			btnModoNocturno.setText("No");
			view.setStyle(" -fx-background-color: white;");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/ModoNormal.css");
			
			tpv.getView().setStyle("-fx-background-color: white;");
			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/ModoNormal.css");
		}
	}

	@FXML
	void onClickSalir(ActionEvent event) {
		Platform.exit();
	}

	public GridPane getView() {
		return view;
	}
}
