package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.Producto;



/**
 * Panel donde se muestran la información de un producto
 */
@SuppressWarnings("serial")
public class PanelProducto extends JPanel
{
	private JScrollPane scrollProducto;
    private JTextArea texto;
    private JLabel etiquetaImagen;

    public PanelProducto (){
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
