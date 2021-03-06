package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import SistemaDeMonitoramento.Sistema;
import SistemaDeMonitoramento.Unidade;


public class UnidadeUI extends JFrame implements ActionListener{
		private Container con;
		private JButton btnAdd;
		private JButton btnExcluir;
		private JButton btnMonitorar;
		private JButton btnListar;
		
	public UnidadeUI(){
			this.setSize(400, 400);
			this.setTitle("Sistema De Monitoramento");
			this.setVisible(true);
			this.con = this.getContentPane();
			this.con.setLayout(new GridLayout());
			this.instantiate();
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
	public void instantiate() {
		this.btnAdd = new JButton("Adcionar maquina");
		this.btnAdd.addActionListener(this);
		this.btnExcluir = new JButton("Excluir maquina");
		this.btnExcluir.addActionListener(this);
		this.btnMonitorar = new JButton("Monitorar");
		this.btnMonitorar.addActionListener(this);
		this.btnListar = new JButton("Listar Maquinas");
		this.btnListar.addActionListener(this);
		
		
	}
	public void asmBorder() {
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(4,0));
		jpCenter.setSize(200, 200);
		jpCenter.setBorder(BorderFactory.createEmptyBorder(80,80,80,80));
		
		jpCenter.add(this.btnAdd);
		jpCenter.add(this.btnExcluir);
		jpCenter.add(this.btnMonitorar);
		jpCenter.add(this.btnListar);
		this.con.add(jpCenter, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		UnidadeUI teste = new UnidadeUI();
		teste.asmBorder();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.btnAdd))
			doADD();
		if(e.getSource().equals(this.btnMonitorar))
			doMonitorar();
		if(e.getSource().equals(this.btnListar))
			try {
				doListar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	private void doListar() throws Exception {
		Sistema sistema = new Sistema();
		Set<Unidade> unidade = sistema.getUnidades();
		String strg = "";
		for(Unidade uni : unidade)
			strg += uni.toString();
		JOptionPane.showMessageDialog(this, strg);
	}
	private void doMonitorar() {
		UnidadeUIMonitorar uiMon = new UnidadeUIMonitorar();
		
	}
	public void doADD() {
		UnidadeUIAdd uiAdd = new UnidadeUIAdd();
	}
}
