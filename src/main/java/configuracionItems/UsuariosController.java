package configuracionItems;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import goburgertpv.database.connection.Funciones;
import goburgertpv.database.tables.Productos;
import goburgertpv.database.tables.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.VistaPrincipalModel;

public class UsuariosController implements Initializable {
	
	//model
	private AnadirUsuarioController anadir = new AnadirUsuarioController();
	private IntegerProperty seleccionado = new SimpleIntegerProperty();
	private ArrayList<Users> listaUsers = new ArrayList<Users>();
	
	// view
	@FXML
	private GridPane view;
	 
	@FXML
	private Button btnAnadir;

	@FXML
	private Button btnEliminar;

	@FXML
	private ListView<ArrayList<Users>> listUsuarios;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//listaUsers = VistaPrincipalModel.getUserList();
		listUsuarios.getItems().addAll(listaUsers);
		//listUsuarios.itemsProperty().bind(listaUsers);
		
		seleccionado.bind(listUsuarios.getSelectionModel().selectedIndexProperty());
	}
	
	public UsuariosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vistasConfiguracion/Usuarios.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@FXML
	void onClickAñadirUsuario(ActionEvent event) {
		Stage ventana = new Stage();
		Scene escena = new Scene(anadir.getView());
		ventana.setScene(escena);
		ventana.setTitle("GoBurgerTPV");
		ventana.getIcons().add(new Image("/images/logoMini.png"));
		ventana.show();
	}

	@FXML
	void onClickEliminarUsuario(ActionEvent event) {
		Users usuarioBorrar = new Users();
		usuarioBorrar = listaUsers.get(seleccionado.get());
		
		listaUsers.remove(seleccionado.get());
	}
	
	public GridPane getView() {
		return view;
	}

}
