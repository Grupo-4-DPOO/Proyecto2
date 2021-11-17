package Interfaz;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelInformacionLote extends JPanel{
    private JScrollPane scrollLote;
    private JTextArea texto; 
	public PanelInformacionLote() {
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
