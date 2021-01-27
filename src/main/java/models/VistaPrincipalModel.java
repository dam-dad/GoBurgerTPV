package models;

import java.time.LocalDate;

import goburgertpv.database.tables.Users;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class VistaPrincipalModel {
	
	private DoubleProperty totalCuentaText=new SimpleDoubleProperty();
	private DoubleProperty precioSinTaxText=new SimpleDoubleProperty();
	private DoubleProperty precioDescuentoText=new SimpleDoubleProperty();
	private DoubleProperty igicText=new SimpleDoubleProperty();
	private StringProperty empleadoText=new SimpleStringProperty();
	private ObjectProperty<LocalDate> fechaText=new  SimpleObjectProperty<LocalDate>();
	private ListProperty<Button> bebidasButtonList=new SimpleListProperty<Button>(FXCollections.observableArrayList());
	private ListProperty<Button> complementosButtonList=new SimpleListProperty<Button>(FXCollections.observableArrayList());
	private ListProperty<Button> hamburguesasButtonList=new SimpleListProperty<Button>(FXCollections.observableArrayList());
	private ListProperty<Button> menusButtonList=new SimpleListProperty<Button>(FXCollections.observableArrayList());
	private ListProperty<Button> postresButtonList=new SimpleListProperty<Button>(FXCollections.observableArrayList());
	private ListProperty<Users> usersButtonList=new SimpleListProperty<Users>();
	
	
	public final DoubleProperty totalCuentaTextProperty() {
		return this.totalCuentaText;
	}
	
	public final double getTotalCuentaText() {
		return this.totalCuentaTextProperty().get();
	}
	
	public final void setTotalCuentaText(final double totalCuentaText) {
		this.totalCuentaTextProperty().set(totalCuentaText);
	}
	
	public final DoubleProperty precioSinTaxTextProperty() {
		return this.precioSinTaxText;
	}
	
	public final double getPrecioSinTaxText() {
		return this.precioSinTaxTextProperty().get();
	}
	
	public final void setPrecioSinTaxText(final double precioSinTaxText) {
		this.precioSinTaxTextProperty().set(precioSinTaxText);
	}
	
	public final DoubleProperty precioDescuentoTextProperty() {
		return this.precioDescuentoText;
	}
	
	public final double getPrecioDescuentoText() {
		return this.precioDescuentoTextProperty().get();
	}
	
	public final void setPrecioDescuentoText(final double precioDescuentoText) {
		this.precioDescuentoTextProperty().set(precioDescuentoText);
	}
	
	public final DoubleProperty igicTextProperty() {
		return this.igicText;
	}
	
	public final double getIgicText() {
		return this.igicTextProperty().get();
	}
	
	public final void setIgicText(final double igicText) {
		this.igicTextProperty().set(igicText);
	}
	
	public final StringProperty empleadoTextProperty() {
		return this.empleadoText;
	}
	
	public final String getEmpleadoText() {
		return this.empleadoTextProperty().get();
	}
	
	public final void setEmpleadoText(final String empleadoText) {
		this.empleadoTextProperty().set(empleadoText);
	}
	
	public final ObjectProperty<LocalDate> fechaTextProperty() {
		return this.fechaText;
	}
	
	public final LocalDate getFechaText() {
		return this.fechaTextProperty().get();
	}
	
	public final void setFechaText(final LocalDate fechaText) {
		this.fechaTextProperty().set(fechaText);
	}
	
	public final ListProperty<Button> bebidasButtonListProperty() {
		return this.bebidasButtonList;
	}
	
	public final ObservableList<Button> getBebidasButtonList() {
		return this.bebidasButtonListProperty().get();
	}
	
	public final void setBebidasButtonList(final ObservableList<Button> bebidasButtonList) {
		this.bebidasButtonListProperty().set(bebidasButtonList);
	}
	
	public final ListProperty<Button> complementosButtonListProperty() {
		return this.complementosButtonList;
	}
	
	public final ObservableList<Button> getComplementosButtonList() {
		return this.complementosButtonListProperty().get();
	}
	
	public final void setComplementosButtonList(final ObservableList<Button> complementosButtonList) {
		this.complementosButtonListProperty().set(complementosButtonList);
	}
	
	public final ListProperty<Button> hamburguesasButtonListProperty() {
		return this.hamburguesasButtonList;
	}
	
	public final ObservableList<Button> getHamburguesasButtonList() {
		return this.hamburguesasButtonListProperty().get();
	}
	
	public final void setHamburguesasButtonList(final ObservableList<Button> hamburguesasButtonList) {
		this.hamburguesasButtonListProperty().set(hamburguesasButtonList);
	}
	
	public final ListProperty<Button> menusButtonListProperty() {
		return this.menusButtonList;
	}
	
	public final ObservableList<Button> getMenusButtonList() {
		return this.menusButtonListProperty().get();
	}
	
	public final void setMenusButtonList(final ObservableList<Button> menusButtonList) {
		this.menusButtonListProperty().set(menusButtonList);
	}
	
	public final ListProperty<Button> postresButtonListProperty() {
		return this.postresButtonList;
	}
	
	public final ObservableList<Button> getPostresButtonList() {
		return this.postresButtonListProperty().get();
	}
	
	public final void setPostresButtonList(final ObservableList<Button> postresButtonList) {
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
	


}
