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
	private Button btnAñadirUsuario;

	@FXML
	private Button btnEliminarUsuario;

	@FXML
	private Button btnSalir;

	@FXML
	private Button btnTamaño;

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
			
		}
	}

	@FXML
	void onClickSalir(ActionEvent event) {

	}

	public GridPane getView() {
		return view;
	}
}
