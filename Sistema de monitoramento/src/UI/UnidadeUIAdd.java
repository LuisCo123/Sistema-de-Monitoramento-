package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.ErrorManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SistemaDeMonitoramento.Sistema;

public class UnidadeUIAdd extends JFrame implements ActionListener{
	
	private JLabel lbId;
	private JTextField txtId;
	private JLabel lbOrdenada;
	private JTextField txtOrdenada;
	private JLabel lbAbscissa;
	private JTextField txtAbscissa;
	private JCheckBox btnCO2;
	private JCheckBox btnTerm;
	private JCheckBox btnCH4;
	private JCheckBox btnVideo;
	private JButton btnEuclid;
	private JButton btnManh;

	private Container con;

	public UnidadeUIAdd() {
		
		this.setSize(400, 400);
		this.setTitle("ADD MAQUINA");
		this.setVisible(true);
		this.con = this.getContentPane();
		this.con.setLayout(new BorderLayout());
		this.instantiate();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void instantiate() {
		this.lbId = new JLabel("ID: ");
		this.txtId= new JTextField();
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
		this.btnEuclid = new JButton("ADD MAQUINA EUCLIDIANA");
		this.btnEuclid.addActionListener(this);
		this.btnManh = new JButton("ADD MAQUINA MANHATTAN");
		this.btnManh.addActionListener(this);

		this.asmBorder();
	}
	public void asmBorder() {
		
		JPanel jpTopLeft = new JPanel();
		JPanel jpTopRight = new JPanel();
		JPanel jpDownLeft = new JPanel();
		JPanel jpDownRight = new JPanel();
		jpTopLeft.setLayout(new GridLayout(3,2));
		jpTopLeft.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 0));
		jpTopLeft.add(this.lbId);
		jpTopLeft.add(this.txtId);
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
		
		jpDownLeft.setLayout(new GridLayout(0,2));
		jpDownLeft.add(btnEuclid);
		jpDownLeft.add(btnManh);
		this.con.add(jpDownLeft, BorderLayout.PAGE_END);
		
	

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnEuclid))
			try {
				doEuclidiana();
				
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,
						"NUMERO INVALIDO",
					    "TIPO INCORRETO", JOptionPane.ERROR_MESSAGE);
			} catch(SQLException e3) {
				  JOptionPane.showMessageDialog(this,
							"Maquina Existente",
						    "Impossivel Adcionar", JOptionPane.ERROR_MESSAGE);
				  
			  }catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(e.getSource().equals(btnManh))
			try {
				doManhattan();
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,
						"NUMERO INVALIDO",
					    "TIPO INCORRETO", JOptionPane.ERROR_MESSAGE);}
			  catch(SQLException e3) {
				  JOptionPane.showMessageDialog(this,
							"Maquina Existente",
						    "Impossivel Adcionar", JOptionPane.ERROR_MESSAGE);
				  
			  }
			  catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
		}
	private void doManhattan() throws Exception {
		Sistema sistema = new Sistema();
		sistema.addUnidadeManhattan(Integer.parseInt(this.txtId.getText()), Float.parseFloat(this.txtAbscissa.getText()),
				Float.parseFloat(this.txtOrdenada.getText()), this.btnVideo.isSelected(), this.btnTerm.isSelected(), this.btnCO2.isSelected(), this.btnCH4.isSelected());
		this.dispose();
	}
	private void doEuclidiana() throws Exception {
		Sistema sistema = new Sistema();
		sistema.addUnidadeEuclidiana(Integer.parseInt(this.txtId.getText()), Float.parseFloat(this.txtAbscissa.getText()),
				Float.parseFloat(this.txtOrdenada.getText()), this.btnVideo.isSelected(), this.btnTerm.isSelected(), this.btnCO2.isSelected(), this.btnCH4.isSelected());
		this.dispose();
		
	}
		
	
}
