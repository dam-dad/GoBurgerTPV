package controllers;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import goburgertpv.App;
import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.RellenarDatos;
import goburgertpv.database.tables.Product;
import goburgertpv.database.tables.Productos;
import goburgertpv.utils.CustomButton;
import goburgertpv.utils.CustomHBox;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.scene.image.Image;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
    	
		
    }
	
	@FXML
	void onClickAñadirCantidad(ActionEvent event) {
		try {
			int cantidad;
			TicketModel cant = tableCuenta.getSelectionModel().getSelectedItem();
			cantidad = cant.getCantidad();
			double total = tableCuenta.getSelectionModel().getSelectedItem().getTotal();
			double unidad = cant.getTotal()/cant.getCantidad();
			tableCuenta.getSelectionModel().getSelectedItem().setTotal(unidad+total);
			cant.setCantidad(cantidad+1);
			model.setTotalCuentaText(model.getTotalCuentaText()+unidad);
		}catch(Exception e){}
		
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
			model.setTotalCuentaText(0);
		}
	}

	@FXML
	void onClickComplementos(ActionEvent event) {
		rellenarProductos(model.getComplementosList(), model.getComplementosButtonList());
	}

	@FXML
	void onClickConfiguracion(ActionEvent event) {
		Stage configStage =new Stage();
		Scene scene=App.getConfiguracionController().getScene();
		configStage.setScene(scene);
		configStage.setTitle("Configuración");
		configStage.getIcons().add(new Image("/images/logoMini.png"));
		configStage.show();
	}

	@FXML
	void onClickEliminarProducto(ActionEvent event) {
		model.setTotalCuentaText(model.getTotalCuentaText()-tableCuenta.getSelectionModel().getSelectedItem().getTotal());
		tableCuenta.getItems().removeAll(tableCuenta.getSelectionModel().getSelectedItems());
	}

	@FXML
	void onClickEnviarCuenta(ActionEvent event) {

	}

	@FXML
	void onClickEnviarPdf(ActionEvent event) throws JRException, IOException {
		JasperPrint print = null;
		JasperReport report = JasperCompileManager.compileReport(TPVController.class.getResourceAsStream("/reports/goburger_report.jrxml"));		
		Map<String, Object> parameters = new HashMap<String, Object>();
		// BufferedImage image = ImageIO.read(getClass().getResource("/images/logo3.png"));
		// parameters.put("Image", image );
		print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(model.getBebidasList()));
		JasperExportManager.exportReportToPdfFile(print, "Bebidas.pdf");    
		Desktop.getDesktop().open(new File("Bebidas.pdf"));
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
			model.setTotalCuentaText(model.getTotalCuentaText()-ticket.getTotal());
			double unidad = ticket.getTotal()/ticket.getCantidad();
			ticket.setTotal(unidad*Integer.parseInt(result.get()));
			ticket.setCantidad(Integer.parseInt(result.get()));
			model.setTotalCuentaText(model.getTotalCuentaText()+ticket.getTotal());
		}
	}

	@FXML
	void onClickPagarCuenta(ActionEvent event) {
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pedido completado");
		alert.setHeaderText("Pedido finalizado");
		alert.setContentText("El pedido se ha completado");
		alert.showAndWait();
		tableCuenta.getItems().clear();
		model.setTotalCuentaText(0);
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
		model.setTotalCuentaText(model.getTotalCuentaText()+0.1);
		btnParaLlevar.setDisable(true);
	}

	@FXML
	void onClickPostres(ActionEvent event) {
		rellenarProductos(model.getPostresList(), model.getPostresButtonList());
	}

	@FXML
	void onClickQuitarCantidad(ActionEvent event) {
		int cantidad;
		try {
			TicketModel cant = tableCuenta.getSelectionModel().getSelectedItem();
			cantidad = cant.getCantidad();
			double total = tableCuenta.getSelectionModel().getSelectedItem().getTotal();
			double unidad = cant.getTotal()/cant.getCantidad();
			if (cantidad < 1 || cantidad == 1) {
				tableCuenta.getItems().removeAll(tableCuenta.getSelectionModel().getSelectedItems());
			} else {
				
				tableCuenta.getSelectionModel().getSelectedItem().setTotal(total-unidad);
				cant.setCantidad(cantidad-1);
				
			}
			
			model.setTotalCuentaText(model.getTotalCuentaText()-unidad);
		}catch(Exception e) {}

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
		
		Bindings.bindBidirectional(txtTotalCuenta.textProperty(), model.totalCuentaTextProperty() ,new NumberStringConverter());

		
		txtTotalCuenta.setEditable(false);
		txtTotalCuenta.setAlignment(Pos.CENTER);
		
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

		//if (Funciones.getProductos().isEmpty())
			//RellenarDatos.rellenar();

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
				model.getBebidasButtonList().add(new CustomButton(producto.getPrecio(), "http://localhost/goburgertpv/images/bebidas/"+producto.getProductType()+producto.getId()+".png"));
				break;
			}
			case complemento: {
				complementosList.add(producto);
				model.getComplementosButtonList().add(new CustomButton(producto.getPrecio(), "http://localhost/goburgertpv/images/complementos/"+producto.getProductType()+producto.getId()+".png"));
				break;
			}
			case hamburguesa: {
				hamburguesasList.add(producto);
				model.getHamburguesasButtonList().add(new CustomButton(producto.getPrecio(), "http://localhost/goburgertpv/images/hamburguesas/"+producto.getProductType()+producto.getId()+".png"));
				break;
			}
			case menu: {
				menusList.add(producto);
				model.getMenusButtonList().add(new CustomButton(producto.getPrecio(), "http://localhost/goburgertpv/images/menus/"+producto.getProductType()+producto.getId()+".png"));
				break;
			}
			case postre: {
				postresList.add(producto);
				model.getPostresButtonList().add(new CustomButton(producto.getPrecio(), "http://localhost/goburgertpv/images/postres/"+producto.getProductType()+producto.getId()+".png"));
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

	public TextField getTxtEmpleado() {
		return txtEmpleado;
	}

	public void setTxtEmpleado(TextField txtEmpleado) {
		this.txtEmpleado = txtEmpleado;
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
		model.setTotalCuentaText(model.getTotalCuentaText()+producto.getPrecio());
	}

	public BorderPane getView() {
		return view;
	}

}