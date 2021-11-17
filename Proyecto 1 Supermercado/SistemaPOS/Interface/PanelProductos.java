package Interface;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Producto;


@SuppressWarnings("serial")
public class PanelProductos extends JPanel {
    private JScrollPane scrollLote;
    private JTextArea texto; 
	public PanelProductos() {
        setLayout( new BorderLayout( ) );
        
        texto = new JTextArea("Informacion Lote:");
        
        scrollLote = new JScrollPane( texto );
 
        add(scrollLote, BorderLayout.CENTER);
       
        
	}
    public void actualizarInformacion( String informacion)
    {
    	String txt = texto.getText() + "\n" + informacion;
    	texto.setText(txt);
    }
}
