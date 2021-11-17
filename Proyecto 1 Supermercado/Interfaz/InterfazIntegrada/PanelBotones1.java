package InterfazIntegrada;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotones1 extends JPanel implements ActionListener {
    public final static String INICIAR = "INICIAR";

    public final static String CERRAR = "CERRAR";
    private JButton bIniciar;
    private JButton bCerrar;
    private InterfazIntegrada principal;
    
    public PanelBotones1(InterfazIntegrada pPrincipal) {
    	principal = pPrincipal;
        setLayout( new GridLayout( 1, 2 ) );
        

        bIniciar = new JButton( "INICIAR" );
        bIniciar.setActionCommand( INICIAR );
        bIniciar.addActionListener( this );
        add( bIniciar );

        bCerrar = new JButton("CERRAR");
        bCerrar.setActionCommand(CERRAR);
        bCerrar.addActionListener(this);
        add(bCerrar);
    }
    public void actionPerformed( ActionEvent pEvento )
    {
        if( INICIAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncIniciar( );
        }
        else if( CERRAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncCerrar( );
        }
    }
}
