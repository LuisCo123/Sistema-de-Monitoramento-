package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SistemaDeMonitoramento.Sistema;

public class UnidadeUIMonitorar extends JFrame implements ActionListener {
	private JLabel lbOrdenada;
	private JTextField txtOrdenada;
	private JLabel lbAbscissa;
	private JTextField txtAbscissa;
	private JCheckBox btnCO2;
	private JCheckBox btnTerm;
	private JCheckBox btnCH4;
	private JCheckBox btnVideo;
	private JButton btnMonitorar;
	private Container con;
	
	public UnidadeUIMonitorar() {
		
		this.setSize(400, 400);
		this.setTitle("MONITORAR");
		this.setVisible(true);
		this.con = this.getContentPane();
		this.con.setLayout(new BorderLayout());
		this.instantiate();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void instantiate() {
		this.lbOrdenada = new JLabel("ORDENADA: ");
		this.txtOrdenada= new JTextField();
		this.lbAbscissa = new JLabel("ABSCISSA: ");
		this.txtAbscissa= new JTextField();
		this.btnCO2 = new JCheckBox("CO2");
		this.btnCO2.addActionListener(this);
		this.btnTerm = new JCheckBox("TERMOMETRO");
		this.btnTerm.addActionListener(this);
		this.btnCH4 = new JCheckBox("CH4");
		this.btnCH4.addActionListener(this);
		this.btnVideo = new JCheckBox("VIDEO");
		this.btnVideo.addActionListener(this);
		this.btnMonitorar = new JButton("MONITORAR");
		this.btnMonitorar.addActionListener(this);
		this.asmBorder();
		
	}
public void asmBorder() {
		
		JPanel jpTopLeft = new JPanel();
		JPanel jpTopRight = new JPanel();
		JPanel jpDownLeft = new JPanel();
		jpTopLeft.setLayout(new GridLayout(2,2));
		jpTopLeft.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 0));
		jpTopLeft.add(this.lbOrdenada);
		jpTopLeft.add(this.txtOrdenada);
		jpTopLeft.add(this.lbAbscissa);
		jpTopLeft.add(this.txtAbscissa);
		this.con.add(jpTopLeft, BorderLayout.LINE_START);
		
		
		
		jpTopRight.setLayout(new GridLayout(4,0));
		jpTopRight.add(btnCH4);
		jpTopRight.add(btnVideo);
		jpTopRight.add(btnTerm);
		jpTopRight.add(btnCO2);
		jpTopRight.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 0));
		this.con.add(jpTopRight, BorderLayout.CENTER);
		
		jpDownLeft.add(btnMonitorar);
		
		this.con.add(jpDownLeft, BorderLayout.PAGE_END);
		
}

@Override
public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnMonitorar)) {
			try {
				doMonitorar();
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,
						"NUMERO INVALIDO",
					    "TIPO INCORRETO", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
			
	
}

private void doMonitorar() throws Exception {
		Sistema sistema = new Sistema();
		String strg;
		strg = sistema.monitorar(Float.parseFloat(this.txtAbscissa.getText()), 
				Float.parseFloat(this.txtOrdenada.getText()), this.btnVideo.isSelected(),
				this.btnTerm.isSelected(),this.btnCO2.isSelected(), this.btnCH4.isSelected());
		JOptionPane.showMessageDialog(this, strg);
}
}
