package consola;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Producto;
import modelo.SistemaPOS;

public class ManejadorPOS {
	private SistemaPOS sistema;
	
	public ManejadorPOS() throws Exception {
		sistema = new SistemaPOS();
		cargar();
	}
	
	public void cargarproductos(String archivoProductos) throws IOException
	{
		ArrayList<Producto> productos = new ArrayList<Producto>();
		// "Abrir" el archivo de Ingredientes y leerlo linea por linea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader (archivoProductos));
		String linea = br.readLine();   // Leer la linea con el primer ProductoMenu en el archivo   
		// Un ProductoMenu tiene la forma: nombre;precioBase
		while (linea != null) // Cuando se llegue al final del archivo, linea tendra el valor null
		{
			// Separar los valores que estan en la linea por el caracter ';'
			String[] partes = linea.split(";");
			boolean booleancongelado = false;
			boolean booleanrefrigerado = false;
			if (partes[6]=="true") {
				booleancongelado = true;
			}
			if (partes[7]=="true") {
				booleanrefrigerado = true;
			}
			Producto nuevoproducto = new Producto(partes[0], Float.parseFloat(partes[1]), Float.parseFloat(partes[2]), Integer.parseInt(partes[3]), partes[4], partes[5], booleancongelado,  booleanrefrigerado, Integer.parseInt(partes[8]), partes[9], partes[10]);   // Creacion de un objeto ingredientesu con su nombre y precio base
			sistema.agregarProducto(nuevoproducto);
			System.out.println(nuevoproducto);
			linea = br.readLine(); // leer la proxima linea en el archivo con un nuevo ProductoMenu 
		}

		br.close();
	}
	public void guardar() throws IOException {
		FileOutputStream fos = new FileOutputStream("./Data/Informacion.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(sistema);
		oos.close();
	}
	public void cargar() throws Exception{
		FileInputStream fis;
		try {
			fis = new FileInputStream("./Data/Informacion.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis);
			boolean terminado = false;
			Object objeto = null;
			while(terminado ==false ) {
				objeto = ois.readObject();
				if (objeto == null) {
					terminado = true;
				}
			}
			if(objeto == null) {
				
			}
			else {
				sistema = (SistemaPOS) objeto;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (EOFException eofn ) {
				// TODO Auto-generated catch block
			}		
	}
	public void cargarArchivos (File archivoProductos) throws Exception
	{
		String ruta=archivoProductos.getAbsolutePath();
		cargarproductos(ruta);
	}

	public String AgregarProducto(int prod)
	{
		return sistema.agregarProductoCompra(prod);
	}

	
	public String AgregarProductoPeso(int prod, int peso)
	{
		return sistema.agregarProductosPeso(prod, peso);
	}
	public String EliminarProducto (int prod)
	{
		return sistema.elimiarProductoCompra(prod);
	}
	public String EliminarProductoPeso (int prod, int peso)
	{
		return sistema.eliminarProductosPeso(prod, peso);
	}
	
	public String AnadirCliente (int id, String nombre,int tel, String email, String sexo, String est_civil, String Situa_lab)
	{
		sistema.agregarClienteNuevo(id, nombre, tel, email, sexo, est_civil, Situa_lab);
		return "cliente añadido";
	}
	
	
	public void IniciarCompra(int prod)
	{
		sistema.iniciarCompra(prod);
	}
	
	public String FinalizarCompra() throws Exception
	{
		guardar();
		return sistema.finalizarCompra();
		
	}
	public Cliente consultarCliente(int idcliente) {
		return sistema.encontrarCliente(idcliente);
	}

}
