package models;

import goburgertpv.database.tables.Product;
import goburgertpv.database.tables.Productos;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class TicketModel {

    private StringProperty descripcion = new SimpleStringProperty();
    private IntegerProperty cantidad = new SimpleIntegerProperty();
    private DoubleProperty total = new SimpleDoubleProperty();

    /**
     * Constructor de la clase
     * 
     * @param producto
     */
    public TicketModel(Productos producto) {
        setDescripcion(producto.getDescription());
        setTotal(producto.getPrecio());
        setCantidad(1);
    }

    /**
     * Constructor por defecto
     * 
     */
    public TicketModel() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @return
     */
    public final StringProperty descripcionProperty() {
        return this.descripcion;
    }
    /**
     * Método getter del atributo Descripcion
     * 
     * @return
     */
    public final String getDescripcion() {
        return this.descripcionProperty().get();
    }
    /**
     * Método setter del atributo Descripcion
     * 
     * @param descripcion
     */
    public final void setDescripcion(final String descripcion) {
        this.descripcionProperty().set(descripcion);
    }
    /**
     * 
     * @return
     */
    public final IntegerProperty cantidadProperty() {
        return this.cantidad;
    }
    /**
     * Método getter del atributo Cantidad
     * 
     * @return
     */
    public final int getCantidad() {
        return this.cantidadProperty().get();
    }
    /**
     * Método setter del atributo Cantidad
     * 
     * @param cantidad
     */
    public final void setCantidad(final int cantidad) {
        this.cantidadProperty().set(cantidad);
    }
    /**
     * 
     * @return
     */
    public final DoubleProperty totalProperty() {
        return this.total;
    }
    /**
     * Método getter del atributo Total
     * 
     * @return
     */
    public final double getTotal() {
        return this.totalProperty().get();
    }
    /** 
     * Método setter del atributo Total
     * 
     * @param total
     */
    public final void setTotal(final double total) {
        this.totalProperty().set(total);
    }
}