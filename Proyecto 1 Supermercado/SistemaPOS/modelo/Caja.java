package modelo;

import java.io.Serializable;

public class Caja implements Serializable{
	private int ventas;
	private double dinero;
	
	public Caja () {
		this.ventas = 0;
		this.dinero = 0.0;
	}

	public void ingresarVenta(double ingreso) {
		ventas++;
		dinero+=ingreso;
	}
	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	
}
