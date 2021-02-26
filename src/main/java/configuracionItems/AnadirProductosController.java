package configuracionItems;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.HibernateUtil;
import goburgertpv.database.tables.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AnadirProductosController implements Initializable {

	// model
	private ProductosModel model = new ProductosModel();

	// view
	@FXML
	private GridPane view;

	@FXML
	private Button btnAnadir;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtPrecio;

	@FXML
	private ComboBox<String> cmbTipo;

	@FXML
	private TextArea txtDescripcion;

	public AnadirProductosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vistasConfiguracion/AnadirProducto.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rellenarCombo();
		model.idProperty().bind(txtId.textProperty());
		model.nombreProperty().bind(txtNombre.textProperty());
		model.precioProperty().bind(txtPrecio.textProperty());
		model.tipoProperty().bind(cmbTipo.getSelectionModel().selectedItemProperty());
		model.descripcionProperty().bind(txtDescripcion.textProperty());
	}

	private void rellenarCombo() {
		cmbTipo.getItems().addAll("bebida", "complemento", "hamburguesa", "menu", "postre");
		cmbTipo.getSelectionModel().selectFirst();
	}

	@FXML
	void onClickAnadirProducto(ActionEvent event) {
		
	}
	
	public GridPane getView() {
		return view;
	}
}
