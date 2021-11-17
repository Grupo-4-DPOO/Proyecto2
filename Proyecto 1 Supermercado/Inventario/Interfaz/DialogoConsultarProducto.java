package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class DialogoConsultarProducto extends JDialog implements ActionListener{
    public final static String ACEPTAR = "ACEPTAR";
    public final static String CANCELAR = "CANCELAR";
    

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    private InterfazInventario principal;
    
    private JButton botonAceptar;
    
    private JButton botonCancelar;
    
    private JTextField txtid;

    /**
     * Texto que contiene el nombre.
     */
    private JTextField lblid;

    public DialogoConsultarProducto( InterfazInventario pPrincipal)
    {
        principal = pPrincipal;

        setTitle( "Consultar Producto" );
        setSize( 500, 300 );
        
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new GridLayout( 2,2 ) );

        lblid = new JTextField("Ingrese el id del producto a consultar");
        lblid.setEditable(false);
        add(lblid);
        
        txtid = new JTextField();
        txtid.setEditable(true);
        add(txtid);
        
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
				principal.consultar(Integer.parseInt(txtid.getText()));
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
