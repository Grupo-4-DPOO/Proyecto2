package modelo;

public class ProductosFrescos extends ProductoInv{
	private	boolean refrigeracion;
	private boolean congelacion;
	private ProductosEmpacados empacados;
	private ProductosNoEmpacados noempacados;

	public ProductosFrescos(int precio, String marca, float cantidad, int codigobarras, boolean refrigeracion, boolean congelacion, int precioxunidad, int unidades, String nombre, String unidadmed,  String ruta, String vencimiento) {
		super(precio, marca, cantidad, codigobarras,unidades, nombre, unidadmed, refrigeracion, congelacion, ruta, vencimiento);
		this.congelacion = congelacion;
		this.refrigeracion = refrigeracion;
		empacados = new ProductosEmpacados(precioxunidad);
		noempacados = null;
	}
	public ProductosFrescos(int precio, String marca, float cantidad, int codigobarras, boolean refrigeracion, boolean congelacion, int unidades, String nombre, String unidadmed,  String ruta, String vencimiento) {
		super(precio, marca, cantidad, codigobarras, unidades, nombre, unidadmed, refrigeracion, congelacion, ruta, vencimiento);
		this.congelacion = congelacion;
		this.refrigeracion = refrigeracion;
		empacados = null;
		noempacados = new ProductosNoEmpacados(cantidad, precio, codigobarras);
	}
	public String getUnidadmed() {
		return super.getUnidadmed();
	}


	public void setUnidadmed(String unidadmed) {
		super.setUnidadmed(unidadmed);
	}
	public String getNombre() {
		return super.getNombre();
	}


	public void setNombre(String nombre) {
		super.setNombre(nombre);;
	}
	public boolean isRefrigeracion() {
		return refrigeracion;
	}
	public void setRefrigeracion(boolean refrigeracion) {
		this.refrigeracion = refrigeracion;
	}
	public boolean isCongelacion() {
		return congelacion;
	}
	public void setCongelacion(boolean congelacion) {
		this.congelacion = congelacion;
	}
	public ProductosEmpacados getEmpacados() {
		return empacados;
	}
	public void setEmpacados(ProductosEmpacados empacados) {
		this.empacados = empacados;
	}
	public ProductosNoEmpacados getNoempacados() {
		return noempacados;
	}
	public void setNoempacados(ProductosNoEmpacados noempacados) {
		this.noempacados = noempacados;
	}
	public float getPrecio() {
		return super.getPrecio();
	}
	public void setPrecio(float precio) {
		super.setPrecio(precio);
	}
	public String getMarca() {
		return super.getMarca();
	}
	public void setMarca(String marca) {
		super.setMarca(marca);;
	}
	public float getCantidad() {
		return super.getCantidad();
	}
	public void setCantidad(float cantidad) {
		super.setCantidad(cantidad);;
	}
	public int getCodigobarras() {
		return super.getCodigobarras();
	}
	public void setCodigobarras(int codigobarras) {
		super.setCodigobarras(codigobarras);
	}
	public int getUnidades() {
		return super.getUnidades();
	}

	public void setUnidades(int unidades) {
		super.setUnidades(unidades);;
	}
}
