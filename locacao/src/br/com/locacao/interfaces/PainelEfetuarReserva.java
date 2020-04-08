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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.locacao.dao.ReservaDAO;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Reserva;

public class PainelEfetuarReserva extends JPanel{
	
	private JLabel titulo;
	private JTextField line;
	private JLabel matriculatxt;
	private JLabel dataReservatxt;
	private JLabel horarioInicialtxt;
	private JLabel horarioFinaltxt;
	private JLabel disciplinatxt;
	private JLabel turmatxt;
	private JTextField matricula;
	private JTextField dataReserva;
	private JTextField horarioInicial;
	private JTextField horarioFinal;
	private JTextField disciplina;
	private JTextField turma;
	private JButton cadastrar;
	private JButton limpar;
	private JButton imagem3;
	private JButton imagem4;
	private JButton imagem5;
	private JButton imagem6;
	private JButton imagem7;
	private JButton imagem8;
	private JButton imagem9;
	private JButton imagem10;
	private JButton imagem11;
	private JButton imagem12;
	private JButton imagem13;
	private JButton imagem14;
	ImageIcon img3 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img4 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img5 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img6 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img7 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img8 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img9 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img10 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img11 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img12 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));
	ImageIcon img13 = new ImageIcon(getClass().getResource("/imagens/icon_acerto.png"));
	ImageIcon img14 = new ImageIcon(getClass().getResource("/imagens/icon_erro.png"));

	
	public PainelEfetuarReserva(){
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
		
		matriculatxt = new JLabel("Nº Matrícula :");
		matriculatxt.setFont(new Font("Arial", 4, 20));
		matriculatxt.setForeground(new Color(16,78,139));
		
		dataReservatxt = new JLabel("Data Reserva :");
		dataReservatxt.setFont(new Font("Arial", 4, 20));
		dataReservatxt.setForeground(new Color(16,78,139));
		
		horarioInicialtxt = new JLabel("Tempo Inicial :");
		horarioInicialtxt.setFont(new Font("Arial", 4, 20));
		horarioInicialtxt.setForeground(new Color(16,78,139));
		
		horarioFinaltxt = new JLabel("Tempo Final :");
		horarioFinaltxt.setFont(new Font("Arial", 4, 20));
		horarioFinaltxt.setForeground(new Color(16,78,139));
		
		disciplinatxt = new JLabel("Disciplina :");
		disciplinatxt.setFont(new Font("Arial", 4, 20));
		disciplinatxt.setForeground(new Color(16,78,139));
		
		turmatxt = new JLabel("Turma :");
		turmatxt.setFont(new Font("Arial", 4, 20));
		turmatxt.setForeground(new Color(16,78,139));
		
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
		
		imagem9 = new JButton(img9);
		imagem9.setBorderPainted(false);
		imagem9.setVisible(false);
		
		imagem10 = new JButton(img10);
		imagem10.setBorderPainted(false);
		imagem10.setVisible(false);
		
		imagem11 = new JButton(img11);
		imagem11.setBorderPainted(false);
		imagem11.setVisible(false);
		
		imagem12 = new JButton(img12);
		imagem12.setBorderPainted(false);
		imagem12.setVisible(false);
		
		imagem13 = new JButton(img13);
		imagem13.setBorderPainted(false);
		imagem13.setVisible(false);
		
		imagem14 = new JButton(img14);
		imagem14.setBorderPainted(false);
		imagem14.setVisible(false);
		
		matricula = new JTextField();
		dataReserva = new JTextField();
		horarioInicial = new JTextField();
		horarioFinal = new JTextField();
		disciplina = new JTextField();
		turma = new JTextField();
		
		cadastrar = new JButton();
		cadastrar.setFont(new Font("Arial", 5, 16));
		cadastrar.setForeground(new Color(70, 130, 180));
		cadastrar.setText(" SALVAR ");
		cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		cadastrar.setRequestFocusEnabled(false);
		cadastrar.setRolloverEnabled(false);
		cadastrar.setMargin(new Insets(2, 100, 2, 14));
		
		titulo.setBounds(250,-20,200,100);
		line.setBounds(190,55,300,2);
		matriculatxt.setBounds(110,-39,250,300);
		dataReservatxt.setBounds(112, 43, 250, 250);
		horarioInicialtxt.setBounds(112, 89, 250, 250);
		horarioFinaltxt.setBounds(112, 137, 250, 250);
		disciplinatxt.setBounds(120, 190, 250, 250);
		turmatxt.setBounds(130, 240, 250, 250);
		matricula.setBounds(250, 100, 250, 30);
		dataReserva.setBounds(250, 150, 250, 30);
		horarioInicial.setBounds(250, 200, 250, 30);
		horarioFinal.setBounds(250, 250, 250, 30);
		disciplina.setBounds(250, 300, 250, 30);
		turma.setBounds(250, 350, 250, 30);
		cadastrar.setBounds(242, 400, 250, 40);
		imagem3.setBounds(510,100,26,24);
		imagem4.setBounds(510,100,26,24);
		imagem5.setBounds(510,150,26,24);
		imagem6.setBounds(510,150,26,24);
		imagem7.setBounds(510,200,26,24);
		imagem8.setBounds(510,200,26,24);
		imagem9.setBounds(510,250,26,24);
		imagem10.setBounds(510,250,26,24);
		imagem11.setBounds(510,300,26,24);
		imagem12.setBounds(510,300,26,24);
		imagem13.setBounds(510,350,26,24);
		imagem14.setBounds(510,350,26,24);
		
		
		
		
		add(titulo);
		add(line);
		add(matriculatxt);
		add(dataReservatxt);
		add(horarioInicialtxt);
		add(horarioFinaltxt);
		add(disciplinatxt);
		add(turmatxt);
		add(matricula);
		add(dataReserva);
		add(horarioInicial);
		add(horarioFinal);
		add(disciplina);
		add(turma);
		add(cadastrar);
		add(imagem3);
		add(imagem4);
		add(imagem5);
		add(imagem6);
		add(imagem7);
		add(imagem8);
		add(imagem9);
		add(imagem10);
		add(imagem11);
		add(imagem12);
		add(imagem13);
		add(imagem14);
		
	}
	
	
	public void eventos(){
		cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Reserva rs = new Reserva();
				
				int a = Integer.parseInt(matricula.getText());
				rs.setNumMatricula(a);
				rs.setDataReserva(dataReserva.getText());
				rs.setTempoInicial(horarioInicial.getText());
				rs.setTempoFinal(horarioFinal.getText());
				rs.setDisciplina(disciplina.getText());
				rs.setTurma(turma.getText());
				
				
				
				List<Reserva> reservas = new ArrayList<Reserva>();
				Connection con = Conexao.getConexao();
				String sql = "SELECT * FROM reservas";
				PreparedStatement ps = null;
				try {
					ps = con.prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet result = null;
				try {
					result = ps.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Reserva rv = null;
				try {
					while(result.next()){
						rv = new Reserva();
						rv.setReserva((result.getInt("cod_reserva")));
						rv.setNumMatricula((result.getInt("num_matricula")));
						rv.setDataReserva((result.getString("data")));
						rv.setTempoInicial((result.getString("tempo_aula_inicial")));
						rv.setTempoFinal((result.getString("tempo_aula_final")));
						rv.setDisciplina((result.getString("disciplina")));
						rv.setTurma((result.getString("turma")));
						
						
						reservas.add(rv);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				ReservaDAO dao = new ReservaDAO();
				dao.adicionaReserva(rs);
				
				matricula.setText("");
				dataReserva.setText("");
				horarioInicial.setText("");
				horarioFinal.setText("");
				disciplina.setText("");
				turma.setText("");
			}
		});
		
		matricula.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(matricula.getText().isEmpty()){
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
				// TODO Auto-generated method stub
				
			}
		});
		
		matricula.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(matricula.getText().length() > 0){
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
		
		dataReserva.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(dataReserva.getText().isEmpty()){
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
		
		dataReserva.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(dataReserva.getText().length() > 0){
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
		
		horarioInicial.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(horarioInicial.getText().isEmpty()){
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
		
		horarioInicial.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(horarioInicial.getText().length() > 0){
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
		
		horarioFinal.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(horarioFinal.getText().isEmpty()){
					imagem10.setVisible(true);
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
		
		horarioFinal.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(horarioFinal.getText().length() > 0){
					imagem10.setVisible(false);
					imagem9.setVisible(true);
				}else{
					imagem10.setVisible(true);
					imagem9.setVisible(false);
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
		
		disciplina.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(disciplina.getText().isEmpty()){
					imagem12.setVisible(true);
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
		
		disciplina.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(disciplina.getText().length() > 0){
					imagem12.setVisible(false);
					imagem11.setVisible(true);
				}else{
					imagem12.setVisible(true);
					imagem11.setVisible(false);
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
		
		turma.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(turma.getText().isEmpty()){
					imagem14.setVisible(true);
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
		
		turma.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if(turma.getText().length() > 0){
					imagem14.setVisible(false);
					imagem13.setVisible(true);
				}else{
					imagem14.setVisible(true);
					imagem13.setVisible(false);
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
