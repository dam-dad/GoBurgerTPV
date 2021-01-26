package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    }

    @FXML
    void onClickHome(ActionEvent event) {

    }

    @FXML
    void onClickMenus(ActionEvent event) {

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

    }

    @FXML
    void onClickQuitarCantidad(ActionEvent event) {

    }

    @FXML
    void onClickRefrescos(ActionEvent event) {

    }

    @FXML
    void onClickSalir(ActionEvent event) {

    }

    @FXML
    void onClickSubirProducto(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public BorderPane getView() {
		return view;
	}

}
