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
	private ListProperty<CustomButton> bebidasButtonList=new SimpleListProperty<CustomButton>(FXCollections.observableArrayList());
	private ListProperty<CustomButton> complementosButtonList=new SimpleListProperty<CustomButton>(FXCollections.observableArrayList());
	private ListProperty<CustomButton> hamburguesasButtonList=new SimpleListProperty<CustomButton>(FXCollections.observableArrayList());
	private ListProperty<CustomButton> menusButtonList=new SimpleListProperty<CustomButton>(FXCollections.observableArrayList());
	private ListProperty<CustomButton> postresButtonList=new SimpleListProperty<CustomButton>(FXCollections.observableArrayList());
	private ListProperty<Users> usersButtonList=new SimpleListProperty<Users>();
	private static ArrayList<Productos> bebidasList=new ArrayList<Productos>();
	private static ArrayList<Productos> complementosList=new ArrayList<Productos>();
	private static ArrayList<Productos> hamburguesasList=new ArrayList<Productos>();
	private static ArrayList<Productos> menusList=new ArrayList<Productos>();
	private static ArrayList<Productos> postresList=new  ArrayList<Productos>();
	private static ArrayList<Users> userList=new ArrayList<Users>();

	
	




	public static ArrayList<Productos> getBebidasList() {
		return bebidasList;
	}

	public static void setBebidasList(ArrayList<Productos> bebidasList) {
		VistaPrincipalModel.bebidasList = bebidasList;
	}

	public static ArrayList<Productos> getComplementosList() {
		return complementosList;
	}

	public static void setComplementosList(ArrayList<Productos> complementosList) {
		VistaPrincipalModel.complementosList = complementosList;
	}

	public static ArrayList<Productos> getHamburguesasList() {
		return hamburguesasList;
	}

	public static void setHamburguesasList(ArrayList<Productos> hamburguesasList) {
		VistaPrincipalModel.hamburguesasList = hamburguesasList;
	}

	public static ArrayList<Productos> getMenusList() {
		return menusList;
	}

	public static void setMenusList(ArrayList<Productos> menusList) {
		VistaPrincipalModel.menusList = menusList;
	}

	public static ArrayList<Productos> getPostresList() {
		return postresList;
	}

	public static void setPostresList(ArrayList<Productos> postresList) {
		VistaPrincipalModel.postresList = postresList;
	}

	public static ArrayList<Users> getUserList() {
		return userList;
	}

	public static void setUserList(ArrayList<Users> userList) {
		VistaPrincipalModel.userList = userList;
	}

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
	


}
