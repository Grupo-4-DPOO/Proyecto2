package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Compra implements Serializable{

	private ArrayList<Producto> productos;
	private double valortotal;
	private int idcliente;
	private double puntosacum;

	public Compra(int idcliente) {
		this.valortotal = 0.0;
		this.idcliente =  idcliente;
		this.puntosacum = 0.0;
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto producto) {
		valortotal+= producto.getPrecio();
		puntosacum+= (producto.getPrecio()/1000.0);
		productos.add(producto);
	}
	public boolean eliminarProducto(Producto producto) {
		valortotal-= producto.getPrecio();
		puntosacum-= (producto.getPrecio()/1000.0);
		for (int i= 0; i<productos.size(); i++) {
			if (productos.get(i) == producto) {
				productos.remove(i);
				return true;
			}
		}
		return false;
	}

	public void agregarProductoPeso(Producto producto, float peso) {
		valortotal+= producto.getPrecio()* peso;
		puntosacum+= ((producto.getPrecio()*peso)/1000.0);
		productos.add(producto);
	}
	public boolean eliminarProductoPeso(Producto producto, float peso) {
		valortotal-= producto.getPrecio()* peso;
		puntosacum-= ((producto.getPrecio()*peso)/1000.0);
		for (int i= 0; i<productos.size(); i++) {
			if (productos.get(i) == producto) {
				productos.remove(i);
				return true;
			}
		}
		return false;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public double getPuntosacum() {
		return puntosacum;
	}

	public void setPuntosacum(double puntosacum) {
		this.puntosacum = puntosacum;
	}
	
}
