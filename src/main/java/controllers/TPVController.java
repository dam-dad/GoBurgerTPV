package controllers;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

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
import javafx.beans.property.Property;
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
import models.Ticket;
import models.TicketModel;
import models.VistaPrincipalModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 * Controller de la Vista Principal
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class TPVController implements Initializable {
	
	private ObjectProperty<VistaPrincipalModel> vistaTPV = new SimpleObjectProperty<>();

	// View
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
	
	/**
	 * Constructor de la clase
	 * 
	 * @throws IOException
	 */
	public TPVController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VistaPrincipal.fxml"));
		loader.setController(this);
		loader.load();
	}

	/**
	 * Método asociado al botón Descuento. Añade a la tableCuenta un item descuento y resta su valor al precio total
	 * 
	 * @param event
	 */
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
	
	/**
	 * Método asociado al botón Añadir. Suma 1 a la cantidad del producto seleccionado el tableCuenta y añade el coste correspondiente
	 * 
	 * @param event 
	 */
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
			model.setPrecioSinTaxText(model.getPrecioSinTaxText()+unidad);
		}catch(Exception e){}
		
	}
	/**
	 * Método asociado al botón Bajar. Botón de navegación de tableCuenta, baja 1 la posición
	 * 
	 * @param event
	 */
	@FXML
	void onClickBajarProducto(ActionEvent event) {
		int indice = tableCuenta.getSelectionModel().getSelectedIndex();
		tableCuenta.getSelectionModel().select(indice+1);
	}

	/**
	 * Método asociado al botón Cancelar. Elimina todos los items de tableCuenta  y pone el precio total a 0
	 * 
	 * @param event
	 */
	@FXML
	void onClickCancelarPedido(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION, "¿Desea cancelar el pedido?", ButtonType.YES, ButtonType.NO);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
			tableCuenta.getItems().clear();
			model.setPrecioSinTaxText(0);
		}
	}
	/**
	 * llama a rellenarProductos
	 * 
	 * @param event
	 */
	@FXML
	void onClickComplementos(ActionEvent event) {
		rellenarProductos(model.getComplementosList(), model.getComplementosButtonList());
	}
	/**
	 * Método asociado al botón Configuración. Abre un stage con la vista de configuración
	 * 
	 * @param event
	 */
	@FXML
	void onClickConfiguracion(ActionEvent event) {
		Stage configStage =new Stage();
		Scene scene=App.getConfiguracionController().getScene();
		configStage.setScene(scene);
		configStage.setTitle("Configuración");
		configStage.getIcons().add(new Image("/images/logoMini.png"));
		configStage.show();
	}
	/**
	 * Método asociado al botón Eliminar. Elimina el producto seleccionado de la tabla tableCuenta
	 * 
	 * @param event
	 */
	@FXML
	void onClickEliminarProducto(ActionEvent event) {
		model.setPrecioSinTaxText(model.getPrecioSinTaxText()-tableCuenta.getSelectionModel().getSelectedItem().getTotal());
		if (tableCuenta.getSelectionModel().getSelectedItem().getDescripcion() == "Descuento") {
			btnDescuento.setDisable(false);
		} else if (tableCuenta.getSelectionModel().getSelectedItem().getDescripcion() == "Bolsa") {
			btnParaLlevar.setDisable(false);
		}
		tableCuenta.getItems().removeAll(tableCuenta.getSelectionModel().getSelectedItems());
	}

	@FXML
	void onClickEnviarCuenta(ActionEvent event) {

	}
	/**
	 * Método asociado al botón PDF
	 * 
	 * Genera un report a partir de los items de tableCuenta y genera un pdf en la raiz 
	 * 
	 * @param event
	 * @throws JRException
	 * @throws IOException
	 */
	@FXML
	void onClickEnviarPdf(ActionEvent event) throws JRException, IOException {
		
		rellenarTicket();
		JasperPrint print = null;
		JasperReport report = JasperCompileManager.compileReport(TPVController.class.getResourceAsStream("/reports/Ticket.jrxml"));		
		Map<String, Object> parameters = new HashMap<String, Object>();
		//BufferedImage image = ImageIO.read(getClass().getResource("/reports/logo3.png"));
		parameters.put("logo", TPVController.class.getResource("/images/logo3.png").toExternalForm());
		print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(model.getTicketList()));
		JasperExportManager.exportReportToPdfFile(print, "Ticket.pdf");    
		Desktop.getDesktop().open(new File("Ticket.pdf"));
	}
	/**
	 * Rellena la lista de tickets necesaria paraa generar el reporte
	 */
	private void rellenarTicket() {
		for (TicketModel ticket : tableCuenta.getItems()) {
			Ticket producto=new Ticket();
			producto.setCantidad(ticket.getCantidad());
			producto.setDescripcion(ticket.getDescripcion());
			producto.setPrecio( Math.round(ticket.getTotal()*100.0)/100.0);	
			producto.setTotalSin(Math.round(model.getPrecioSinTaxText()*100.0)/100.0);
			producto.setTotal(model.getTotalFormateado());
			
			model.getTicketList().add(producto);
		}
	}

	/**
	 * Rellena el scroll view con los botones de VistaPrincipalModel.getHamburguesasButtonList()
	 * 
	 * @param event
	 */
	@FXML
	void onClickHamburguesas(ActionEvent event) {
		rellenarProductos(model.getHamburguesasList(), model.getHamburguesasButtonList());
	}
	/**
	 * Método asociado al botón Home
	 * Vacía el contenido del scrollView
	 * 
	 * @param event
	 */
	@FXML
	void onClickHome(ActionEvent event) {
		productosBox.getChildren().clear();

	}
	/**
	 * Rellena el scroll view con los botones de VistaPrincipalModel.getMenusButtonList()
	 * 
	 * @param event
	 */
	@FXML
	void onClickMenus(ActionEvent event) {
		rellenarProductos(model.getMenusList(), model.getMenusButtonList());
	}
	/**
	 * Método asociado al botón Modificar
	 * 
	 * Pregunta la cantidad que se quiera añadir del producto seleccionado
	 * 
	 * @param event
	 */
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
			model.setPrecioSinTaxText(model.getPrecioSinTaxText()-ticket.getTotal());
			double unidad = ticket.getTotal()/ticket.getCantidad();
			ticket.setTotal(unidad*Integer.parseInt(result.get()));
			ticket.setCantidad(Integer.parseInt(result.get()));
			model.setPrecioSinTaxText(model.getPrecioSinTaxText()+ticket.getTotal());
		}
	}
	/**
	 * Método asociado al botón Pagar
	 * 
	 * @param event
	 */
	@FXML
	void onClickPagarCuenta(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pedido completado");
		alert.setHeaderText("Pedido finalizado");
		alert.setContentText("El pedido se ha completado");
		alert.showAndWait();
		tableCuenta.getItems().clear();
		model.setPrecioSinTaxText(0);
	}
	/**
	 * Método asociado al botón Para Llevar
	 * 
	 * @param event
	 */
	@FXML
	void onClickParaLlevar(ActionEvent event) {
		ArrayList<TicketModel> llevar = new ArrayList<TicketModel>();
		TicketModel ticket = new TicketModel();
		ticket.setDescripcion("Bolsa");
		ticket.setCantidad(1);
		ticket.setTotal(0.10);
		llevar.add(ticket);
		tableCuenta.getItems().addAll(llevar);
		model.setPrecioSinTaxText(model.getPrecioSinTaxText()+0.1);
		btnParaLlevar.setDisable(true);
	}
	/**
	 * 
	 * 
	 * @param event
	 */
	@FXML
	void onClickPostres(ActionEvent event) {
		rellenarProductos(model.getPostresList(), model.getPostresButtonList());
	}
	/** 
	 * Método asociado al botón Quitar
	 * 
	 * @param event
	 */
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
			
			model.setPrecioSinTaxText(model.getPrecioSinTaxText()-unidad);
		}catch(Exception e) {}

	}
	/**
	 * 
	 * 
	 * @param event
	 */
	@FXML
	void onClickRefrescos(ActionEvent event) {
		rellenarProductos(model.getBebidasList(), model.getBebidasButtonList());
	}
	/**
	 * 
	 * 
	 * @return
	 */
	public VistaPrincipalModel getModel() {
		return model;
	}
	/**
	 * 
	 * 
	 * @param model
	 */
	public void setModel(VistaPrincipalModel model) {
		this.model = model;
	}

	@FXML
	void onClickSalir(ActionEvent event) {

	}
	/**
	 * Método asociado en el botón Subir
	 * 
	 * @param event
	 */
	@FXML
	void onClickSubirProducto(ActionEvent event) {
		int indice = tableCuenta.getSelectionModel().getSelectedIndex();
		tableCuenta.getSelectionModel().select(indice-1);
	}
/**
 * Inicializa la clase.
 * Se añade listeners y bindeos necesarios
 */
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnEnviarCuenta.setDisable(true);
		model.setIgicText(7);
		txtIgic.textProperty().bind(model.igicTextProperty().asString());
		
		txtIgic.setEditable(false);
		Bindings.bindBidirectional(txtPrecioSin.textProperty(), model.precioSinTaxTextProperty() ,new NumberStringConverter());
		
		
		model.totalCuentaTextProperty().bind( model.precioSinTaxTextProperty().add(model.precioSinTaxTextProperty().multiply( model.igicTextProperty()).divide(100)));
		
		model.totalCuentaTextProperty().addListener((o,ov,nv)->{
			DecimalFormat df = new DecimalFormat("0.00");
			model.setTotalFormateado(df.format(nv)+" €");
			
		});
		
		txtTotalCuenta.textProperty().bind(model.totalFormateadoProperty());
		
		
		
		
		
		
		txtPrecioSin.setEditable(false);
		txtTotalCuenta.setEditable(false);
		txtTotalCuenta.setAlignment(Pos.CENTER);
		
		
		
		columnDescripcion.setCellValueFactory(v -> v.getValue().descripcionProperty());
		columnTotal.setCellValueFactory(v -> v.getValue().totalProperty());
		columnCant.setCellValueFactory(v -> v.getValue().cantidadProperty());

        columnDescripcion.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTotal.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        columnCant.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        
		productosScrollPane.setStyle("-fx-background-image:url('/images/logo3sin.png');-fx-background-size: contain;\n"
				+ "-fx-background-repeat: no-repeat;\n" + "-fx-background-position: center;");
		productosScrollPane.setFitToWidth(true);

		//if (Funciones.getProductos().isEmpty())
			//RellenarDatos.rellenar();

		rellenarListasProductos();

	}
/**
 * Rellena las listas de productos según los datos recibidos de la base de datos, además de añadir las listas de botones
 */
private void rellenarListasProductos() {
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


	/**
	 * 
	 * 
	 * @return
	 */
	public TextField getTxtEmpleado() {
		return txtEmpleado;
	}
	/**
	 * 
	 * 
	 * @param txtEmpleado
	 */
	public void setTxtEmpleado(TextField txtEmpleado) {
		this.txtEmpleado = txtEmpleado;
	}

	
	/**
	 * Función encargada de añadir la botonera de productos al Scrollview
	 * 
	 * @param productosList
	 * @param buttonList
	 */
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
	/**
	 * Añade el producto seleccionado al ticket, si este producto ya existe modifica la cantidad
	 * 
	 * @param producto
	 */
	private void onProductoButtonAction(Productos producto) {
		Boolean existe=false;
		int index=0;
		
		for( index=0;!existe&&index<tableCuenta.getItems().size();index++) {
			existe=producto.getDescription().contentEquals(tableCuenta.getItems().get(index).getDescripcion()); 
				
		}
		index--;
		
		if(!existe) {
			TicketModel ticketActual = new TicketModel(producto);
			tableCuenta.getItems().addAll(ticketActual);
			model.setPrecioSinTaxText(model.getPrecioSinTaxText()+producto.getPrecio());
			
		}else {
			int cantidad;
			TicketModel cant = tableCuenta.getItems().get(index);
			cantidad = cant.getCantidad();
			double total = cant.getTotal();
			double unidad = cant.getTotal()/cant.getCantidad();
			tableCuenta.getItems().get(index).setTotal(unidad+total);
			cant.setCantidad(cantidad+1);
			model.setPrecioSinTaxText(model.getPrecioSinTaxText()+unidad);
		}
		
	}
	/**
	 * 
	 * 
	 * @return
	 */
	public BorderPane getView() {
		return view;
	}

}