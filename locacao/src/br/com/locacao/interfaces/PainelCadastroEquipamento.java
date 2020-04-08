package br.com.locacao.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import br.com.locacao.dao.EquipamentoDAO;
import br.com.locacao.modeloUsuario.Equipamento;

public class PainelCadastroEquipamento extends JPanel{
	private JLabel titulo;
	private JTextField line;
	private JLabel cod_equipamentotxt;
	private JLabel nometxt;
	private JLabel descricaotxt;
	private JTextField cod_equipamento;
	private JTextField nome;
	private JTextField descricao;
	private JButton cadastrar;
	private JButton imagem3;
	private JButton imagem4;
	private JButton imagem5;
	private JButton imagem6;
	private JButton imagem7;
	private JButton imagem8;
	ImageIcon img3 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img4 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img5 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img6 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img7 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img8 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	
	public PainelCadastroEquipamento(){
		setSize(700,500);
		setBackground(new Color(255,255,255));
		setVisible(true);
		inicializarComponentes();
		eventos();
		setLayout(null);
	}
	
	
	public void inicializarComponentes() {
		
		titulo = new JLabel("Cadastro");
		titulo.setFont(new Font("Arial", 4, 35));
		titulo.setForeground(new Color(16,78,139));
		
		imagem3 = new JButton(img3);
		imagem3.setBorderPainted(false);
		imagem3.setVisible(false);
		
		imagem4 = new JButton(img4);
		imagem4.setBorderPainted(false);
		imagem4.setVisible(false);
		
		imagem5 = new JButton(img5);
		imagem5.setBorderPainted(false);
		imagem5.setVisible(false);
		
		imagem6 = new JButton(img6);
		imagem6.setBorderPainted(false);
		imagem6.setVisible(false);
		
		imagem7 = new JButton(img7);
		imagem7.setBorderPainted(false);
		imagem7.setVisible(false);
		
		imagem8 = new JButton(img8);
		imagem8.setBorderPainted(false);
		imagem8.setVisible(false);
		
		line = new JTextField();
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		cod_equipamentotxt = new JLabel("Código :");
		cod_equipamentotxt.setFont(new Font("Arial", 4, 20));
		cod_equipamentotxt.setForeground(new Color(16,78,139));
		
		nometxt = new JLabel("Tipo :");
		nometxt.setFont(new Font("Arial", 4, 20));
		nometxt.setForeground(new Color(16,78,139));
		
		descricaotxt = new JLabel("Descricao :");
		descricaotxt.setFont(new Font("Arial", 4, 20));
		descricaotxt.setForeground(new Color(16,78,139));
		
		cod_equipamento = new JTextField();
		nome = new JTextField();
		descricao = new JTextField();
		
		cadastrar = new JButton();
		cadastrar.setFont(new Font("Arial", 5, 16));
		cadastrar.setForeground(new Color(70, 130, 180));
		cadastrar.setText(" CADASTRAR ");
		cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		cadastrar.setRequestFocusEnabled(false);
		cadastrar.setRolloverEnabled(false);
		cadastrar.setMargin(new Insets(2, 100, 2, 14));
		
		titulo.setBounds(250,-20,200,100);
		line.setBounds(190,55,300,2);
		cod_equipamentotxt.setBounds(162,-39,250,300);
		nometxt.setBounds(180, 43, 250, 250);
		descricaotxt.setBounds(129, 89, 250, 250);
		cod_equipamento.setBounds(250, 100, 250, 30);
		nome.setBounds(250, 150, 250, 30);
		descricao.setBounds(250, 200, 250, 30);
		cadastrar.setBounds(245, 260, 250, 40);
		imagem3.setBounds(510,100,26,24);
		imagem4.setBounds(510,100,26,24);
		imagem5.setBounds(510,150,26,24);
		imagem6.setBounds(510,150,26,24);
		imagem7.setBounds(510,200,26,24);
		imagem8.setBounds(510,200,26,24);
		
		
		
		add(titulo);
		add(line);
		add(imagem3);
		add(imagem4);
		add(imagem5);
		add(imagem6);
		add(imagem7);
		add(imagem8);
		add(cod_equipamentotxt);
		add(nometxt);
		add(descricaotxt);
		add(cod_equipamento);
		add(nome);
		add(descricao);
		add(cadastrar);
		
		
	}
	
	public void eventos(){
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Equipamento eq = new Equipamento();
				try{
				int a = Integer.parseInt(cod_equipamento.getText());
					eq.setCod_equipamentos(a);
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Somente números no campo código");
				}
				eq.setNome_equipamento(nome.getText());
				eq.setDescricao(descricao.getText());
				
				EquipamentoDAO dao = new EquipamentoDAO();
				dao.adicionaEquipamento(eq);
				
				cod_equipamento.setText("");
				nome.setText("");
				descricao.setText("");
				
				
			}
		});
		
		cod_equipamento.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(cod_equipamento.getText().isEmpty()){
					imagem4.setVisible(true);
				}
				
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
		
		cod_equipamento.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(cod_equipamento.getText().length() > 0){
					imagem4.setVisible(false);
					imagem3.setVisible(true);
				}else{
					imagem4.setVisible(true);
					imagem3.setVisible(false);
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		nome.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(nome.getText().isEmpty()){
					imagem6.setVisible(true);
				}
				
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
				// TODO Auto-generated method stub
				
			}
		});
		
		nome.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(nome.getText().length() > 0){
					imagem6.setVisible(false);
					imagem5.setVisible(true);
				}else{
					imagem6.setVisible(true);
					imagem5.setVisible(false);
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		descricao.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(descricao.getText().isEmpty()){
					imagem8.setVisible(true);
				}
				
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
				// TODO Auto-generated method stub
				
			}
		});
		
		descricao.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(descricao.getText().length() > 0){
					imagem8.setVisible(false);
					imagem7.setVisible(true);
				}else{
					imagem8.setVisible(true);
					imagem7.setVisible(false);
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
