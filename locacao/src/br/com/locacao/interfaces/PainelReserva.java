package br.com.locacao.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import br.com.locacao.dao.ReservaDAO;
import br.com.locacao.dao.UsuarioDAO;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Reserva;
import br.com.locacao.modeloUsuario.Usuario;

public class PainelReserva extends JPanel{
	
	private JLabel titulo;
	private JTextField line;
	private JTextField line2;
	private JLabel consultartxt;
	private JTextField consultar;
	private JButton btconsultar;
	private JButton excluir;
	private JTable tabela;
	private JScrollPane scroll;
	
	
	public PainelReserva(){
		setSize(700,500);
		setBackground(new Color(255,255,255));
		setVisible(true);
		inicializarComponentes();
		eventos();
		setLayout(null);
	}
	
	
	public void inicializarComponentes() {
		
		
		titulo = new JLabel("Reservas");
		titulo.setFont(new Font("Arial", 4, 35));
		titulo.setForeground(new Color(16,78,139)); 
		
		line = new JTextField();
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		line2 = new JTextField();
		line2.setBorder(new LineBorder(new Color(70,130,180)));
		
		consultar = new JTextField();
		
		consultartxt = new JLabel();
		consultartxt.setText("Listar :");
		consultartxt.setFont(new Font("Arial", 4, 20));
		consultartxt.setForeground(new Color(16,78,139)); 
	
		DefaultTableModel tb = new DefaultTableModel(); 
		

		tabela = new JTable(tb);
		tabela.setModel(new DefaultTableModel(new Object [][] {}, new String [] {" nº reserva" , "nº matrícula" , "data" , "tempo_inicial" , "tempo_final", "disciplina" , "turma" }));
		tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(400); 
		tabela.getColumnModel().getColumn(2).setPreferredWidth(700);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(400);
	
		
		scroll = new JScrollPane(tabela);
		
		excluir = new JButton();
		excluir.setFont(new Font("Arial", 5, 16));
		excluir.setForeground(new Color(70, 130, 180));
		excluir.setText(" EXCLUIR ");
		excluir.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		excluir.setRequestFocusEnabled(false);
		excluir.setRolloverEnabled(false);
		excluir.setEnabled(false);
		
		btconsultar = new JButton();
		btconsultar.setFont(new Font("Arial", 5, 16));
		btconsultar.setForeground(new Color(70, 130, 180));
		btconsultar.setText(" OK ");
		btconsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		btconsultar.setRequestFocusEnabled(false);
		btconsultar.setRolloverEnabled(false);
		btconsultar.setMargin(new Insets(4, 100, 2, 14));
		
	    
		
		titulo.setBounds(260,-20,200,100);
		line.setBounds(190,55,300,2);
		line2.setBounds(50,400,580,1);
		consultartxt.setBounds(40,-45,250,300);
		consultar.setBounds(150,90,350,35);
		btconsultar.setBounds(510,89,150,36);
		excluir.setBounds(440,415,140,40);
		scroll.setBounds(30,150,600,200);
		
		scroll.setVisible(false);
		
		
		
		add(titulo);
		add(line);
		add(consultartxt);
		add(line2);
		add(consultar);
		add(btconsultar);
		add(excluir);
		add(scroll);
		
	}
	
	public void eventos(){
		btconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReservaDAO dao = new ReservaDAO();
				DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();	
				
				scroll.setVisible(true);
				
				while(tmb.getRowCount() > 0) {
					tmb.removeRow(0);
				}
					
				try {
					List<Reserva> u= dao.getReservas(consultar.getText());
					int count = 0;
					for(Reserva a : u){
						tmb.addRow(new String[count]);
						tabela.setValueAt(a.getReserva(), count, 0);
						tabela.setValueAt(a.getNumMatricula(), count, 1);
						tabela.setValueAt(a.getDataReserva(), count, 2);
						tabela.setValueAt(a.getTempoInicial(), count, 3);
						tabela.setValueAt(a.getTempoFinal(), count, 4);
						tabela.setValueAt(a.getDisciplina(), count, 5);
						tabela.setValueAt(a.getTurma(), count, 6);
						count++;
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
		btconsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Login.efetuarReserva.setEnabled(true);
				
			}
		});
		
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				excluir.setEnabled(true);
			}
		});
		
		excluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con = (Connection) Conexao.getConexao();
				DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();
				int k = tabela.getSelectedRow();  
			    int id = (int) tabela.getValueAt(k, 0);  
			     
			    String sql = "Delete from reservas where cod_reserva= "+id+" "; 
				
				PreparedStatement stmt2 = null;
				try {
					stmt2 = (PreparedStatement) con.prepareStatement(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					stmt2.execute();
					
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", 
"" ,JOptionPane.YES_NO_OPTION);
					
					if (tabela.getSelectedRow() >= 0 && resposta == JOptionPane.YES_OPTION){ 
						   tmb.removeRow(tabela.getSelectedRow());  
						   JOptionPane.showMessageDialog(null, "Reserva deletada com sucesso!");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	});
	
	}
	
	
}
