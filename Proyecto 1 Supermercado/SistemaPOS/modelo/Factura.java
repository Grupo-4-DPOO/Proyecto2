package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable{

	private int cantidadart;
	private double valortotal;
	private double puntosacum;
	private int idcliente;
	private ArrayList<Producto> productos;
	private String resumen;
	
	public Factura(int cantidadart, double valortotal, double puntosacum, int idcliente, ArrayList<Producto> productos) {
		this.cantidadart = cantidadart;
		this.valortotal = valortotal;
		this.puntosacum = puntosacum;
		this.idcliente = idcliente;
		this.productos = productos;
		resumen = generarFactura();
		
	}
	
	public String generarFactura() {
		Date fecha = new Date();
		String rta = "Fecha : " + fecha.toString() + "\n IdCliente: " + Integer.toString(idcliente);
		for(Producto producto:productos) {
			rta += "\n Id: " + Integer.toString(producto.getIdproducto()) + " Nombre: " + producto.getNombre() + " Precio unitario:" 
		+ Float.toString(producto.getPrecio() )+ "Precio por unidad: " + Float.toString(producto.getPreciounidad()) + "/" + producto.getUnidadmed();	
		}
		rta+= "\n El valor total de la factura es : " + Double.toString(valortotal) + "\n Puntos Acumulados: " + Double.toString(puntosacum);
		return rta;
	}
	

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public int getCantidadart() {
		return cantidadart;
	}

	public void setCantidadart(int cantidadart) {
		this.cantidadart = cantidadart;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public double getPuntosacum() {
		return puntosacum;
	}

	public void setPuntosacum(double puntosacum) {
		this.puntosacum = puntosacum;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	

}
