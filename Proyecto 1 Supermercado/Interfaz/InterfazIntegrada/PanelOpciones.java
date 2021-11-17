package InterfazIntegrada;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;

public class PanelOpciones extends JPanel{

	private JRadioButton sistemapos;
	private JRadioButton inventario;

	public PanelOpciones() {
        setLayout( new GridLayout( 1, 1) );
                
        sistemapos = new JRadioButton();
        sistemapos.setText("SISTEMA POS");
        sistemapos.setBounds(30, 20, 120, 30);
        
        inventario = new JRadioButton();
        inventario.setText("INVENTARIO");
        inventario.setBounds(60, 20, 120, 30);
        
        JPanel opciones = new JPanel();
        opciones.setLayout(new GridLayout(2,1));
        
        opciones.add(sistemapos);
        opciones.add(inventario);
        add(opciones);
        
        
    }
    public String elegido() {
    	String prueba = "";
        if (sistemapos.isSelected()) {
            prueba = "POS";
        }
        else if (inventario.isSelected()) {
        	prueba = "INV";
        }
        return prueba;
    }
}
