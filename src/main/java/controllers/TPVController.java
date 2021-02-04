package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
				Complementos complemento=VistaPrincipalModel.getComplementosList().get(n);
				model.getBebidasButtonList().get(n).setOnAction(e->onComplementoButtonAction(complemento));
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
				Hamburguesas hamburguesa=VistaPrincipalModel.getHamburguesasList().get(n);
				model.getBebidasButtonList().get(n).setOnAction(e->onHamburguesaButtonAction(hamburguesa));
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
				Menus menu=VistaPrincipalModel.getMenusList().get(n);
				model.getBebidasButtonList().get(n).setOnAction(e->onMenuButtonAction(menu));
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
				Postres postre=VistaPrincipalModel.getPostresList().get(n);
				model.getBebidasButtonList().get(n).setOnAction(e->onPostreButtonAction(postre));
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
				Bebidas bebida=VistaPrincipalModel.getBebidasList().get(n);
				model.getBebidasButtonList().get(n).setOnAction(e->onBebidaButtonAction(bebida));
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

		gridPaneProductos.setStyle("-fx-background-image:url('/images/logo3sin.png');-fx-background-size: contain;\n"
				+ "-fx-background-repeat: no-repeat;\n"
				+ "-fx-background-position: center;");
		
		if (Funciones.getBebidas().isEmpty())
			RellenarDatos.rellenar(Funciones.getSession());

		VistaPrincipalModel.getBebidasList().addAll(Funciones.getBebidas()); 
		for (Bebidas bebida : VistaPrincipalModel.getBebidasList()) {
			model.getBebidasButtonList().add(new Button(bebida.getNombre()));
		}
		VistaPrincipalModel.getComplementosList().addAll(Funciones.getComplementos());
		for (Complementos complemento : VistaPrincipalModel.getComplementosList()) {
			model.getComplementosButtonList().add(new Button(complemento.getNombre()));
		}
		VistaPrincipalModel.getHamburguesasList().addAll(Funciones.getHamburguesas());
		for (Hamburguesas hamburguesa : VistaPrincipalModel.getHamburguesasList()) {
			model.getHamburguesasButtonList().add(new Button(hamburguesa.getNombre()));
		}
		VistaPrincipalModel.getMenusList().addAll(Funciones.getMenus());
		for (Menus menu : VistaPrincipalModel.getMenusList()) {
			model.getMenusButtonList().add(new Button(menu.getNombre()));

		}
		VistaPrincipalModel.getPostresList().addAll(Funciones.getPostres());
		for (Postres postre : VistaPrincipalModel.getPostresList()) {
			model.getPostresButtonList().add(new Button(postre.getNombre()));
		}

		
		
	
	
		

	}
	
	

	private void onPostreButtonAction(Postres postre) {
	}

	private void onMenuButtonAction(Menus menu) {
	}

	private void onHamburguesaButtonAction(Hamburguesas hamburguesa) {
	}

	private void onComplementoButtonAction(Complementos complemento) {
	}

	private void onBebidaButtonAction(Bebidas bebidas) {
		Alert successAlert = new Alert(AlertType.INFORMATION);
		successAlert.setTitle(bebidas.getNombre());
		successAlert.setHeaderText("Acceso permitido");
		successAlert.setContentText(bebidas.getDescription()+" "+bebidas.getPrecio());

		successAlert.showAndWait();	
	
	}

	public BorderPane getView() {
		return view;
	}

}
