package configuracionItems;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsuariosModel {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contraseña = new SimpleStringProperty();
	private StringProperty confirmarContraseña = new SimpleStringProperty();
	private BooleanProperty administrador = new SimpleBooleanProperty();

	public final StringProperty usuarioProperty() {
		return this.usuario;
	}

	public final String getUsuario() {
		return this.usuarioProperty().get();
	}

	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}

	public final StringProperty contraseñaProperty() {
		return this.contraseña;
	}

	public final String getContraseña() {
		return this.contraseñaProperty().get();
	}

	public final void setContraseña(final String contraseña) {
		this.contraseñaProperty().set(contraseña);
	}

	public final StringProperty confirmarContraseñaProperty() {
		return this.confirmarContraseña;
	}

	public final String getConfirmarContraseña() {
		return this.confirmarContraseñaProperty().get();
	}

	public final void setConfirmarContraseña(final String confirmarContraseña) {
		this.confirmarContraseñaProperty().set(confirmarContraseña);
	}

	public final BooleanProperty administradorProperty() {
		return this.administrador;
	}

	public final boolean isAdministrador() {
		return this.administradorProperty().get();
	}

	public final void setAdministrador(final boolean administrador) {
		this.administradorProperty().set(administrador);
	}

}
