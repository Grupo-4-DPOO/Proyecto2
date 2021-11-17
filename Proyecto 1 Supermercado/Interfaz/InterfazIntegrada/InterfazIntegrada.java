package InterfazIntegrada;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Interface.InterfazTienda;
import Interfaz.InterfazInventario;


@SuppressWarnings("serial")
public class InterfazIntegrada extends JFrame{
	private PanelBotones1 pbotones;
	private PanelOpciones popciones;
	private InterfazInventario inventarioi;
	private InterfazTienda inventariot;

	
	public InterfazIntegrada() {

		setTitle( "Bienvenido" );
        setSize( 900, 650 );
        setDefaultCloseOperation( reqFuncCerrar() );
        setLayout(new BorderLayout());
        
        pbotones = new PanelBotones1(this);
        popciones = new PanelOpciones();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(popciones);
        panel.add(pbotones);
        
        add(panel, BorderLayout.CENTER);
	}		
	public void reqFuncIniciar( ) {
		String cual = popciones.elegido();
		if(cual.equals("POS")) {
			inventariot.main(null);
		}
		else {
			inventarioi.main(null);
		}
	}
	public int reqFuncCerrar( ) {
		dispose( );
		return 3;
	}
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazIntegrada interfaz = new InterfazIntegrada( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
