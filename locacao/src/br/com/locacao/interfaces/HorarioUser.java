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

import br.com.locacao.dao.HorarioDAO;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Horario;

public class HorarioUser extends JPanel{
	private JLabel titulo;
	private JTextField line;
	private JLabel consultartxt;
	private JTextField consultar;
	private JButton btconsultar;
	private JTable tabela;
	private JScrollPane scroll;
	private static Horario userSelecionada = null;
	public int linha;
	
	
	public HorarioUser(){
		setSize(700,500);
		setBackground(new Color(255,255,255));
		setVisible(true);
		inicializarComponentes();
		eventos();
		setLayout(null);
	}
	
	
	public void inicializarComponentes() {
		
		
		titulo = new JLabel("Horários");
		titulo.setFont(new Font("Arial", 4, 35));
		titulo.setForeground(new Color(16,78,139)); 
		
		line = new JTextField();
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		
		
		consultar = new JTextField();
		
		consultartxt = new JLabel();
		consultartxt.setText("Listar :");
		consultartxt.setFont(new Font("Arial", 4, 20));
		consultartxt.setForeground(new Color(16,78,139)); 
	
		
		DefaultTableModel tb = new DefaultTableModel(); 
		

		tabela = new JTable(tb);
		tabela.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"cod_reserva" , "dia da semana","tempo" }));
		tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(400); 
		tabela.getColumnModel().getColumn(2).setPreferredWidth(400); 
	
		
		scroll = new JScrollPane(tabela);
		
		
		
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
		consultartxt.setBounds(40,-45,250,300);
		consultar.setBounds(150,90,350,35);
		btconsultar.setBounds(510,89,150,36);
		
		scroll.setBounds(30,150,600,200);
		
		scroll.setVisible(false);
		
		
		add(titulo);
		add(line);
		add(consultartxt);
		add(consultar);
		add(btconsultar);
		add(scroll);
		
	}
	
	public void eventos(){
		btconsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HorarioDAO dao = new HorarioDAO();
				DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();	
				
				scroll.setVisible(true);
				
				while(tmb.getRowCount() > 0) {
					tmb.removeRow(0);
				}
					
				try {
					List<Horario> u = dao.getHorarios(consultar.getText());
					int count = 0;
					for(Horario a : u){
						tmb.addRow(new String[count]);
						tabela.setValueAt(a.getCod_horario(), count, 0);
						tabela.setValueAt(a.getDiaDaSemana(), count, 1);
						tabela.setValueAt(a.getTempo(), count, 2);
						count++;
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		
	}
	
	
}
