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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import br.com.locacao.dao.EquipamentoDAO;
import br.com.locacao.dao.UsuarioDAO;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Equipamento;
import br.com.locacao.modeloUsuario.Usuario;

public class PainelEquipamentos extends JPanel{
	
		public int linha;
		private JLabel titulo;
		private JLabel subtitulo;
		private JLabel consultar;
		private static Equipamento userSelecionada = null;
		private JTextField consultartxt;
		private JTextField line;
		private JTextField line2;
		private JButton btconsulta;
		private JButton btsair;
		private JTable tabela;
		private JScrollPane scroll;
		private JButton editar2;
		private JButton excluir;
		

		
		public PainelEquipamentos() {
			inicializarComponentes();
			setBackground(new Color(255,255,255));
			eventos();
			setLayout(null);
			
}
		
		public void inicializarComponentes() {
			titulo = new JLabel("Equipamentos");
			titulo.setFont(new Font("Arial", 4, 28));
			titulo.setForeground(new Color(16,78,139));
			
			subtitulo = new JLabel("Listar : ");
			subtitulo.setFont(new Font("Arial", 4, 22));
			subtitulo.setForeground(new Color(16,78,139));
			
			line = new JTextField();
			line.setBorder(new LineBorder(new Color(70,130,180)));
			
			line2 = new JTextField();
			line2.setBorder(new LineBorder(new Color(70,130,180)));
			
			consultartxt = new JTextField();
			consultartxt.setBorder(new LineBorder(new Color(70,130,180)));
			consultartxt.setMargin(new Insets(4, 100, 2, 14));
			
			btconsulta = new JButton();
			btconsulta.setFont(new Font("Arial", 5, 16));
			btconsulta.setForeground(new Color(70, 130, 180));
			btconsulta.setText(" OK ");
			btconsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
			btconsulta.setRequestFocusEnabled(false);
			btconsulta.setRolloverEnabled(false);
			btconsulta.setMargin(new Insets(4, 100, 2, 14));
			
			DefaultTableModel tb = new DefaultTableModel(); 
			

			tabela = new JTable(tb);
			tabela.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"cod_equipamento" , "nome" , "descricao" ,  }));
			tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(400); 
			tabela.getColumnModel().getColumn(2).setPreferredWidth(700);
			
		
			
			scroll = new JScrollPane(tabela);
			
			
			
			
			excluir = new JButton("EXCLUIR");
			excluir.setFont(new Font("Arial", 5, 16));
			excluir.setForeground(new Color(70, 130, 180));
			excluir.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
			excluir.setRequestFocusEnabled(false);
			excluir.setRolloverEnabled(false);
			excluir.setMargin(new Insets(2, 100, 2, 14));
			excluir.setEnabled(false);
			
			btsair = new JButton("SAIR");
			btsair.setFont(new Font("Arial", 5, 16));
			btsair.setForeground(new Color(70, 130, 180));
			btsair.setText(" SAIR ");
			btsair.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
			btsair.setRequestFocusEnabled(false);
			btsair.setRolloverEnabled(false);
			btsair.setMargin(new Insets(2, 100, 2, 14));
			scroll.setVisible(false);

			titulo.setBounds(250,-20,200,100);
			subtitulo.setBounds(40,-45,250,300);
			line.setBounds(190,55,300,2);
			line2.setBounds(50,400,580,1);
			consultartxt.setBounds(150,90,350,35);
			btconsulta.setBounds(510,89,150,36);
			scroll.setBounds(30,150,600,200);
			excluir.setBounds(440,415,140,40);
			
			add(titulo);
			add(subtitulo);
			add(line);
			add(line2);
			add(consultartxt);
			add(btconsulta);
			add(btsair);
			add(scroll);
			add(excluir);
			
		}
		
		
		public void eventos(){
			btconsulta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					EquipamentoDAO dao = new EquipamentoDAO();
					DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();	
					
					scroll.setVisible(true);
					
					while(tmb.getRowCount() > 0) {
						tmb.removeRow(0);
					}
						
					try {
						List<Equipamento> b = dao.getEquipamento(consultartxt.getText());
						int count = 0;
						for(Equipamento a : b){
							tmb.addRow(new String[count]);
							tabela.setValueAt(a.getCod_equipamentos(), count, 0);
							tabela.setValueAt(a.getNome_equipamento(), count, 1);
							tabela.setValueAt(a.getDescricao(), count, 2);
							
							System.out.println(a.getCod_equipamentos());
							System.out.println(a.getNome_equipamento());
							System.out.println(a.getDescricao());
							
							count++;
						}
					} catch (SQLException d) {
						// TODO Auto-generated catch block
						d.printStackTrace();
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
					Login.editar2.setEnabled(true);
					excluir.setEnabled(true);
					
					DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();
					linha = tabela.getSelectedRow();
					userSelecionada = new Equipamento();
					userSelecionada.setCod_equipamentos((int) tabela.getValueAt(linha, 0));
					userSelecionada.setNome_equipamento(tabela.getValueAt(linha, 1).toString());
					userSelecionada.setDescricao(tabela.getValueAt(linha, 2).toString());
				}
			});
			
			excluir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Connection con = (Connection) Conexao.getConexao();
					DefaultTableModel tmb = (DefaultTableModel) tabela.getModel();
					int k = tabela.getSelectedRow();  
				    int id = (int) tabela.getValueAt(k, 0);  
				     
				    String sql = "Delete from equipamentos where cod_equipamento= "+id+" "; 
					
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
							   JOptionPane.showMessageDialog(null, "Equipamento deletado com sucesso!");
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
		
		public static Equipamento linhaSelecionada(){
			return userSelecionada;
		}
		
}
