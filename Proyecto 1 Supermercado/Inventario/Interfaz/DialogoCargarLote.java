package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DialogoCargarLote extends JDialog implements ActionListener{
    public final static String ACEPTAR = "ACEPTAR";
    public final static String CANCELAR = "CANCELAR";
    

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    private InterfazInventario principal;
    
    private JButton botonAceptar;
    
    private JButton botonCancelar;
    
    private JTextField txtruta;

    /**
     * Texto que contiene el nombre.
     */
    private JTextField lblruta;

    public DialogoCargarLote( InterfazInventario pPrincipal)
    {
        principal = pPrincipal;

        setTitle( "Cargar Lote" );
        setSize( 500, 300 );
        
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new GridLayout( 2,2 ) );

        lblruta = new JTextField("Ingrese la ruta del archivo");
        lblruta.setEditable(false);
        add(lblruta);
        
        txtruta = new JTextField();
        txtruta.setEditable(true);
        add(txtruta);
        
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );
        add( botonAceptar );

        // Cancelar
        botonCancelar = new JButton( );
        botonCancelar.setText( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );
        
        
    }
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            try {
				principal.cargar(txtruta.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
