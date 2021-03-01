package models;

import org.hibernate.Session;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class MainModel {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contraseña = new SimpleStringProperty();
	private boolean administrador=false;
	
	/**
	 * 
	 * @return
	 */
	public boolean isAdministrador() {
		return administrador;
	}
	/**
	 * Método setter del atributo Administrador
	 * 
	 * @param administrador
	 */
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	/**
	 * 
	 * @return
	 */
	public final StringProperty usuarioProperty() {
		return this.usuario;
	}
	/**
	 * Método getter del atributo Usuario
	 * 
	 * @return
	 */
	public final String getUsuario() {
		return this.usuarioProperty().get();
	}
	/**
	 * Método setter del atributo Usuario
	 * 
	 * @param usuario
	 */
	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}
	/**
	 * 
	 * @return
	 */
	public final StringProperty contraseñaProperty() {
		return this.contraseña;
	}
	/**
	 * Método getter del atributo Contraseña
	 * 
	 * @return
	 */
	public final String getContraseña() {
		return this.contraseñaProperty().get();
	}
	/**
	 * Método setter del atributo Contraseña
	 * 
	 * @param contraseña
	 */
	public final void setContraseña(final String contraseña) {
		this.contraseñaProperty().set(contraseña);
	}

}
