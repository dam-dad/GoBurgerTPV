package models;

import goburgertpv.database.tables.Product;
import goburgertpv.database.tables.Productos;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TicketModel {

    private StringProperty descripcion = new SimpleStringProperty();
    private IntegerProperty cantidad = new SimpleIntegerProperty();
    private DoubleProperty total = new SimpleDoubleProperty();


    public TicketModel(Productos producto) {
        setDescripcion(producto.getDescription());
        setTotal(producto.getPrecio());
        setCantidad(1);
    }


    public TicketModel() {
        // TODO Auto-generated constructor stub
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

    public final IntegerProperty cantidadProperty() {
        return this.cantidad;
    }

    public final int getCantidad() {
        return this.cantidadProperty().get();
    }

    public final void setCantidad(final int cantidad) {
        this.cantidadProperty().set(cantidad);
    }

    public final DoubleProperty totalProperty() {
        return this.total;
    }


    public final double getTotal() {
        return this.totalProperty().get();
    }


    public final void setTotal(final double total) {
        this.totalProperty().set(total);
    }

}