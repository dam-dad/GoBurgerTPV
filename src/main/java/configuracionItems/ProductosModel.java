package configuracionItems;

import java.util.List;

import goburgertpv.database.tables.Product;
import goburgertpv.database.tables.Productos;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class ProductosModel {

	private StringProperty id = new SimpleStringProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty descripcion = new SimpleStringProperty();
	private StringProperty precio = new SimpleStringProperty();
	private StringProperty tipo = new SimpleStringProperty();

	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final StringProperty descripcionProperty() {
		return this.descripcion;
	}

	public final String getDescripcion() {
		return this.descripcionProperty().get();
	}

	public final void setDescripcion(final String descripcion) {
		this.descripcionProperty().set(descripcion);
	}

	public final StringProperty precioProperty() {
		return this.precio;
	}

	public final String getPrecio() {
		return this.precioProperty().get();
	}

	public final void setPrecio(final String precio) {
		this.precioProperty().set(precio);
	}

	public final StringProperty idProperty() {
		return this.id;
	}

	public final String getId() {
		return this.idProperty().get();
	}

	public final void setId(final String id) {
		this.idProperty().set(id);
	}

	public final StringProperty tipoProperty() {
		return this.tipo;
	}

	public final String getTipo() {
		return this.tipoProperty().get();
	}

	public final void setTipo(final String tipo) {
		this.tipoProperty().set(tipo);
	}

}
