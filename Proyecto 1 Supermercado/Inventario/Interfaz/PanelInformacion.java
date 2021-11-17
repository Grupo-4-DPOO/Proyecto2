package Interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel{
	private JScrollPane scrollProducto;
    private JTextArea texto;
    private JLabel etiquetaImagen;

    public PanelInformacion (){
        setLayout( new GridLayout( 2,1) );
        
        JPanel panelInfo = new JPanel( );
        panelInfo.setLayout( new BorderLayout( ) );
        panelInfo.setSize(getPreferredSize());
        
        JPanel panelImagen = new JPanel( );
        panelImagen.setLayout( new BorderLayout( ) );
        panelImagen.setBackground( new Color( 239, 250, 252 ) );
        panelImagen.setBorder( new LineBorder( Color.BLACK ) );
        panelImagen.setSize(getPreferredSize());
        
        etiquetaImagen = new JLabel( );
    	etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);
    	etiquetaImagen.setVerticalAlignment(JLabel.CENTER);

    	
        panelImagen.add( etiquetaImagen );
        
        texto = new JTextArea("Informacion Producto:");
        
        scrollProducto = new JScrollPane( texto );
 
        panelInfo.add(scrollProducto, BorderLayout.CENTER);
        add(panelImagen);
        add(panelInfo);
    	}
        
        
        public void actualizarInformacion( String informacion)
        {
        	String txt = texto.getText() + "\n" + informacion;
        	texto.setText(txt);
        }
        public void actualizarImagen( String ruta)
        {
        	Image image = new ImageIcon(ruta).getImage();
        	ImageIcon img2=new ImageIcon(image.getScaledInstance(180,430 , Image.SCALE_SMOOTH));
        	etiquetaImagen.setIcon(img2);

        }
}
