package configuracionItems;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import goburgertpv.database.connection.Funciones;
import goburgertpv.database.connection.HibernateUtil;
import goburgertpv.database.tables.Product;
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
/**
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
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
	private ComboBox<Product> cmbTipo;

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
	
	}

	private void rellenarCombo() {
		cmbTipo.getItems().setAll(Product.values());
		cmbTipo.getSelectionModel().selectFirst();
	}

	@FXML
	void onClickAnadirProducto(ActionEvent event) {
		Session session=Funciones.getSession();
		
	}
	
	public GridPane getView() {
		return view;
	}
}
