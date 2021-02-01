package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.RellenarDatos;
import goburgertpv.database.tables.Bebidas;
import goburgertpv.database.tables.Complementos;
import goburgertpv.database.tables.Hamburguesas;
import goburgertpv.database.tables.Menus;
import goburgertpv.database.tables.Postres;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.VistaPrincipalModel;

public class TPVController implements Initializable {

	@FXML
	private BorderPane view;

	@FXML
	private GridPane gridPaneCuenta;

	@FXML
	private TextField txtTotalCuenta;

	@FXML
	private Button btnEnviarPdf;

	@FXML
	private Button btnEnviarCuenta;

	@FXML
	private Button btnFlechaArriba;

	@FXML
	private Button btnFlechaAbajo;

	@FXML
	private Button btnMas;

	@FXML
	private Button btnMenos;

	@FXML
	private TableView<?> tableCuenta;

	@FXML
	private TableColumn<?, ?> columnDescripcion;

	@FXML
	private TableColumn<?, ?> columnCant;

	@FXML
	private TableColumn<?, ?> columnTotal;

	@FXML
	private Button btnModificar;

	@FXML
	private Button btnParaLlevar;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnDescuento;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalir;

	@FXML
	private Button btnPagar;

	@FXML
	private TextField txtPrecioSin;

	@FXML
	private TextField txtDescuentoAplicado;

	@FXML
	private TextField txtIgic;

	@FXML
	private TextField txtEmpleado;

	@FXML
	private TextField txtDiaHora;

	@FXML
	private GridPane gridPaneMenuProductos;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnConfiguracion;

	@FXML
	private Button btnHamburguesas;

	@FXML
	private Button btnComplementos;

	@FXML
	private Button btnRefrescos;

	@FXML
	private Button btnPostres;

	@FXML
	private Button btnMenus;

	@FXML
	private AnchorPane anchorPaneProductosLogo;

	@FXML
	private GridPane gridPaneProductos;

	private VistaPrincipalModel model = new VistaPrincipalModel();

	public TPVController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VistaPrincipal.fxml"));
		loader.setController(this);
		loader.load();
	}

	@FXML
	void onClickAplicarDescuento(ActionEvent event) {

	}

	@FXML
	void onClickAñadirCantidad(ActionEvent event) {

	}

	@FXML
	void onClickBajarProducto(ActionEvent event) {

	}

	@FXML
	void onClickCancelarPedido(ActionEvent event) {

	}

	@FXML
	void onClickComplementos(ActionEvent event) {

		gridPaneProductos.getChildren().clear();
		for (int i = 0, n = 0; n < model.getComplementosButtonList().size() && i < gridPaneProductos.getRowCount(); i++)
			for (int j = 0; n < model.getComplementosButtonList().size()
					&& j < gridPaneProductos.getColumnCount(); j++, n++) {
				gridPaneProductos.add(model.getComplementosButtonList().get(n), j, i);
			}
	}

	@FXML
	void onClickConfiguracion(ActionEvent event) {

	}

	@FXML
	void onClickEliminarProducto(ActionEvent event) {

	}

	@FXML
	void onClickEnviarCuenta(ActionEvent event) {

	}

	@FXML
	void onClickEnviarPdf(ActionEvent event) {

	}

	@FXML
	void onClickHamburguesas(ActionEvent event) {

		gridPaneProductos.getChildren().clear();
		for (int i = 0, n = 0; n < model.getHamburguesasButtonList().size() && i < gridPaneProductos.getRowCount(); i++)
			for (int j = 0; n < model.getHamburguesasButtonList().size()
					&& j < gridPaneProductos.getColumnCount(); j++, n++) {
				gridPaneProductos.add(model.getHamburguesasButtonList().get(n), j, i);
			}

	}

	@FXML
	void onClickHome(ActionEvent event) {
		gridPaneProductos.getChildren().clear();

	}

	@FXML
	void onClickMenus(ActionEvent event) {
		gridPaneProductos.getChildren().clear();
		for (int i = 0, n = 0; n < model.getMenusButtonList().size() && i < gridPaneProductos.getRowCount(); i++)
			for (int j = 0; n < model.getMenusButtonList().size() && j < gridPaneProductos.getColumnCount(); j++, n++) {
				gridPaneProductos.add(model.getMenusButtonList().get(n), j, i);
			}

	}

	@FXML
	void onClickModificarCuenta(ActionEvent event) {

	}

	@FXML
	void onClickPagarCuenta(ActionEvent event) {

	}

	@FXML
	void onClickParaLlevar(ActionEvent event) {

	}

	@FXML
	void onClickPostres(ActionEvent event) {
		gridPaneProductos.getChildren().clear();
		for (int i = 0, n = 0; n < model.getPostresButtonList().size() && i < gridPaneProductos.getRowCount(); i++)
			for (int j = 0; n < model.getPostresButtonList().size()
					&& j < gridPaneProductos.getColumnCount(); j++, n++) {
				gridPaneProductos.add(model.getPostresButtonList().get(n), j, i);
			}

	}

	@FXML
	void onClickQuitarCantidad(ActionEvent event) {

	}

	@FXML
	void onClickRefrescos(ActionEvent event) {

		gridPaneProductos.getChildren().clear();
		for (int i = 0, n = 0; n < model.getBebidasButtonList().size() && i < gridPaneProductos.getRowCount(); i++)
			for (int j = 0; n < model.getBebidasButtonList().size()
					&& j < gridPaneProductos.getColumnCount(); j++, n++) {
				gridPaneProductos.add(model.getBebidasButtonList().get(n), j, i);
			}

	}

	@FXML
	void onClickSalir(ActionEvent event) {

	}

	@FXML
	void onClickSubirProducto(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (Funciones.getBebidas().isEmpty())
			RellenarDatos.rellenar(Funciones.getSession());

		List<Bebidas> bebidas = Funciones.getBebidas();
		for (Bebidas bebida : bebidas) {
			model.getBebidasButtonList().add(new Button(bebida.getNombre()));
		}
		List<Complementos> complementos = Funciones.getComplementos();
		for (Complementos complemento : complementos) {
			model.getComplementosButtonList().add(new Button(complemento.getNombre()));
		}
		List<Hamburguesas> hamburguesas = Funciones.getHamburguesas();
		for (Hamburguesas hamburguesa : hamburguesas) {
			model.getHamburguesasButtonList().add(new Button(hamburguesa.getNombre()));
		}
		List<Menus> menus = Funciones.getMenus();
		for (Menus menu : menus) {
			model.getMenusButtonList().add(new Button(menu.getNombre()));
		}
		List<Postres> postres = Funciones.getPostres();
		for (Postres postre : postres) {
			model.getPostresButtonList().add(new Button(postre.getNombre()));
		}

		gridPaneProductos.setStyle("-fx-background-image:url('/images/logo3sin.png');-fx-background-size: contain;\n"
				+ "-fx-background-repeat: no-repeat;\n"
				+ "-fx-background-position: center;");
	}

	public BorderPane getView() {
		return view;
	}

}
