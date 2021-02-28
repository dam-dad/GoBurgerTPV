package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import configuracionItems.ProductosController;
import configuracionItems.UsuariosController;
import goburgertpv.App;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConfiguracionController implements Initializable {

	// controller
	private MainController main = new MainController();
	private TPVController tpv = new TPVController();
	private ProductosController productos = new ProductosController();
	private UsuariosController usuarios = new UsuariosController();

	// view
	@FXML
	private GridPane view;

	@FXML
	private ToggleButton btnModoNocturno;

	@FXML
	private Button btnControlarUsuario;

	@FXML
	private Button btnSalir;

	@FXML
	private Button btnControlarProductos;

	@FXML
	private Button btnCambiarUsuario;

	@FXML
	private ToggleButton btnTamaño;

	public ConfiguracionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Configuracion.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void onClickCambiarTamaño(ActionEvent event) {
		if (btnTamaño.isSelected()) {
			btnTamaño.setText("Si");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/LetraPequeña.css");
			if (btnModoNocturno.isSelected()) {
				view.getStylesheets().add("/css/ModoNocturno.css");
			}

			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/LetraPequeña.css");
			if (btnModoNocturno.isSelected()) {
				tpv.getView().getStylesheets().add("/css/ModoNocturno.css");
			}

		} else {
			btnTamaño.setText("No");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/LetraNormal.css");
			if (btnModoNocturno.isSelected()) {
				view.getStylesheets().add("/css/ModoNocturno.css");
			}

			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/LetraNormal.css");
			if (btnModoNocturno.isSelected()) {
				tpv.getView().getStylesheets().add("/css/ModoNocturno.css");
			}
		}
	}

	@FXML
	void onClickCambiarUsuario(ActionEvent event) {
		App.getPrimaryStage().setScene(new Scene(main.getView()));
	}

	@FXML
	void onClickControlarProductos(ActionEvent event) {
		Stage ventana = new Stage();
		Scene escena = new Scene(productos.getView());
		ventana.setScene(escena);
		ventana.setTitle("GoBurgerTPV");
		ventana.getIcons().add(new Image("/images/logoMini.png"));
		ventana.show();
	}

	@FXML
	void onClickControlarUsuario(ActionEvent event) {
		Stage ventana = new Stage();
		Scene escena = new Scene(usuarios.getView());
		ventana.setScene(escena);
		ventana.setTitle("GoBurgerTPV");
		ventana.getIcons().add(new Image("/images/logoMini.png"));
		ventana.show();
	}

	@FXML
	void onClickModoNocturno(ActionEvent event) {
		if (btnModoNocturno.isSelected()) {
			btnModoNocturno.setText("Si");
			view.setStyle(" -fx-background-color: #3b3b3b;");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/ModoNocturno.css");
			if(btnTamaño.isSelected()){
				view.getStylesheets().add("/css/LetraPequeña.css");
			}

			tpv.getView().setStyle("-fx-background-color: #3b3b3b;");
			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/ModoNocturno.css");
			if(btnTamaño.isSelected()){
				tpv.getView().getStylesheets().add("/css/LetraPequeña.css");
			}
		} else {
			btnModoNocturno.setText("No");
			view.setStyle(" -fx-background-color: white;");
			view.getStylesheets().clear();
			view.getStylesheets().add("/css/ModoNormal.css");
			if(btnTamaño.isSelected()){
				view.getStylesheets().add("/css/LetraPequeña.css");
			}

			tpv.getView().setStyle("-fx-background-color: white;");
			tpv.getView().getStylesheets().clear();
			tpv.getView().getStylesheets().add("/css/ModoNormal.css");
			if(btnTamaño.isSelected()){
				tpv.getView().getStylesheets().add("/css/LetraPequeña.css");
			}
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
