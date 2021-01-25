package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InicioSesion {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contraseña = new SimpleStringProperty();
	
	
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

}
