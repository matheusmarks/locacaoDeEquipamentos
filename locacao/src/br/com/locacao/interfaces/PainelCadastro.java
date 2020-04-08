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
import java.awt.event.MouseMotionListener;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import br.com.locacao.dao.UsuarioDAO;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Usuario;

public class PainelCadastro extends JPanel {
	
	private JLabel titulo;
	private JLabel matricula;
	private JTextField matriculatxt;
	private JTextField nometxt;
	private JTextField emailtxt;
	private JTextField logintxt;
	private JPasswordField senhatxt;
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
	private JLabel msg;
	private JButton limpar;
	private JLabel nome2;
	private JLabel email;
	private JLabel login2;
	private JLabel senha;
	private JButton cadastrar;
	PainelAreaDeTrabalhoUser usr2 = new PainelAreaDeTrabalhoUser();
	ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/iconec.png"));
	ImageIcon imagem2 = new ImageIcon(getClass().getResource("/imagens/1.png"));
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
	
	private JLabel img;
	public PainelCadastro(){
		setSize(700,500);
		setBackground(new Color(255,255,255));
		setVisible(true);
		inicializarComponentes();
		eventos();
		setLayout(null);
	}
	
	
	public void inicializarComponentes() {
		
		img = new JLabel(imagem);
		titulo = new JLabel("Cadastro");
		titulo.setFont(new Font("Arial", 4, 35));
		titulo.setForeground(new Color(16,78,139)); 
		
		usr2.setVisible(false);
		nome2 = new JLabel("Nome :");
		nome2.setFont(new Font("Arial", 4, 20));
		nome2.setForeground(new Color(16,78,139)); 
		
		msg = new JLabel("Preencha este campo");
		msg.setVisible(false);
		
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
		
		imagem12 = new JButton(img6);
		imagem12.setBorderPainted(false);
		imagem12.setVisible(false);
		
		nometxt = new JTextField();
		senhatxt = new JPasswordField();
		emailtxt = new JTextField();
		logintxt = new JTextField();
		matriculatxt = new JTextField();
		limpar = new JButton("LIMPAR");
		
		email = new JLabel("Email :");
		email.setFont(new Font("Arial", 4, 20));
		email.setForeground(new Color(16,78,139)); 
		
	
		login2 = new JLabel("Login :");
		login2.setFont(new Font("Arial", 4, 20));
		login2.setForeground(new Color(16,78,139)); 
		
		
		senha = new JLabel("Senha :");
		senha.setFont(new Font("Arial", 4, 20));
		senha.setForeground(new Color(16,78,139)); 
		
		
		matricula = new JLabel("N� Matr�cula :");
		matricula.setFont(new Font("Arial", 4, 20));
		matricula.setForeground(new Color(16,78,139)); 
		
		
		cadastrar = new JButton("CADASTRAR");
		
		
		cadastrar.setFont(new Font("Arial", 5, 16));
		cadastrar.setForeground(new Color(70, 130, 180));
		cadastrar.setText(" CADASTRAR ");
		cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		cadastrar.setRequestFocusEnabled(false);
		cadastrar.setRolloverEnabled(false);
		cadastrar.setMargin(new Insets(2, 100, 2, 14));
		
		limpar.setFont(new Font("Arial", 5, 16));
		limpar.setForeground(new Color(70, 130, 180));
		limpar.setText(" LIMPAR ");
		limpar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		limpar.setRequestFocusEnabled(false);
		limpar.setRolloverEnabled(false);
		
	    
		img.setBounds(160, -75, 250, 250);
		titulo.setBounds(330, -75, 250, 250);
		nome2.setBounds(178, 40, 250, 250);
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
		nometxt.setBounds(250, 150, 250, 30);
		emailtxt.setBounds(250, 200, 250, 30);
		logintxt.setBounds(250, 250, 250, 30);
		senhatxt.setBounds(250, 300, 250, 30);
		limpar.setBounds(360, 360, 140, 40);
		matriculatxt.setBounds(250, 100, 250, 30);
		email.setBounds(183, 88, 250, 250);
		login2.setBounds(183, 138, 250, 250);
		senha.setBounds(177, 190, 250, 250);
		cadastrar.setBounds(180, 360, 140, 40);
		matricula.setBounds(120, -10, 250,250);
		usr2.setBounds(0,0,700,500);
		

		add(img);
		add(titulo);
		add(nome2);
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
		add(nometxt);
		add(emailtxt);
		add(logintxt);
		add(senhatxt);
		add(limpar);
		add(matriculatxt);
		add(email);
		add(login2);
		add(senha);
		add(cadastrar);
		add(matricula);
		add(usr2);
		
		
	}
	
	public void eventos(){
		
		
			
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				matriculatxt.setText("");
				nometxt.setText("");
				emailtxt.setText("");
				logintxt.setText("");
				senhatxt.setText("");
			}
		});
		
		
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Usuario usr = new Usuario();
				int num = Integer.parseInt(matriculatxt.getText());
				usr.setNum_matricula(num);
				usr.setNome(nometxt.getText());
				usr.setEmail(emailtxt.getText());
				usr.setLogin(logintxt.getText());
				usr.setSenha(senhatxt.getText());
				usr.setAdmin('n');
				
				 imagem3.setVisible(false);
				 imagem4.setVisible(false);
				 imagem5.setVisible(false);
				 imagem6.setVisible(false);
				 imagem7.setVisible(false);
				 imagem8.setVisible(false);
				 imagem9.setVisible(false);
				 imagem10.setVisible(false);
				 imagem11.setVisible(false);
				 imagem12.setVisible(false);
				 
				 
				 boolean isEmailIdValid = false;
					String a = emailtxt.getText();
					
			
					
					
			if(!matriculatxt.getText().isEmpty() || nometxt.getText().isEmpty() 
			|| emailtxt.getText().isEmpty() || logintxt.getText().isEmpty() ||
			senhatxt.getText().isEmpty()){
				
				//Estrutura que valida o email
				if (a != null && a.length() > 0) {
					String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		            Matcher matcher = pattern.matcher(a);
		            
		            /*Se o email for v�lido ele exibe a mensagem e insere no banco,
		            entretanto se o emial n�o for v�lido ele exibe a mensagem e n�o 
		            insere no banco*/
		            
		            if (matcher.matches()) {
		                isEmailIdValid = true;
		                UsuarioDAO user_dao = new UsuarioDAO(); 
		                matriculatxt.setText("");
						nometxt.setText("");
						emailtxt.setText("");
						logintxt.setText("");
						senhatxt.setText("");
						user_dao.adicionaUsuario(usr);
		            }else{
		            	JOptionPane.showMessageDialog(null, "Email inv�lido");
		            }
				}
			}else{
				JOptionPane.showMessageDialog(null, "Todos os campos obrigat�rios devem ser preenchidos");
			}
				imagem4.setVisible(false);
		};
	});
		
		matriculatxt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(matriculatxt.getText().isEmpty()){
					imagem4.setVisible(true);
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		
		nometxt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(nometxt.getText().isEmpty()){
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
		
		emailtxt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(emailtxt.getText().isEmpty()){
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
		
		logintxt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(logintxt.getText().isEmpty()){
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
		
		senhatxt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(senhatxt.getText().isEmpty()){
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
		
	
		
		matriculatxt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(matriculatxt.getText().length() > 0){
					imagem4.setVisible(false);
					imagem3.setVisible(true);
				}else{
					imagem4.setVisible(true);
					imagem3.setVisible(false);
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
		
		nometxt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(nometxt.getText().length() > 0){
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
		
		
		
		emailtxt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(emailtxt.getText().length() > 0){
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
		
		logintxt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(logintxt.getText().length() > 0){
					imagem10.setVisible(false);
					imagem9.setVisible(true);
				}else{
					imagem10.setVisible(true);
					imagem9.setVisible(false);
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
		
		senhatxt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(senhatxt.getText().length() > 0){
					imagem12.setVisible(false);
					imagem11.setVisible(true);
				}else{
					imagem12.setVisible(true);
					imagem11.setVisible(false);
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
