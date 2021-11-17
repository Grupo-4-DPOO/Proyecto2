package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Cajero implements Serializable{

	private SistemaPOS sistema;
	private Compra compra;
	private Cliente cliente;
	
	public Cajero (SistemaPOS sistema) {
		this.cliente = null;
		this.compra = null;
		this.sistema = sistema;
	}
	public void iniciarCompra(int cedula) {
		compra = new Compra(cedula);
		cliente = sistema.encontrarCliente(cedula);		
	}
	public String finalizarCompra() {
	Factura factura = new Factura(compra.getProductos().size(), compra.getValortotal(), compra.getPuntosacum(), compra.getIdcliente(), compra.getProductos());
	cliente.agregarFactura(factura);
	cliente.SumarPuntos(compra.getPuntosacum());
	sistema.agregarFactura(factura);
	sistema.registrarVenta(compra.getValortotal());
	this.cliente = null;
	this.compra = null;
	return factura.getResumen();
	}
	public String agregarProductoCompra(int idproducto) {
		String rta= " fto ";
		Producto elemento = sistema.encontrarProductoAVender(idproducto);
		if (elemento != null) {
			compra.agregarProducto(elemento);
			elemento.eliminardisponibles();
			rta= "producto agregado" +elemento.toString() +"fto"+ elemento.getRutaimagen();
		}
		return rta;
	}
	
	public String agregarProductosPeso(int idproducto, float peso) {
		String rta= " fto ";
		Producto elemento = sistema.encontrarProductoAVender(idproducto);
		if (elemento != null) {
			compra.agregarProductoPeso(elemento, peso);
			elemento.eliminardisponibles();
			rta= "producto agregado"+elemento.toString()+ "fto"+ elemento.getRutaimagen();
		}
		return rta;
	}
	
	public String eliminarProductosPeso(int idproducto, float peso) {
		String reta= " fto ";
		Producto elemento = sistema.encontrarProductoAVender(idproducto);
		if (elemento != null) {
			boolean rta = compra.eliminarProductoPeso(elemento, peso);
			if (rta == true) {
				elemento.eliminardisponibles();
				reta= "producto eliminado"+elemento.toString()+ "fto"+ elemento.getRutaimagen();
			}
		}
		return reta;
	}
	public String elimiarProductoCompra(int idproducto) {
		String reta= " fto ";
		Producto elemento = sistema. encontrarProductoAElminar(idproducto);
		if (elemento != null) {
			boolean rta = compra.eliminarProducto(elemento);
			if (rta == true) {
			elemento.agregardisponibles();
			reta= "producto eliminado" + elemento.toString()+"fto"+ elemento.getRutaimagen();
			}
		}
		return reta;
	}
}
