package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import models.InicioSesion;

public class MainController implements Initializable {

	// Controllers
	
	
	// Model
	private ObjectProperty<InicioSesion> model = new SimpleObjectProperty<>();
	
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
    private TextField contraseñaTf;

    @FXML
    private Button accederBt;

    @FXML
    private Button cancelarBt;

    @FXML
    void onActionAcceder(ActionEvent event) {

    }

    @FXML
    void onActionCancelar(ActionEvent event) {

    }
    
    
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VistaInicioSesion.fxml"));
		loader.setController(this);
		loader.load();
	}
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.addListener((o, ov, nv) -> onInicioSesionChanged(o, ov, nv));
		
		model.set(new InicioSesion());
	}

	
	private void onInicioSesionChanged(ObservableValue<? extends InicioSesion> o, InicioSesion ov, InicioSesion nv) {

	}

	
	public GridPane getView() {
		return view;
	}

}
