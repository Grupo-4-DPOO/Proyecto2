package Interface;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import modelo.Producto;

/**
 * En este panel se tienen los botones con acciones para realizar sobre la
 * librería.
 * 
 * Este panel también cumple el rol de ser el Listeners para sus propios
 * botones.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
	// ************************************************************************
	// Constantes
	// ************************************************************************

	private final static String NUEVA_COMPRA = "NuevaCompra";

	private final static String AGREGAR_PRODUCTO = "agregar producto de paquete";

	private final static String AGREGAR_PRODUCTO_P = "agregar producto por peso";

	private final static String ELIMINAR_PRODUCTO = "Eliminar producto";

	private final static String ELIMINAR_PRODUCTO_PESO = "Eliminar producto por peso";

	private final static String FINALIZAR_COMPRA = "Finalizar compra";
	
	private final static String Actividad = "Actividad";

	private final static String A�ADIR_USUARIO = "A�adir un nuevo usuario a la tienda";




	
	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * Ventana que contiene al panel
	 */
	private InterfazTienda ventana;

	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye un nuevo panel para mostrar los botones con acciones
	 * 
	 * @param interfazLibreria La ventana dentro de la que se encuentra el panel
	 */
	public PanelBotones(InterfazTienda interfazLibreria)
	{
		
		ventana = interfazLibreria;
		setBorder(new TitledBorder("Acciones"));
	

		setLayout(new GridLayout(4,2));
		agregarBoton(NUEVA_COMPRA, "Iniciar Compra", "Iniciar Compra");
		agregarBoton(AGREGAR_PRODUCTO, "Agregar producto empaquetado", "Agregar Producto");
		agregarBoton(AGREGAR_PRODUCTO_P, "Agregar producto peso", "Agregar Peso");
		agregarBoton(ELIMINAR_PRODUCTO, "Eliminar producto", "Eliminar Producto");
		agregarBoton(ELIMINAR_PRODUCTO_PESO, "Eliminar peso", "Eliminar Peso");
		agregarBoton(FINALIZAR_COMPRA, "Finalizar la compra actual", "Finalizar Compra");
		agregarBoton(Actividad, "Actividad", "Actividad");
		agregarBoton(A�ADIR_USUARIO, "A�adir un nuevo cliente", "A�adir Usuario");
		

	}
	
	// ************************************************************************
	// Métodos
	// ************************************************************************

	/**
	 * Este método sirve para agregar un botón al panel con las características
	 * especificadas en los atributos. Este método sólo debería usarse durante la
	 * construcción del panel.
	 * 
	 * @param comando El comando asociado al botón que se usará para identificarlo
	 *                cuando se haga click.
	 * @param texto   El texto que se mostrará en el "tooltip" (ayuda) del botón.
	 * @param imagen  La ruta a la imagen que se usará como ícono del botón.
	 */
	private void agregarBoton(String comando, String texto, String nombre)
	{
		JButton boton = new JButton();
		boton.setActionCommand(comando);
		boton.setToolTipText(texto);
		boton.setText(nombre);
		boton.addActionListener(this);
		this.add(boton);
	}

	// ************************************************************************
	// Métodos implementados de la interfaz ActionListener
	// ************************************************************************

	/**
	 * Este es el método que se invoca cuando se hace click sobre alguno de los
	 * botones en el panel.
	 * 
	 * Invoca un método diferente de la ventana principal de la aplicación
	 * dependiendo del botón que haya sido presionado.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		String comando = e.getActionCommand();

		if (NUEVA_COMPRA.equals(comando))
		{
			ventana.IniciarCompra( Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de documento")));
		}
		else if (AGREGAR_PRODUCTO.equals(comando))
		{
			ventana.AgregarProducto( Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto")));
		}
		
		else if (AGREGAR_PRODUCTO_P.equals(comando))
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto"));
			int Peso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el peso a eliminar"));
			ventana.AgregarProductoPeso(id, Peso);
		}
		
		else if (ELIMINAR_PRODUCTO.equals(comando))
		{
			ventana.EliminarProducto( Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto")));
		}
		else if (ELIMINAR_PRODUCTO_PESO.equals(comando))
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto"));
			int Peso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el peso a eliminar"));
			ventana.EliminarProductoPeso(id, Peso);
		}
		else if (FINALIZAR_COMPRA.equals(comando))
		{
			try {
				ventana.FinalizarCompra();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (Actividad.equals(comando))
		{
			ventana.actividadCliente();
		}
		else if (A�ADIR_USUARIO.equals(comando))
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el su numero de documento:"));
			String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
			int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de celular:"));
			String email = JOptionPane.showInputDialog("Ingrese su correo electronico:");
			String sexo = JOptionPane.showInputDialog("Ingrese su sexo (F/M):");
			String estado_Civil = JOptionPane.showInputDialog("Ingrese su estado Civil:");
			String Situa_lab = JOptionPane.showInputDialog("Ingrese su situacion laboral actual:");
			ventana.AnadirCliente(id, nombre, telefono, email, sexo, estado_Civil, Situa_lab);
			
		}

	}


}
