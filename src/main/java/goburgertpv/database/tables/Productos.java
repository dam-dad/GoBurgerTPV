package goburgertpv.database.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Productos")
public class Productos implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private String description;

	private double precio;

	@Enumerated(EnumType.STRING)
	private Product productType;

	public Productos() {
	}
	
	public Productos(String nombre, String description, double precio, Product tipo) {
		this.nombre=nombre;
		this.description=description;
		this.precio=precio;
		this.productType=tipo;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Product getProductType() {
		return productType;
	}

	public void setProductType(Product productType) {
		this.productType = productType;
	}

}
