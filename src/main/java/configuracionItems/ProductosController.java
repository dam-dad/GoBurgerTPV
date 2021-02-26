package configuracionItems;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.RellenarDatos;
import goburgertpv.database.tables.Productos;
import goburgertpv.database.tables.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

public class ProductosController implements Initializable {

	// model
	private AnadirProductosController anadir = new AnadirProductosController();
	private IntegerProperty seleccionado = new SimpleIntegerProperty();
	private ArrayList<Productos> listaBebidas = new ArrayList<Productos>();
	private ArrayList<Productos> listaComplementos = new ArrayList<Productos>();
	private ArrayList<Productos> listaHamburguesas = new ArrayList<Productos>();
	private ArrayList<Productos> listaMenus = new ArrayList<Productos>();
	private ArrayList<Productos> listaPostres = new ArrayList<Productos>();

	// view
	@FXML
	private GridPane view;

	@FXML
	private Button btnAnadir;

	@FXML
	private Button btnEliminar;

	@FXML
	private ListView<ArrayList<Productos>> listProducto;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (Funciones.getProductos().isEmpty())
			RellenarDatos.rellenar();
		listaBebidas = VistaPrincipalModel.getBebidasList();
		listaComplementos = VistaPrincipalModel.getComplementosList();
		listaHamburguesas = VistaPrincipalModel.getHamburguesasList();
		listaMenus = VistaPrincipalModel.getMenusList();
		listaPostres = VistaPrincipalModel.getPostresList();
		listProducto.getItems().addAll(listaBebidas, listaComplementos, listaHamburguesas, listaMenus, listaPostres);
	}

	public ProductosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vistasConfiguracion/Productos.fxml"));
		loader.setController(this);
		loader.load();
	}

	@FXML
	void onClickAñadirProducto(ActionEvent event) {
		Stage ventana = new Stage();
		Scene escena = new Scene(anadir.getView());
		ventana.setScene(escena);
		ventana.setTitle("GoBurgerTPV");
		ventana.getIcons().add(new Image("/images/logoMini.png"));
		ventana.show();
	}

	@FXML
	void onClickEliminarProducto(ActionEvent event) {
		
	}
	
	public GridPane getView() {
		return view;
	}
	
}
