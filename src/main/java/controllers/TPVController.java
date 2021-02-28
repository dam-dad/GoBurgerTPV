package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.RellenarDatos;
import goburgertpv.database.tables.Product;
import goburgertpv.database.tables.Productos;
import goburgertpv.utils.CustomButton;
import goburgertpv.utils.CustomHBox;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import models.TicketModel;
import models.VistaPrincipalModel;

public class TPVController implements Initializable {
	
	private ObjectProperty<VistaPrincipalModel> vistaTPV = new SimpleObjectProperty<>();

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
	private TableView<TicketModel> tableCuenta;

	@FXML
	private TableColumn<TicketModel, String> columnDescripcion;

	@FXML
	private TableColumn<TicketModel, Number> columnCant;

	@FXML
	private TableColumn<TicketModel, Number> columnTotal;

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
	private ScrollPane productosScrollPane;

	@FXML
	private VBox productosBox;

	private VistaPrincipalModel model = new VistaPrincipalModel();

	public TPVController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VistaPrincipal.fxml"));
		loader.setController(this);
		loader.load();
	}

	@FXML
	void onClickAplicarDescuento(ActionEvent event) {
		ArrayList<TicketModel> descuento = new ArrayList<TicketModel>();
		TicketModel ticket = new TicketModel();
		ticket.setDescripcion("Descuento");
		ticket.setCantidad(1);
		ticket.setTotal(-1.25);
		descuento.add(ticket);
		tableCuenta.getItems().addAll(descuento);
		btnDescuento.setDisable(true);
	}

	@FXML
    void onActionTotal(ActionEvent event) {
    	double total = 0;
		for (TicketModel item : tableCuenta.getItems()) {
			total = total + item.getTotal();
			total = Math.round(total*100.0)/100.0;
			txtTotalCuenta.setText(String.valueOf(total));
		}
    }
	
	@FXML
	void onClickAñadirCantidad(ActionEvent event) {
		int cantidad;
		TicketModel cant = tableCuenta.getSelectionModel().getSelectedItem();
		cantidad = cant.getCantidad();
		double total = tableCuenta.getSelectionModel().getSelectedItem().getTotal();
		double unidad = cant.getTotal()/cant.getCantidad();
		tableCuenta.getSelectionModel().getSelectedItem().setTotal(unidad+total);
		cant.setCantidad(cantidad+1);
	}

	@FXML
	void onClickBajarProducto(ActionEvent event) {
		int indice = tableCuenta.getSelectionModel().getSelectedIndex();
		tableCuenta.getSelectionModel().select(indice+1);
	}

	@FXML
	void onClickCancelarPedido(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION, "¿Desea cancelar el pedido?", ButtonType.YES, ButtonType.NO);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
			tableCuenta.getItems().clear();
		}
	}

	@FXML
	void onClickComplementos(ActionEvent event) {
		rellenarProductos(model.getComplementosList(), model.getComplementosButtonList());
	}

	@FXML
	void onClickConfiguracion(ActionEvent event) {

	}

	@FXML
	void onClickEliminarProducto(ActionEvent event) {
		tableCuenta.getItems().removeAll(tableCuenta.getSelectionModel().getSelectedItems());
	}

	@FXML
	void onClickEnviarCuenta(ActionEvent event) {

	}

	@FXML
	void onClickEnviarPdf(ActionEvent event) {

	}

	@FXML
	void onClickHamburguesas(ActionEvent event) {
		rellenarProductos(model.getHamburguesasList(), model.getHamburguesasButtonList());
	}

	@FXML
	void onClickHome(ActionEvent event) {
		productosBox.getChildren().clear();

	}

	@FXML
	void onClickMenus(ActionEvent event) {
		rellenarProductos(model.getMenusList(), model.getMenusButtonList());
	}

	@FXML
	void onClickModificarCuenta(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		
		dialog.setTitle("Modificar Cantidad");
		dialog.setHeaderText("Modificar Cantidad");
		dialog.setContentText("Cantidad:");
		
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		
		dialog.getDialogPane().lookupButton(ButtonType.OK).disableProperty().bind(
			dialog.getEditor().textProperty().isEmpty()
		);
		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			TicketModel ticket = tableCuenta.getSelectionModel().getSelectedItem();
			double unidad = ticket.getTotal()/ticket.getCantidad();
			ticket.setTotal(unidad*Integer.parseInt(result.get()));
			ticket.setCantidad(Integer.parseInt(result.get()));
		}
	}

	@FXML
	void onClickPagarCuenta(ActionEvent event) {
		double total = 0;
		for (TicketModel item : tableCuenta.getItems()) {
			total = total + item.getTotal();
			total = Math.round(total*100.0)/100.0;
			txtTotalCuenta.setText(String.valueOf(total));
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pedido completado");
		alert.setHeaderText("Pedido finalizado");
		alert.setContentText("El pedido se ha completado");
		alert.showAndWait();
		tableCuenta.getItems().clear();
	}

	@FXML
	void onClickParaLlevar(ActionEvent event) {
		ArrayList<TicketModel> llevar = new ArrayList<TicketModel>();
		TicketModel ticket = new TicketModel();
		ticket.setDescripcion("Bolsa");
		ticket.setCantidad(1);
		ticket.setTotal(0.10);
		llevar.add(ticket);
		tableCuenta.getItems().addAll(llevar);
		btnParaLlevar.setDisable(true);
	}

	@FXML
	void onClickPostres(ActionEvent event) {
		rellenarProductos(model.getPostresList(), model.getPostresButtonList());
	}

	@FXML
	void onClickQuitarCantidad(ActionEvent event) {
		int cantidad;
		TicketModel cant = tableCuenta.getSelectionModel().getSelectedItem();
		cantidad = cant.getCantidad();
		if (cantidad < 1 || cantidad == 1) {
			tableCuenta.getItems().removeAll(tableCuenta.getSelectionModel().getSelectedItems());
		} else {
			double total = tableCuenta.getSelectionModel().getSelectedItem().getTotal();
			double unidad = cant.getTotal()/cant.getCantidad();
			tableCuenta.getSelectionModel().getSelectedItem().setTotal(total-unidad);
			cant.setCantidad(cantidad-1);
		}
	}

	@FXML
	void onClickRefrescos(ActionEvent event) {
		rellenarProductos(model.getBebidasList(), model.getBebidasButtonList());
	}

	public VistaPrincipalModel getModel() {
		return model;
	}

	public void setModel(VistaPrincipalModel model) {
		this.model = model;
	}

	@FXML
	void onClickSalir(ActionEvent event) {

	}

	@FXML
	void onClickSubirProducto(ActionEvent event) {
		int indice = tableCuenta.getSelectionModel().getSelectedIndex();
		tableCuenta.getSelectionModel().select(indice-1);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnDescripcion.setCellValueFactory(v -> v.getValue().descripcionProperty());
		columnTotal.setCellValueFactory(v -> v.getValue().totalProperty());
		columnCant.setCellValueFactory(v -> v.getValue().cantidadProperty());

        columnDescripcion.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTotal.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        columnCant.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        this.vistaTPV.addListener((o, ov, nv) -> onVistaChanged(o, ov, nv));
        
		productosScrollPane.setStyle("-fx-background-image:url('/images/logo3sin.png');-fx-background-size: contain;\n"
				+ "-fx-background-repeat: no-repeat;\n" + "-fx-background-position: center;");
		productosScrollPane.setFitToWidth(true);

		if (Funciones.getProductos().isEmpty())
			RellenarDatos.rellenar();

		List<Productos> productosList = Funciones.getProductos();
		ArrayList<Productos> bebidasList = new ArrayList<Productos>();
		ArrayList<Productos> hamburguesasList = new ArrayList<Productos>();
		ArrayList<Productos> complementosList = new ArrayList<Productos>();
		ArrayList<Productos> menusList = new ArrayList<Productos>();
		ArrayList<Productos> postresList = new ArrayList<Productos>();

		for (Productos producto : productosList) {
			switch (producto.getProductType()) {
			case bebida: {
				bebidasList.add(producto);
				model.getBebidasButtonList().add(new CustomButton(producto.getNombre()));
				break;
			}
			case complemento: {
				complementosList.add(producto);
				model.getComplementosButtonList().add(new CustomButton(producto.getNombre()));
				break;
			}
			case hamburguesa: {
				hamburguesasList.add(producto);
				model.getHamburguesasButtonList().add(new CustomButton(producto.getNombre()));
				break;
			}
			case menu: {
				menusList.add(producto);
				model.getMenusButtonList().add(new CustomButton(producto.getNombre()));
				break;
			}
			case postre: {
				postresList.add(producto);
				model.getPostresButtonList().add(new CustomButton(producto.getNombre()));
				break;
			}
			}
		}

		model.getBebidasList().addAll(bebidasList);

		model.getComplementosList().addAll(complementosList);

		model.getHamburguesasList().addAll(hamburguesasList);

		model.getMenusList().addAll(menusList);
		
		model.getPostresList().addAll(postresList);

	}

	private Object onVistaChanged(ObservableValue<? extends VistaPrincipalModel> o, VistaPrincipalModel ov,
			VistaPrincipalModel nv) {
		// TODO Auto-generated method stub
		return null;
	}

	private void rellenarProductos(ObservableList<Productos> productosList, ObservableList<CustomButton> buttonList) {
		productosBox.getChildren().clear();
		ArrayList<CustomHBox> rows = new ArrayList<CustomHBox>();

		int i = 0, j = 0, n = 0;
		for (i = 0, n = 0; n < buttonList.size(); i++) {
			rows.add(new CustomHBox());

			for (j = 0; n < buttonList.size() && j < 5; j++, n++) {
				rows.get(i).getChildren().add(buttonList.get(n));
				Productos producto = productosList.get(n);
				buttonList.get(n).setOnAction(e -> onProductoButtonAction(producto));
			}
			rows.get(i).spacingProperty().bind(productosScrollPane.widthProperty()
					.subtract(buttonList.get(0).widthProperty().multiply(5)).divide(5));

		}
		productosBox.getChildren().addAll(rows);
	}

	private void onProductoButtonAction(Productos producto) {
		TicketModel ticketActual = new TicketModel(producto);
		tableCuenta.getItems().addAll(ticketActual);
	}

	public BorderPane getView() {
		return view;
	}

}