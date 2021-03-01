package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

import goburgertpv.App;
import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.HibernateUtil;
import goburgertpv.database.tables.Users;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import models.MainModel;
import models.VistaPrincipalModel;
/**
 * Controller de la Vista Inicio Sesión
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class MainController implements Initializable {

	// Controllers
	TPVController tpvController; 

	// Model
	// private ObjectProperty<MainModel> model = new SimpleObjectProperty<>();
	MainModel model = new MainModel();

	// View
	@FXML
	private GridPane view;

	@FXML
	private Label usuarioLabel;

	@FXML
	private Label contraseñaLabel;

	@FXML
	private TextField usuarioTf;

	@FXML
	private PasswordField contraseñaTf;

	@FXML
	private Button accederBt;

	@FXML
	private Button cancelarBt;

	@FXML
	private ImageView imageView;
	/**
	 * Método asociado al botón Acceder
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void onActionAcceder(ActionEvent event) throws IOException {

		tpvController=App.getTpvController();
		String encryptedPass = DigestUtils.md2Hex(model.getContraseña());
		tpvController.getModel().getUserList().addAll(Funciones.getUsers());
		boolean datosCorrectos = false;
		model.setUsuario(model.getUsuario().trim());
		for (Users user : tpvController.getModel().getUserList()) {
			if (user.getUsuario().equals(model.getUsuario()) && user.getPassword().equals(encryptedPass)) {
				datosCorrectos = true;
				if (user.isAdministrador())
					model.setAdministrador(true);
				tpvController.getTxtEmpleado().setText(user.getUsuario());
				tpvController.getTxtEmpleado().setEditable(false);
				App.getPrimaryStage().setScene(new Scene(tpvController.getView()));
				App.getPrimaryStage().setMaximized(true);
			}

		}
		if (!datosCorrectos) {
			model.setUsuario("");
			model.setContraseña("");
		}

	}

	@FXML
	void onActionCancelar(ActionEvent event) {

	}
	/**
	 * Constructor de la clase
	 * 
	 * @throws IOException
	 */
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VistaInicioSesion.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		model.addListener((o, ov, nv) -> onInicioSesionChanged(o, ov, nv));
//		
//		model.set(new MainModel());

		model.usuarioProperty().bindBidirectional(usuarioTf.textProperty());
		model.contraseñaProperty().bindBidirectional(contraseñaTf.textProperty());

		imagenTransition();

	}
	/**
	 * 
	 * @return
	 */
	public MainModel getModel() {
		return model;
	}
	/**
	 * 
	 * @param model
	 */
	public void setModel(MainModel model) {
		this.model = model;
	}
	/**
	 * Método para la transición de la imagen
	 */
	private void imagenTransition() {
		/*
		 * RotateTransition rt = new RotateTransition(); rt.setNode(imageView);
		 * rt.setFromAngle(0); rt.setToAngle(360);
		 * rt.setInterpolator(Interpolator.LINEAR);
		 * rt.setCycleCount(Timeline.INDEFINITE); rt.setDuration(new Duration(3000));
		 */

		/*
		 * imageView.setOnMouseClicked(me -> { Animation.Status status = rt.getStatus();
		 * if (status == Animation.Status.RUNNING && status != Animation.Status.PAUSED)
		 * rt.pause(); else rt.play(); });
		 */

		FadeTransition ft = new FadeTransition();
		ft.setNode(imageView);
		ft.setDuration(new Duration(2000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(10);
		ft.setAutoReverse(true);

		// imageView.setOnMouseClicked(me -> {
		Animation.Status status = ft.getStatus();
		if (status == Animation.Status.RUNNING && status != Animation.Status.PAUSED)
			ft.pause();
		else
			ft.play();
		// });
	}

//	
//	private void onInicioSesionChanged(ObservableValue<? extends MainModel> o, MainModel ov, MainModel nv) {
//
//	}
	/**
	 * 
	 * @return
	 */
	public GridPane getView() {
		return view;
	}

}
