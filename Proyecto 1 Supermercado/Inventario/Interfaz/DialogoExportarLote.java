package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class DialogoExportarLote extends JDialog {

    

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    
    private JTextField txtexportar;

    /**
     * Texto que contiene el nombre.
     */

    public DialogoExportarLote( )
    {

        setTitle( "Exportar Lote" );
        setSize( 500, 300 );
        
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new GridLayout( 1,1 ) );;
        
        txtexportar = new JTextField("El Archivo se exporto correctamente");
        txtexportar.setEditable(false);
        add(txtexportar);    
    }
}
