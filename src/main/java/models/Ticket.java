package models;
/**
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class Ticket {
	
    private String descripcion;
    private int cantidad ;
    private double precio ;
    private String total;
    private double totalSin;
    
	public double getTotalSin() {
		return totalSin;
	}
	public void setTotalSin(double totalSin) {
		this.totalSin = totalSin;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}  
}
