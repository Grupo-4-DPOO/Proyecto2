package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * Esta clase implementa un listener (ActionListener) para los eventos
 * relacionados con abrir los archivos de una librería.
 */
public class ListenerMenu implements ActionListener
{

	// ************************************************************************
	// Constantes
	// ************************************************************************

	public static final String ABRIR_LIBROS = "ABRIR_LIBROS";

	// ************************************************************************
	// Atributos
	// ************************************************************************

	private InterfazTienda ventana;

	// ************************************************************************
	// Constructores
	// ************************************************************************

	// ************************************************************************
	// Constructores
	// ************************************************************************
	

	public ListenerMenu(InterfazTienda interfazTienda)
	{
		ventana = interfazTienda;
	}

	// ************************************************************************
	// Métodos implementados de la interfaz
	// ************************************************************************

	/**
	 * Este método le pide al usuario el archivo con la información de las
	 * productos de la Tienda. Si
	 * todo sale bien con la selección de los archivos, se invoca al método
	 * cargarArchivos de la ventana principal de la aplicación.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if (ABRIR_LIBROS.equals(comando))
		{
			File archivo_categorias = null;
			JFileChooser fc = new JFileChooser("./data");
			fc.setDialogTitle("Seleccione el archivo con los productos");
			fc.setFileFilter(new FiltroCSV());
			int resultado = fc.showOpenDialog(ventana);
			if (resultado == JFileChooser.APPROVE_OPTION)
			{
				archivo_categorias = fc.getSelectedFile();

				try {
					ventana.cargarArchivos(archivo_categorias);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}

	}

	// ************************************************************************
	// Clases anidadas
	// ************************************************************************

	private final class FiltroCSV extends FileFilter
	{
		@Override
		public String getDescription()
		{
			return "Archivo CSV";
		}

		@Override
		public boolean accept(File f)
		{
			return f.isDirectory() || f.getName().toLowerCase().endsWith(".csv");
		}
	}

}
