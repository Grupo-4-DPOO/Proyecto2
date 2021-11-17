package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Cliente;

public class DialogoActividad extends JDialog{
	private JTextField mes1;
	private JTextField mes2;
	private JTextField mes3;
	private JTextField mes4;
	private JTextField mes5;
	private JTextField caract;
	private JTextField caract2;
	private JTextField carac3;
	private JTextField txt1;
	private JTextField txt2;
	private int mesactual;
	private InterfazTienda principal;
	
	
	@SuppressWarnings("deprecation")
	public DialogoActividad(InterfazTienda pPrincipal) {
		principal = pPrincipal;
		mesactual = new Date().getMonth();
		mes1 = new JTextField(Integer.toString(mesactual));
		mes2 = new JTextField(Integer.toString(mesactual-1));
		mes3 = new JTextField(Integer.toString(mesactual-2));
		mes4 = new JTextField(Integer.toString(mesactual-3));
		mes5 = new JTextField(Integer.toString(mesactual-4));
	
		mes1.setForeground(Color.RED);
		mes2.setForeground(Color.RED);
		mes3.setForeground(Color.RED);
		mes4.setForeground(Color.RED);
		mes5.setForeground(Color.RED);		
		caract = new JTextField("Verde mayor a 6 compras en el mes");
		caract2 = new JTextField("Azul menor a 5 compras en el mes");
		carac3 = new JTextField("Negro 0 compras en el mes");
		setLayout(new GridLayout(5,1));
		setSize(400,400);
		setTitle("Actividad Cliente:");
		txt1 = new JTextField("El cliente ha gastado: ");
		txt2 = new JTextField("");
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
        panel1.setLayout(new GridLayout(1,5));
        panel2.setLayout(new GridLayout(1,2));
        panel1.add(mes1);
        panel1.add(mes2);
        panel1.add(mes3);
        panel1.add(mes4);
        panel1.add(mes5);
        panel2.add(txt1);
        panel2.add(txt2);
        add(panel1);
        add(caract);
        add(caract2);
        add(carac3);
        add(panel2);
	}
	public void actualizarInformacion() {
		int idcliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula cliente a consultar: "));
		Cliente cliente = principal.consultarCliente(idcliente);
		txt2.setText(Double.toString(cliente.getPuntos()*1000));
		ArrayList<Date> lista = cliente.getFechas();  
		int mes1a = 0;
		int mes2a = 0;
		int mes3a = 0;
		int mes4a = 0;
		int mes5a = 0;
		for (int i =0; i<lista.size();i++) {
			int ms = lista.get(i).getMonth();
			if (ms==mesactual) {
				mes1a++;
			}
			else if (ms==mesactual-1) {
				mes2a++;
			}
			else if (ms==mesactual-2) {
				mes3a++;
			}
			else if (ms==mesactual-3) {
				mes4a++;
			}
			else if (ms==mesactual-4) {
				mes5a++;
			}
		}
		if (mes1a ==0) {
			mes1.setBackground(Color.BLACK);
		}
		if (mes1a <6 && mes1a>0) {
			mes1.setBackground(Color.BLUE);
		}
		if (mes1a <11 && mes1a>6) {
			mes1.setBackground(Color.GREEN);
		}
		if (mes2a ==0) {
			mes2.setBackground(Color.BLACK);
		}
		if (mes2a <6 && mes2a>0) {
			mes2.setBackground(Color.BLUE);
		}
		if (mes2a <11 && mes2a>6) {
			mes2.setBackground(Color.GREEN);
		}
		if (mes3a ==0 ) {
			mes3.setBackground(Color.BLACK);
		}
		if (mes3a <6 && mes3a>0) {
			mes3.setBackground(Color.BLUE);
		}
		if (mes3a <11 && mes3a>6) {
			mes3.setBackground(Color.GREEN);
		}
		if (mes4a ==0) {
			mes4.setBackground(Color.BLACK);
		}
		if (mes4a <6 && mes4a>0) {
			mes4.setBackground(Color.BLUE);
		}
		if (mes4a <11 && mes4a>6) {
			mes4.setBackground(Color.GREEN);
		}
		if (mes5a ==0) {
			mes5.setBackground(Color.BLACK);
		}
		if (mes5a <6 && mes5a>0) {
			mes5.setBackground(Color.BLUE);
		}
		if (mes5a <11 && mes5a>6) {
			mes5.setBackground(Color.GREEN);
		}
		
	}
}

