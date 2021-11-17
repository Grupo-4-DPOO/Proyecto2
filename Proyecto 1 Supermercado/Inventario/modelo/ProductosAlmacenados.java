package modelo;

public class ProductosAlmacenados extends ProductoInv{
	private boolean productoalm;
	private ProductosEmpacados empacados;
	private ProductosNoEmpacados noempacados;
	
	public ProductosAlmacenados(int precio, String marca, float cantidad, int codigobarras, int precioxunidad, int unidades, String nombre, String unidadmed, String ruta, String vencimiento) {
		super(precio, marca, cantidad, codigobarras, unidades, nombre, unidadmed, false, false, ruta, vencimiento);
		this.productoalm = true;
		this.empacados = new ProductosEmpacados(precioxunidad);
		this.noempacados = null;
	}
	public ProductosAlmacenados(int precio, String marca, float cantidad, int codigobarras, int unidades, String nombre, String unidadmed, String ruta, String vencimiento) {
		super(precio, marca, cantidad, codigobarras, unidades, nombre, unidadmed, false,false, ruta, vencimiento);
		this.productoalm = true;
		this.empacados = null;
		this.noempacados = new ProductosNoEmpacados(cantidad, precio, codigobarras);
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
	public boolean isProductoalm() {
		return productoalm;
	}
	public void setProductoalm(boolean productoalm) {
		this.productoalm = productoalm;
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
	public void setPrecio(int precio) {
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
