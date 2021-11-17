package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import InterfazIntegrada.InterfazIntegrada;

@SuppressWarnings("serial")
public class PanelBotones  extends JPanel implements ActionListener{
    private static final String Cargar_Lote = "Cargar_Lote";
    private static final String Exportar_lote = "Exportar_lote";
    private static final String Consultar = "Consultar";
    private static final String Rendimiento = "Rendimiento";
    private static final String Eliminar_Vencimiento = "Eliminar_Vencimiento";
    private static final String Cerrar = "Cerrar";
    
    /**
     * Comando Nuevo.
     */

    private InterfazInventario principal;
    private JButton btnNuevo;
    private JButton btnRendimiento;
    private JButton btnVencimiento;
    private JButton btnReiniciar;
    private JButton btnTop;
    private JButton btnCerrar;
    
    
    
	public PanelBotones(InterfazInventario pPrincipal){
		principal = pPrincipal;
        setLayout( new GridLayout( 1, 6 ) );
        

        btnNuevo = new JButton( "Cargar Lote" );
        btnNuevo.setActionCommand( Cargar_Lote );
        btnNuevo.addActionListener( this );
        add( btnNuevo );

        btnReiniciar = new JButton("Exportar lote");
        btnReiniciar.setActionCommand(Exportar_lote);
        btnReiniciar.addActionListener(this);
        add(btnReiniciar);
        
        btnTop = new JButton("Consultar");
        btnTop.setActionCommand(Consultar);
        btnTop.addActionListener(this);
        add(btnTop);
        
        btnNuevo = new JButton( "Rendimiento" );
        btnNuevo.setActionCommand( Rendimiento );
        btnNuevo.addActionListener( this );
        add( btnNuevo );

        btnNuevo = new JButton( "Eliminar_Vencimiento" );
        btnNuevo.setActionCommand( Eliminar_Vencimiento );
        btnNuevo.addActionListener( this );
        add( btnNuevo );
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setActionCommand(Cerrar);
        btnCerrar.addActionListener(this);
        add(btnCerrar);
        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( Cargar_Lote.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncCargar( );
        }
        else if( Exportar_lote.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncExportar( );
        }
        else if( Consultar.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncConsultar( );
        }
        else if( Rendimiento.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncRendimiento( );
        }
        else if( Eliminar_Vencimiento.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncVencimiento( );
        }
        else if( Cerrar.equals( pEvento.getActionCommand( ) ) )
        {
           principal.reqFuncCerrar( );
        }
    }
}
