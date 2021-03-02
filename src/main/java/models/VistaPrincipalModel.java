package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import goburgertpv.database.tables.Productos;
import goburgertpv.database.tables.Users;
import goburgertpv.utils.CustomButton;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class VistaPrincipalModel {

	private StringProperty totalSin = new SimpleStringProperty();
	private DoubleProperty totalCuentaText = new SimpleDoubleProperty();
	private StringProperty totalFormateado = new SimpleStringProperty();
	private DoubleProperty precioSinTaxText = new SimpleDoubleProperty();
	private DoubleProperty precioDescuentoText = new SimpleDoubleProperty();
	private DoubleProperty igicText = new SimpleDoubleProperty();
	private StringProperty empleadoText = new SimpleStringProperty();
	private ObjectProperty<LocalDate> fechaText = new SimpleObjectProperty<LocalDate>();
	private ListProperty<CustomButton> bebidasButtonList = new SimpleListProperty<CustomButton>(
			FXCollections.observableArrayList());
	private ListProperty<CustomButton> complementosButtonList = new SimpleListProperty<CustomButton>(
			FXCollections.observableArrayList());
	private ListProperty<CustomButton> hamburguesasButtonList = new SimpleListProperty<CustomButton>(
			FXCollections.observableArrayList());
	private ListProperty<CustomButton> menusButtonList = new SimpleListProperty<CustomButton>(
			FXCollections.observableArrayList());
	private ListProperty<CustomButton> postresButtonList = new SimpleListProperty<CustomButton>(
			FXCollections.observableArrayList());
	private ListProperty<Users> usersButtonList = new SimpleListProperty<Users>();
	private static ListProperty<Productos> bebidasList = new SimpleListProperty<Productos>(
			FXCollections.observableArrayList(new ArrayList<Productos>()));
	private static ListProperty<Productos> complementosList = new SimpleListProperty<Productos>(
			FXCollections.observableArrayList(new ArrayList<Productos>()));
	private static ListProperty<Productos> hamburguesasList = new SimpleListProperty<Productos>(
			FXCollections.observableArrayList(new ArrayList<Productos>()));
	private static ListProperty<Productos> menusList = new SimpleListProperty<Productos>(
			FXCollections.observableArrayList(new ArrayList<Productos>()));
	private static ListProperty<Productos> postresList = new SimpleListProperty<Productos>(
			FXCollections.observableArrayList(new ArrayList<Productos>()));
	private static ListProperty<Users> userList = new SimpleListProperty<Users>(
			FXCollections.observableArrayList(new ArrayList<Users>()));
	private List<Ticket> ticketList = new ArrayList<Ticket>();

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	/**
	 * 
	 * @return
	 */
	public final DoubleProperty totalCuentaTextProperty() {
		return this.totalCuentaText;
	}

	/**
	 * Método getter del atributo TotalCuenta
	 * 
	 * @return
	 */
	public final double getTotalCuentaText() {
		return this.totalCuentaTextProperty().get();
	}

	/**
	 * Método setter del atributo TotalCuenta
	 * 
	 * @param totalCuentaText
	 */
	public final void setTotalCuentaText(final double totalCuentaText) {
		this.totalCuentaTextProperty().set(totalCuentaText);
	}

	/**
	 * 
	 * @return
	 */
	public final DoubleProperty precioSinTaxTextProperty() {
		return this.precioSinTaxText;
	}

	/**
	 * Método getter del atributo PrecioSinTax
	 * 
	 * @return
	 */
	public final double getPrecioSinTaxText() {
		return this.precioSinTaxTextProperty().get();
	}

	/**
	 * Método setter del atributo PrecioSinTax
	 * 
	 * @param precioSinTaxText
	 */
	public final void setPrecioSinTaxText(final double precioSinTaxText) {
		this.precioSinTaxTextProperty().set(precioSinTaxText);
	}

	/**
	 * 
	 * @return
	 */
	public final DoubleProperty precioDescuentoTextProperty() {
		return this.precioDescuentoText;
	}

	/**
	 * Método getter del atributo PrecioDescuento
	 * 
	 * @return
	 */
	public final double getPrecioDescuentoText() {
		return this.precioDescuentoTextProperty().get();
	}

	/**
	 * Método setter del atributo PrecioDescuento
	 * 
	 * @param precioDescuentoText
	 */
	public final void setPrecioDescuentoText(final double precioDescuentoText) {
		this.precioDescuentoTextProperty().set(precioDescuentoText);
	}

	/**
	 * 
	 * @return
	 */
	public final DoubleProperty igicTextProperty() {
		return this.igicText;
	}

	/**
	 * Método getter del atributo Igic
	 * 
	 * @return
	 */
	public final double getIgicText() {
		return this.igicTextProperty().get();
	}

	/**
	 * Método setter del atributo Igic
	 * 
	 * @param igicText
	 */
	public final void setIgicText(final double igicText) {
		this.igicTextProperty().set(igicText);
	}

	/**
	 * 
	 * @return
	 */
	public final StringProperty empleadoTextProperty() {
		return this.empleadoText;
	}

	/**
	 * Método getter del atributo Empleado
	 * 
	 * @return
	 */
	public final String getEmpleadoText() {
		return this.empleadoTextProperty().get();
	}

	/**
	 * Método setter del atributo Empleado
	 * 
	 * @param empleadoText
	 */
	public final void setEmpleadoText(final String empleadoText) {
		this.empleadoTextProperty().set(empleadoText);
	}

	/**
	 * 
	 * @return
	 */
	public final ObjectProperty<LocalDate> fechaTextProperty() {
		return this.fechaText;
	}

	/**
	 * Método getter del atributo Fecha
	 * 
	 * @return
	 */
	public final LocalDate getFechaText() {
		return this.fechaTextProperty().get();
	}

	/**
	 * Método setter del atributo Fecha
	 * 
	 * @param fechaText
	 */
	public final void setFechaText(final LocalDate fechaText) {
		this.fechaTextProperty().set(fechaText);
	}

	public final ListProperty<CustomButton> bebidasButtonListProperty() {
		return this.bebidasButtonList;
	}

	public final ObservableList<CustomButton> getBebidasButtonList() {
		return this.bebidasButtonListProperty().get();
	}

	public final void setBebidasButtonList(final ObservableList<CustomButton> bebidasButtonList) {
		this.bebidasButtonListProperty().set(bebidasButtonList);
	}

	public final ListProperty<CustomButton> complementosButtonListProperty() {
		return this.complementosButtonList;
	}

	public final ObservableList<CustomButton> getComplementosButtonList() {
		return this.complementosButtonListProperty().get();
	}

	public final void setComplementosButtonList(final ObservableList<CustomButton> complementosButtonList) {
		this.complementosButtonListProperty().set(complementosButtonList);
	}

	public final ListProperty<CustomButton> hamburguesasButtonListProperty() {
		return this.hamburguesasButtonList;
	}

	public final ObservableList<CustomButton> getHamburguesasButtonList() {
		return this.hamburguesasButtonListProperty().get();
	}

	public final void setHamburguesasButtonList(final ObservableList<CustomButton> hamburguesasButtonList) {
		this.hamburguesasButtonListProperty().set(hamburguesasButtonList);
	}

	public final ListProperty<CustomButton> menusButtonListProperty() {
		return this.menusButtonList;
	}

	public final ObservableList<CustomButton> getMenusButtonList() {
		return this.menusButtonListProperty().get();
	}

	public final void setMenusButtonList(final ObservableList<CustomButton> menusButtonList) {
		this.menusButtonListProperty().set(menusButtonList);
	}

	public final ListProperty<CustomButton> postresButtonListProperty() {
		return this.postresButtonList;
	}

	public final ObservableList<CustomButton> getPostresButtonList() {
		return this.postresButtonListProperty().get();
	}

	public final void setPostresButtonList(final ObservableList<CustomButton> postresButtonList) {
		this.postresButtonListProperty().set(postresButtonList);
	}

	public final ListProperty<Users> usersButtonListProperty() {
		return this.usersButtonList;
	}

	public final ObservableList<Users> getUsersButtonList() {
		return this.usersButtonListProperty().get();
	}

	public final void setUsersButtonList(final ObservableList<Users> usersButtonList) {
		this.usersButtonListProperty().set(usersButtonList);
	}

	public final ListProperty<Productos> bebidasListProperty() {
		return this.bebidasList;
	}

	public final ObservableList<Productos> getBebidasList() {
		return this.bebidasListProperty().get();
	}

	public final void setBebidasList(final ObservableList<Productos> bebidasList) {
		this.bebidasListProperty().set(bebidasList);
	}

	public final ListProperty<Productos> complementosListProperty() {
		return this.complementosList;
	}

	public final ObservableList<Productos> getComplementosList() {
		return this.complementosListProperty().get();
	}

	public final void setComplementosList(final ObservableList<Productos> complementosList) {
		this.complementosListProperty().set(complementosList);
	}

	public final ListProperty<Productos> hamburguesasListProperty() {
		return this.hamburguesasList;
	}

	public final ObservableList<Productos> getHamburguesasList() {
		return this.hamburguesasListProperty().get();
	}

	public final void setHamburguesasList(final ObservableList<Productos> hamburguesasList) {
		this.hamburguesasListProperty().set(hamburguesasList);
	}

	public final ListProperty<Productos> menusListProperty() {
		return this.menusList;
	}

	public final ObservableList<Productos> getMenusList() {
		return this.menusListProperty().get();
	}

	public final void setMenusList(final ObservableList<Productos> menusList) {
		this.menusListProperty().set(menusList);
	}

	public final ListProperty<Productos> postresListProperty() {
		return this.postresList;
	}

	public final ObservableList<Productos> getPostresList() {
		return this.postresListProperty().get();
	}

	public final void setPostresList(final ObservableList<Productos> postresList) {
		this.postresListProperty().set(postresList);
	}

	public final ListProperty<Users> userListProperty() {
		return this.userList;
	}

	public final ObservableList<Users> getUserList() {
		return this.userListProperty().get();
	}

	public final void setUserList(final ObservableList<Users> userList) {
		this.userListProperty().set(userList);
	}

	public final StringProperty totalFormateadoProperty() {
		return this.totalFormateado;
	}
	

	public final String getTotalFormateado() {
		return this.totalFormateadoProperty().get();
	}
	

	public final void setTotalFormateado(final String totalFormateado) {
		this.totalFormateadoProperty().set(totalFormateado);
	}

	public final StringProperty totalSinProperty() {
		return this.totalSin;
	}
	

	public final String getTotalSin() {
		return this.totalSinProperty().get();
	}
	

	public final void setTotalSin(final String totalSin) {
		this.totalSinProperty().set(totalSin);
	}
	
}