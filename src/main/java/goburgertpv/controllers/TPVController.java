package goburgertpv.controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import goburgertpv.App;
import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.RellenarDatos;
import goburgertpv.database.tables.Product;
import goburgertpv.database.tables.Productos;
import goburgertpv.models.VistaPrincipalModel;
import goburgertpv.utils.CustomButton;
import goburgertpv.utils.CustomHBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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

		rellenarProductos(VistaPrincipalModel.getComplementosList(), model.getComplementosButtonList());
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

	}

	@FXML
	void onClickEnviarCuenta(ActionEvent event) {

	}

	@FXML
	void onClickEnviarPdf(ActionEvent event) throws JRException, IOException {

		// compila el informe
		JasperReport report = JasperCompileManager.compileReport(TPVController.class.getResourceAsStream("/reports/goburger_report.jrxml"));		

		// mapa de parámetros para el informe
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("anyo", 2014); // no lo uso, pero se lo paso
		
		// generamos el informe (comtinamos el informe compilado con los datos) 
        JasperPrint print  = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(VistaPrincipalModel.getBebidasList()));
        
        // exporta el informe a un fichero PDF
        JasperExportManager.exportReportToPdfFile(print, "bebidas.pdf");
        
        // Abre el archivo PDF generado con el programa predeterminado del sistema
		Desktop.getDesktop().open(new File("bebidas.pdf"));
	
	}

	@FXML
	void onClickHamburguesas(ActionEvent event) {

		rellenarProductos(VistaPrincipalModel.getHamburguesasList(), model.getHamburguesasButtonList());

	}

	@FXML
	void onClickHome(ActionEvent event) {
		productosBox.getChildren().clear();

	}

	@FXML
	void onClickMenus(ActionEvent event) {
		rellenarProductos(VistaPrincipalModel.getMenusList(), model.getMenusButtonList());

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

		rellenarProductos(VistaPrincipalModel.getPostresList(), model.getPostresButtonList());

	}

	@FXML
	void onClickQuitarCantidad(ActionEvent event) {

	}

	@FXML
	void onClickRefrescos(ActionEvent event) {

		rellenarProductos(VistaPrincipalModel.getBebidasList(), model.getBebidasButtonList());

	}

	@FXML
	void onClickSalir(ActionEvent event) {

	}

	@FXML
	void onClickSubirProducto(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		productosScrollPane.setStyle("-fx-background-image:url('/images/logo3sin.png');-fx-background-size: contain;\n"
				+ "-fx-background-repeat: no-repeat;\n" + "-fx-background-position: center;");
		productosScrollPane.setFitToWidth(true);

		List<Productos> productosList = Funciones.getProductos();
		
		if (productosList.isEmpty()) {
			RellenarDatos.rellenar();
			productosList = Funciones.getProductos();
		}
			

		
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

		VistaPrincipalModel.getBebidasList().addAll(bebidasList);

		VistaPrincipalModel.getComplementosList().addAll(complementosList);

		VistaPrincipalModel.getHamburguesasList().addAll(hamburguesasList);

		VistaPrincipalModel.getMenusList().addAll(menusList);

		VistaPrincipalModel.getPostresList().addAll(postresList);

	}

	private void rellenarProductos(ArrayList<Productos> productos, ObservableList<CustomButton> buttonList) {
		productosBox.getChildren().clear();
		ArrayList<CustomHBox> rows = new ArrayList<CustomHBox>();

		int i = 0, j = 0, n = 0;
		for (i = 0, n = 0; n < buttonList.size(); i++) {
			rows.add(new CustomHBox());

			for (j = 0; n < buttonList.size() && j < 5; j++, n++) {
				rows.get(i).getChildren().add(buttonList.get(n));
				Productos producto = productos.get(n);
				buttonList.get(n).setOnAction(e -> onProductoButtonAction(producto));
			}
			rows.get(i).spacingProperty().bind(productosScrollPane.widthProperty()
					.subtract(buttonList.get(0).widthProperty().multiply(5)).divide(5));

		}
		
		
	

		productosBox.getChildren().addAll(rows);
	}

	private void onProductoButtonAction(Productos producto) {
		Alert successAlert = new Alert(AlertType.INFORMATION);
		successAlert.setTitle(producto.getNombre());
		successAlert.setHeaderText("Acceso permitido");
		successAlert.setContentText(producto.getDescription() + " " + producto.getPrecio());

		successAlert.showAndWait();

	}

	public BorderPane getView() {
		return view;
	}

}
