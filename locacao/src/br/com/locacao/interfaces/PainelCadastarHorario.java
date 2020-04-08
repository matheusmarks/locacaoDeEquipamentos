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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.locacao.dao.HorarioDAO;
import br.com.locacao.modeloUsuario.Horario;

public class PainelCadastarHorario extends JPanel{
	private JLabel titulo;
	private JTextField line;
	private JLabel diaDaSemanatxt;
	private JLabel tempoInicialtxt;
	private JTextField diaDaSemana;
	private JTextField tempoInicial;
	private JButton cadastrar;
	private JButton imagem5;
	private JButton imagem6;
	private JButton imagem7;
	private JButton imagem8;
	ImageIcon img5 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img6 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img7 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img8 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	
	public PainelCadastarHorario(){
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
		
		line = new JTextField();
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		diaDaSemanatxt = new JLabel("Dia da Semana :");
		diaDaSemanatxt.setFont(new Font("Arial", 4, 20));
		diaDaSemanatxt.setForeground(new Color(16,78,139));
		
		tempoInicialtxt = new JLabel("Aula :");
		tempoInicialtxt.setFont(new Font("Arial", 4, 20));
		tempoInicialtxt.setForeground(new Color(16,78,139));
		
		
		diaDaSemana = new JTextField();
		tempoInicial = new JTextField();
		
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
		diaDaSemanatxt.setBounds(90,-39,250,300);
		tempoInicialtxt.setBounds(112, 43, 250, 250);
		diaDaSemana.setBounds(250, 100, 250, 30);
		tempoInicial.setBounds(250, 150, 250, 30);
		cadastrar.setBounds(238, 260, 250, 40);
		imagem7.setBounds(510,100,26,24);
		imagem8.setBounds(510,100,26,24);
		imagem5.setBounds(510,150,26,24);
		imagem6.setBounds(510,150,26,24);
		
		
		
		add(titulo);
		add(line);
		add(diaDaSemanatxt);
		add(tempoInicialtxt);
		add(diaDaSemana);
		add(tempoInicial);
		add(cadastrar);
		add(imagem6);
		add(imagem5);
		add(imagem7);
		add(imagem8);
		
		
	}
	
	public void eventos(){
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Horario hr = new Horario();
				
				hr.setDiaDaSemana(diaDaSemana.getText());
				hr.setTempo(tempoInicial.getText());
				
				HorarioDAO dao = new HorarioDAO();
				dao.adicionaHorario(hr);
				
				diaDaSemana.setText("");
				tempoInicial.setText("");
				
			}
		});
		
		diaDaSemana.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(diaDaSemana.getText().isEmpty()){
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
		
		diaDaSemana.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(diaDaSemana.getText().length() > 0){
					imagem8.setVisible(false);
					imagem7.setVisible(true);
				}else{
					imagem8.setVisible(true);
					imagem7.setVisible(false);
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
		
		tempoInicial.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(tempoInicial.getText().isEmpty()){
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
		
		tempoInicial.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(tempoInicial.getText().length() > 0){
					imagem6.setVisible(false);
					imagem5.setVisible(true);
				}else{
					imagem6.setVisible(true);
					imagem5.setVisible(false);
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
	}
}
