package br.com.locacao.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import br.com.locacao.dao.UsuarioDAO;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Usuario;

public class PainelUsuarios extends JPanel{
	
	public int linha;
	private static Usuario userSelecionada = null;
	private JLabel usuariotxt;
	private JLabel listartxt;
	private JTextField tflistar;
	private JButton btlistar;
	private static JTable tabela;
	private JScrollPane scroll;
	private JButton excluir2;
	private JTextField line;
	private JTextField line2;
	
	UsuarioDAO dao = new UsuarioDAO();
	Usuario a = new Usuario();
	
	
	public PainelUsuarios(){
		setSize(700,500);
		inicializarComponentes();
		setBackground(new Color(255,255,255));
		eventos();
		setLayout(null);
		setVisible(true);
		
	}
	
	public void inicializarComponentes(){
		usuariotxt = new JLabel("Usuário");
		usuariotxt.setFont(new Font("Arial", 15, 30));
		usuariotxt.setForeground(new Color(16,78,139)); 
		
		
		listartxt = new JLabel("Listar :");
		tflistar = new JTextField();
		tflistar.setBorder(new LineBorder(new Color(70,130,180)));

		
		
		DefaultTableModel tb = new DefaultTableModel(); 
		

		tabela = new JTable(tb);
		tabela.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"num_matricula" , "nome" , "email" , "login" , "senha" }));
		tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(400); 
		tabela.getColumnModel().getColumn(2).setPreferredWidth(700);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(500);
	
		
		scroll = new JScrollPane(tabela);
		
		excluir2 = new JButton();
		excluir2.setText("EXCLUIR");
		excluir2.setEnabled(false);
		excluir2.setEnabled(false);
		excluir2.setFont(new Font("Arial", 5, 16));
		excluir2.setForeground(new Color(70, 130, 180));
		excluir2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		excluir2.setRequestFocusEnabled(false);
		excluir2.setRolloverEnabled(false);
		excluir2.setMargin(new Insets(2, 100, 2, 14));
		excluir2.setVisible(true);
		
		
		listartxt.setFont(new Font("Arial", 4, 20));
		listartxt.setForeground(new Color(16,78,139)); 
		
		line2 = new JTextField();
		line2.setBorder(new LineBorder(new Color(70,130,180)));
		
		btlistar = new JButton("OK");
		btlistar.setFont(new Font("Arial", 5, 16));
		btlistar.setForeground(new Color(70, 130, 180));
		btlistar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		btlistar.setRequestFocusEnabled(false);
		btlistar.setRolloverEnabled(false);
		btlistar.setMargin(new Insets(2, 100, 2, 14));
		
		line = new JTextField ();
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		usuariotxt.setBounds(280, -75, 300, 215);
		line.setBounds(160,55,340, 1);
		
		listartxt.setBounds(40,-45,250,300);
		tflistar.setBounds(150,90,350,35);
		btlistar.setBounds(510,89,150,36);
		scroll.setBounds(30,150,600,200);
		line2.setBounds(50,400,580,1);
		excluir2.setBounds(440,415,140,40);
		
		
		scroll.setVisible(false);
		
		
		add(usuariotxt);
		add(line);
		add(listartxt);
		add(tflistar);
		add(btlistar);
		add(scroll);
		add(excluir2);
		add(line2);
		
		
	}
	
	
	public void eventos(){
		btlistar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UsuarioDAO dao = new UsuarioDAO();
				DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();	
				
				scroll.setVisible(true);
				
				while(tmb.getRowCount() > 0) {
					tmb.removeRow(0);
				}
					
				try {
					List<Usuario> u= dao.getUsuarios(tflistar.getText());
					int count = 0;
					for(Usuario a : u){
						tmb.addRow(new String[count]);
						tabela.setValueAt(a.getNum_matricula(), count, 0);
						tabela.setValueAt(a.getNome(), count, 1);
						tabela.setValueAt(a.getEmail(), count, 2);
						tabela.setValueAt(a.getLogin(), count, 3);
						tabela.setValueAt(a.getSenha(), count, 4);
						count++;
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login.editar1.setEnabled(true);
				excluir2.setEnabled(true);
				DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();
				linha = tabela.getSelectedRow();
				userSelecionada = new Usuario();
				userSelecionada.setNum_matricula((int) tabela.getValueAt(linha, 0));
				userSelecionada.setNome(tabela.getValueAt(linha, 1).toString());
				userSelecionada.setEmail(tabela.getValueAt(linha, 2).toString());
				userSelecionada.setLogin(tabela.getValueAt(linha, 3).toString());
				userSelecionada.setSenha(tabela.getValueAt(linha, 4).toString());
				
			}
		});
		
		tflistar.addMouseListener(new MouseListener() {
			
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
				Login.editar1.setEnabled(false);
				excluir2.setEnabled(false);
				
			}
		});
		
		btlistar.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
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
				Login.editar1.setEnabled(false);
				excluir2.setEnabled(false);
			}
		});
		
		
		
		
		excluir2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
					
				}	
			});
		
	
		excluir2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con = (Connection) Conexao.getConexao();
				DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();
				int k = tabela.getSelectedRow();  
			    int id = (int) tabela.getValueAt(k, 0);  
			     
			    String sql = "Delete from usuario where num_matricula= "+id+" "; 
				
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
						   JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
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
	
	public static Usuario linhaSelecionada(){
		return userSelecionada;
	}
			
			
}		
			
		
	
	

