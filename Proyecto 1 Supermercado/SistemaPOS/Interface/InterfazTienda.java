package Interface;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import Interfaz.DialogoCargarLote;
import Interfaz.InterfazInventario;

import javax.swing.UnsupportedLookAndFeelException;

import consola.ManejadorPOS;
import modelo.Cliente;
import modelo.Producto;
import modelo.SistemaPOS;

/**
 * Esta clase representa a la ventana principal de la aplicaci贸n
 */
@SuppressWarnings("serial")
public class InterfazTienda extends JFrame
{
	private ManejadorPOS sistema;
	// ************************************************************************
	// Atributos
	// ************************************************************************

	
	// ************************************************************************
	// Elementos de la interfaz
	// ************************************************************************

	/**
	 * Este componente corresponde al men煤 completo que se encuentra en la parte
	 * superior de la ventana
	 */
	private JMenuBar barraMenu;

	/**
	 * Este componente corresponde al men煤 archivo
	 */
	private JMenu menuArchivo;

	/**
	 * Este componente corresponde a la opci贸n para cargar los archivos de un LOte
	 */
	private JMenuItem menuAbrir;

	/**
	 * Este componente corresponde a la opci髇 para salir de la aplicaci髇
	 */
	private JMenuItem menuSalir;


	/**
	 * Este componente corresponde al panel donde se muestra una lista de productos
	 */
	private PanelProductos panelProductos;

	/**
	 * Este componente corresponde al panel donde se muestra la informaci贸n de un
	 * producto
	 */
	private PanelProducto panelProducto;

	/**
	 * Este componente corresponde al panel con los botones de la parte inferior de
	 * la ventana
	 */
	private PanelBotones panelBotones;
	private DialogoActividad dactividad;

	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye la ventana principal para la aplicaci贸n, pero no carga la
	 * informaci贸n de ninguna Tienda.
	 * @throws Exception 
	 */
	public InterfazTienda() throws Exception
	{
		sistema = new ManejadorPOS();
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		menuArchivo = new JMenu("Archivo");
		barraMenu.add(menuArchivo);

		// Setting the accelerator:
		menuAbrir = new JMenuItem("Abrir", KeyEvent.VK_A);
		menuAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		menuAbrir.setActionCommand(ListenerMenu.ABRIR_LIBROS);
		menuAbrir.addActionListener(new ListenerMenu(this));
		menuArchivo.add(menuAbrir);

		menuSalir = new JMenuItem("Salir", KeyEvent.VK_Q);
		menuSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuSalir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		menuArchivo.add(menuSalir);

		JPanel panelArriba = new JPanel(new GridLayout(1, 2));
		add(panelArriba, BorderLayout.CENTER);

		JPanel panelIzquierdo = new JPanel(new BorderLayout());
		panelArriba.add(panelIzquierdo);

		panelProductos = new PanelProductos();
		panelIzquierdo.add(panelProductos, BorderLayout.CENTER);

		JPanel panelDerecha = new JPanel(new BorderLayout());
		panelArriba.add(panelDerecha);
		panelProducto = new PanelProducto();
		panelDerecha.add(panelProducto, BorderLayout.CENTER);

		JPanel panelAbajo = new JPanel(new BorderLayout());
		panelBotones = new PanelBotones(this);
		panelAbajo.add(panelBotones, BorderLayout.CENTER);
		add(panelAbajo, BorderLayout.SOUTH);

		setDefaultCloseOperation(salir());
		setTitle("Sistema POS- Mercado Furver");
		setSize(1000, 700);
		setVisible(true);
	}

	// ************************************************************************
	// M茅todos
	// ************************************************************************


	
	public void cargarArchivos (File archivoProductos) throws Exception
	{
		sistema.cargarArchivos(archivoProductos);
	}
	public int salir() throws Exception {
		sistema.guardar();
		dispose();
		return 3;
	}



	public void AgregarProducto(int prod)
	{
		String rta =sistema.AgregarProducto(prod);
		String texto = rta.split("fto")[0];
		String foto = rta.split("fto")[1];
		panelProducto.actualizarImagen(foto);
		panelProducto.actualizarInformacion(texto);
	}

	
	public void AgregarProductoPeso(int prod, int peso)
	{
		String rta = sistema.AgregarProductoPeso(prod, peso);
		String texto = rta.split("fto")[0];
		String foto = rta.split("fto")[1];
		panelProducto.actualizarImagen(foto);
		panelProducto.actualizarInformacion(texto);
	}
	public void EliminarProducto (int prod)
	{
		String rta =sistema.EliminarProducto(prod);
		String texto = rta.split("fto")[0];
		String foto = rta.split("fto")[1];
		panelProducto.actualizarImagen(foto);
		panelProducto.actualizarInformacion(texto);
	}
	public void EliminarProductoPeso (int prod, int peso)
	{
		String rta =sistema.EliminarProductoPeso(prod, peso);
		String texto = rta.split("fto")[0];
		String foto = rta.split("fto")[1];
		panelProducto.actualizarImagen(foto);
		panelProducto.actualizarInformacion(texto);
	}
	
	public void AnadirCliente (int id, String nombre,int tel, String email, String sexo, String est_civil, String Situa_lab)
	{
		String rta =sistema.AnadirCliente(id, nombre, tel, email, sexo, est_civil, Situa_lab);
	}
	
	
	public void IniciarCompra(int prod)
	{
		sistema.IniciarCompra(prod);
	}
	
	public void FinalizarCompra() throws Exception
	{
		String rta =sistema.FinalizarCompra();
		panelProductos.actualizarInformacion(rta);
	}
	public Cliente consultarCliente(int idcliente) {
		return sistema.consultarCliente(idcliente);
	}
	
	public void actividadCliente() {
		dactividad = new DialogoActividad(this);
		dactividad.actualizarInformacion();
		dactividad.setVisible( true );
	}
	
	// ************************************************************************
	// Main
	// ************************************************************************

    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazTienda interfaz = new InterfazTienda( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}

