package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import modelo.Inventario;
import modelo.Lote;
import modelo.ProductoInv;

public class InterfazInventario extends JFrame{
	private Inventario inventario;
	private PanelBotones pbotones;
	private PanelInformacion pinformacion;
	private PanelInformacionLote plote;
	private DialogoCargarLote dcargarlote;
	private DialogoConsultarProducto dconsulp;
	private DialogoExportarLote dexportarlote;
	
	public InterfazInventario() {
		inventario=new Inventario();
		setTitle( "Manejador Inventario" );
        setSize( 900, 650 );
        setDefaultCloseOperation( reqFuncCerrar() );
        setLayout(new BorderLayout());
        
        pbotones = new PanelBotones(this);
        pinformacion = new PanelInformacion();
        plote = new PanelInformacionLote();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(plote);
        panel.add(pinformacion);
        
        add(pbotones, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
	}
	
	public void reqFuncCargar( ) {
	     dcargarlote = new DialogoCargarLote(this );
	     dcargarlote.setVisible( true );
		
	}
	public void reqFuncExportar( ) {
		try {
			inventario.exportarproductos();
			dexportarlote = new DialogoExportarLote();
			dexportarlote.setVisible( true );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void reqFuncConsultar( ){
		dconsulp = new DialogoConsultarProducto(this);
		dconsulp.setVisible( true );
	}
	public int reqFuncCerrar( ) {
		dispose( );
		return 3;
	}
	public void cargar(String ruta) throws Exception{
		inventario.cargarproductos(ruta);
		for (Lote l:inventario.getLote()) {
			String rta= l.toString();
			String rutaimagen = l.darRuta();
			plote.actualizarInformacion(rta);
			pinformacion.actualizarImagen(rutaimagen);
		}
	}
	public void consultar(int idproducto) {
		ProductoInv producto = inventario.consultarproducto(idproducto);
		String rta = producto.toString();
		String rutai = producto.getRutaimagen();
		pinformacion.actualizarImagen(rutai);
		pinformacion.actualizarInformacion(rta);
	}
	public void reqFuncRendimiento( ) {
		
	}
	public void reqFuncVencimiento() {
		String rta;
		try {
			rta = inventario.eliminarVencidos();
			plote.actualizarInformacion(rta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazInventario interfaz = new InterfazInventario( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}