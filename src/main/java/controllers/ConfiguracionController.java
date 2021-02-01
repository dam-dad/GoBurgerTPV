package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class ConfiguracionController implements Initializable {

	@FXML
	private GridPane view;

	@FXML
	private ToggleButton btnModoNocturno;

	@FXML
	private Button btnAñadir;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnSalir;

	@FXML
	private Button btnTamaño;

	public ConfiguracionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Configuracion.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void onClickAñadirUsuario(ActionEvent event) {

	}

	@FXML
	void onClickCambiarTamaño(ActionEvent event) {

	}

	@FXML
	void onClickEliminarUsuario(ActionEvent event) {

	}

	@FXML
	void onClickModoNocturno(ActionEvent event) {

	}

	@FXML
	void onClickSalir(ActionEvent event) {

	}
	
	public GridPane getView() {
		return view;
	}
}
