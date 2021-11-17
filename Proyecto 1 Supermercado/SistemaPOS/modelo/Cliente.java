package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cliente implements Serializable{

	private int cedula;
	private String nombre;
	private int telefono;
	private String email;
	private String sexo;
	private String estadocivil;
	private String situalab;
	private double puntos;
	private ArrayList<Factura> facturas;
	private ArrayList<Date> fechas;
	
	public Cliente(int cedula, String nombre, int telefono, String email, String sexo, String estadocivil, String situalab){
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.sexo = sexo;
		this.estadocivil = estadocivil;
		this.situalab = situalab;
		this.puntos = 0.0;
		this.facturas = new ArrayList<Factura>();
		this.fechas = new ArrayList<Date>();
	}

	


	public ArrayList<Factura> getFacturas() {
		return facturas;
	}




	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}




	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getSitualab() {
		return situalab;
	}

	public void setSitualab(String situalab) {
		this.situalab = situalab;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	public void SumarPuntos(double puntos) {
		this.puntos+=puntos;
		fechas.add(new Date());
	}




	public ArrayList<Date> getFechas() {
		return fechas;
	}




	public void setFechas(ArrayList<Date> fechas) {
		this.fechas = fechas;
	}




}
