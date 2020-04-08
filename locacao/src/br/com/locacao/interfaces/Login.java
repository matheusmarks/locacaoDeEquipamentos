package br.com.locacao.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.locacao.dao.EquipamentoDAO;
import br.com.locacao.dao.HorarioDAO;
import br.com.locacao.dao.UsuarioDAO;
import br.com.locacao.modeloUsuario.Equipamento;
import br.com.locacao.modeloUsuario.Horario;
import br.com.locacao.modeloUsuario.Usuario;

		
	//------------------------- IMPORTANTE !!! ----------------------------------
	/*Essa é a classe principal do projeto, que contém o JFrame e que possibilitará 
 	a troca de painéis. Sem essa classe a interface não poderá ser executada*/

public class Login extends JFrame {
	
	private JButton logar;
	private JTextField usuarios2;
	private JPasswordField senha;
	public static JButton editar1;
	public static JButton editar2;
	public static JButton editar_hr;
	private JButton usuario;
	private JButton reservas;
	private JButton horarios;
	private JButton equipamentos;
	private JButton cadastrar;
	private JButton cadastrar_eq; 
	private JButton cadastrar_hr;
	private JButton reservaUser;
	private JButton horarioUser;
	public static JButton efetuarReserva;
	private JButton imagem;
	private JButton imagem2;
	private JButton imagem3;
	private JButton imagem4;
	private JButton imagem5;
	private JButton imagem6;
	private JButton imagem7;
	private JButton imagem8;
	private JButton imagem9;
	private JButton imagem10;
	private JButton imagem11;
	Painel p = new Painel();
	PainelAreaDeTrabalho p3 = new PainelAreaDeTrabalho();
	PainelAreaDeTrabalho p8 = new PainelAreaDeTrabalho();
	PainelAreaDeTrabalhoUser p4 = new PainelAreaDeTrabalhoUser();
	PainelUsuarios p5 = new PainelUsuarios();
	PainelCadastro p6 = new PainelCadastro();
	PainelEquipamentos p7 = new PainelEquipamentos();
	PainelEditarUsuario p9 = new PainelEditarUsuario();
	PainelCadastroEquipamento  p10 = new PainelCadastroEquipamento();
	PainelHorarios p11 = new  PainelHorarios();
	PainelCadastarHorario p12 = new PainelCadastarHorario();
	PainelReserva p13 = new PainelReserva();
	PainelEfetuarReserva p14 = new PainelEfetuarReserva();
	HorarioUser p15 = new HorarioUser();
	ReservaUser p16 = new ReservaUser();
	
	ImageIcon img = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img2 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img3 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img4 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img5 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img6 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img7 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img8 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img9 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img10 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	ImageIcon img11 = new ImageIcon(getClass().getResource("/imagens/voltar2.jpg"));
	
	public Login() {
		setSize(700,500);
		setTitle("Safety - Locação de Equipamentos");
		setLayout(null);
		inicializarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);
		eventos();
		setVisible(true);
		
	}

	private void inicializarComponentes() {
		
		usuarios2 = new JTextField();
		senha = new JPasswordField();
		logar = new JButton("LOGIN");
				
		imagem = new JButton(img);
		imagem.setBorderPainted(false);
		imagem.setVisible(false);
		
		imagem2 = new JButton(img2);
		imagem2.setBorderPainted(false);
		imagem2.setVisible(false);
		
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
		
		cadastrar_eq = new JButton("CADASTRAR");
		cadastrar_eq.setFont(new Font("Arial", 5, 16));
		cadastrar_eq.setForeground(new Color(70, 130, 180));
		cadastrar_eq.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		cadastrar_eq.setRequestFocusEnabled(false);
		cadastrar_eq.setRolloverEnabled(false);
		cadastrar_eq.setMargin(new Insets(2, 100, 2, 14));
		cadastrar_eq.setVisible(false);
		
		cadastrar_hr = new JButton("CADASTRAR");
		cadastrar_hr.setFont(new Font("Arial", 5, 16));
		cadastrar_hr.setForeground(new Color(70, 130, 180));
		cadastrar_hr.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		cadastrar_hr.setRequestFocusEnabled(false);
		cadastrar_hr.setRolloverEnabled(false);
		cadastrar_hr.setMargin(new Insets(2, 100, 2, 14));
		cadastrar_hr.setVisible(false);
		
		efetuarReserva = new JButton("EFETUAR RESERVA");
		efetuarReserva.setFont(new Font("Arial", 5, 16));
		efetuarReserva.setForeground(new Color(70, 130, 180));
		efetuarReserva.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		efetuarReserva.setRequestFocusEnabled(false);
		efetuarReserva.setRolloverEnabled(false);
		efetuarReserva.setMargin(new Insets(2, 100, 2, 14));
		efetuarReserva.setVisible(false);
		efetuarReserva.setEnabled(false);
		
		
		usuario = new JButton();
		usuario = new JButton("USUÁRIOS");
		usuario.setFont(new Font("Arial", 5, 16));
		usuario.setForeground(new Color(70, 130, 180));
		usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		usuario.setRequestFocusEnabled(false);
		usuario.setRolloverEnabled(false);
		usuario.setMargin(new Insets(2, 100, 2, 14));
		usuario.setVisible(false);
		
		reservaUser = new JButton();
		reservaUser = new JButton("RESERVA");
		reservaUser.setFont(new Font("Arial", 5, 16));
		reservaUser.setForeground(new Color(70, 130, 180));
		reservaUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		reservaUser.setRequestFocusEnabled(false);
		reservaUser.setRolloverEnabled(false);
		reservaUser.setMargin(new Insets(2, 100, 2, 14));
		reservaUser.setVisible(false);
		
		horarioUser = new JButton();
		horarioUser = new JButton("HORÁRIOS");
		horarioUser.setFont(new Font("Arial", 5, 16));
		horarioUser.setForeground(new Color(70, 130, 180));
		horarioUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		horarioUser.setRequestFocusEnabled(false);
		horarioUser.setRolloverEnabled(false);
		horarioUser.setMargin(new Insets(2, 100, 2, 14));
		horarioUser.setVisible(false);
		
		usuarios2 = new JTextField();
		senha = new JPasswordField();
		
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);
		p7.setVisible(false);
		p8.setVisible(false);
		p9.setVisible(false);
		p10.setVisible(false);
		p11.setVisible(false);
		p12.setVisible(false);
		p13.setVisible(false);
		p14.setVisible(false);
		p15.setVisible(false);
		p16.setVisible(false);
		
		logar.setFont(new Font("Arial", 5, 16));
	    logar.setForeground(new Color(70, 130, 180));
	    logar.setText(" ENTRAR ");
	    logar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
	    logar.setRequestFocusEnabled(false);
	    logar.setRolloverEnabled(false);
	    logar.setMargin(new Insets(2, 100, 2, 14));
	    
	    equipamentos = new JButton("EQUIPAMENTOS");
		equipamentos.setFont(new Font("Arial", 5, 16));
		equipamentos.setForeground(new Color(70, 130, 180));
		equipamentos.setText(" EQUIPAMENTOS ");
		equipamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		equipamentos.setRequestFocusEnabled(false);
		equipamentos.setRolloverEnabled(false);
		equipamentos.setMargin(new Insets(2, 100, 2, 14));
		equipamentos.setVisible(false);
		
		reservas = new JButton("RESERVAS");
		reservas.setFont(new Font("Arial", 5, 16));
		reservas.setForeground(new Color(70, 130, 180));
		reservas.setText(" RESERVAS ");
		reservas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		reservas.setRequestFocusEnabled(false);
		reservas.setRolloverEnabled(false);
		reservas.setMargin(new Insets(2, 100, 2, 14));
		reservas.setVisible(false);
		
		editar1 = new JButton();
		editar1.setText("EDITAR");
		editar1.setEnabled(false);
		editar1.setFont(new Font("Arial", 5, 16));
		editar1.setForeground(new Color(70, 130, 180));
		editar1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		editar1.setRequestFocusEnabled(false);
		editar1.setRolloverEnabled(false);
		editar1.setMargin(new Insets(2, 100, 2, 14));
		editar1.setVisible(false);
		
		editar2 = new JButton();
		editar2.setText("EDITAR");
		editar2.setEnabled(false);
		editar2.setFont(new Font("Arial", 5, 16));
		editar2.setForeground(new Color(70, 130, 180));
		editar2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		editar2.setRequestFocusEnabled(false);
		editar2.setRolloverEnabled(false);
		editar2.setMargin(new Insets(2, 100, 2, 14));
		editar2.setVisible(false);
		
		editar_hr = new JButton();
		editar_hr.setText("EDITAR");
		editar_hr.setEnabled(false);
		editar_hr.setFont(new Font("Arial", 5, 16));
		editar_hr.setForeground(new Color(70, 130, 180));
		editar_hr.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		editar_hr.setRequestFocusEnabled(false);
		editar_hr.setRolloverEnabled(false);
		editar_hr.setMargin(new Insets(2, 100, 2, 14));
		editar_hr.setVisible(false);
		editar_hr.setEnabled(false);
		
		
		
		horarios = new JButton("HORÁRIOS");
		horarios.setFont(new Font("Arial", 5, 16));
		horarios.setForeground(new Color(70, 130, 180));
		horarios.setText(" HORÁRIOS ");
		horarios.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		horarios.setRequestFocusEnabled(false);
		horarios.setRolloverEnabled(false);
		horarios.setMargin(new Insets(2, 100, 2, 14));
		horarios.setVisible(false);
		
		cadastrar = new JButton("CADASTRAR");
		cadastrar.setFont(new Font("Arial", 5, 16));
		cadastrar.setForeground(new Color(70, 130, 180));
		cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		cadastrar.setRequestFocusEnabled(false);
		cadastrar.setRolloverEnabled(false);
		cadastrar.setMargin(new Insets(2, 100, 2, 14));
		cadastrar.setVisible(false);
		senha.setMargin(new Insets(2, 5, 2, 14));
		usuarios2.setMargin(new Insets(2, 5, 2, 14));
		
		//Posicionando os elementos na tela
	    p.setBounds(0, 0, 700, 500);
	    p3.setBounds(0,0,700,500);
	    p4.setBounds(0,0,700,500);
	    imagem3.setBounds(1,1,70,60);
	    imagem2.setBounds(1,1,70,60);
	    imagem.setBounds(1,1,70,60);
	    imagem4.setBounds(1,1,70,60);
	    imagem5.setBounds(1,1,70,60);
	    imagem6.setBounds(1,1,70,60);
	    imagem7.setBounds(1,1,70,60);
	    imagem8.setBounds(1,1,70,60);
	    imagem9.setBounds(1,1,70,60);
	    imagem10.setBounds(1,1,70,60);
	    imagem11.setBounds(1,1,70,60);
	    usuario.setBounds(120, 385, 150, 50);
		logar.setBounds(300,300, 280, 40);
		usuarios2.setBounds(300, 140, 280, 30);
		senha.setBounds(300,230, 280, 30);
		editar1.setBounds(264,415,140,40);
		editar2.setBounds(264,415,140,40);
		editar_hr.setBounds(264,415,140,40);
		p5.setBounds(0,0,700,500);
		p6.setBounds(0,0,700,500);
		equipamentos.setBounds(115, 200, 150, 50);
		horarios.setBounds(400, 385, 150, 50);
		reservas.setBounds(400, 200, 150, 50);
		cadastrar.setBounds(95,415,140,40);
		cadastrar_eq.setBounds(95,415,140,40);
		cadastrar_hr.setBounds(95,415,140,40);
		efetuarReserva.setBounds(95,415,200,40);
		reservaUser.setBounds(89, 280, 150, 50);
		horarioUser.setBounds(400, 280, 150, 50);
		p7.setBounds(0,0,700,500);
		p8.setBounds(0,0,700,500);
		p9.setBounds(0,0,700,500);
		p10.setBounds(0,0,700,500);
		p11.setBounds(0,0,700,500);
		p12.setBounds(0,0,700,500);
		p13.setBounds(0,0,700,500);
		p14.setBounds(0,0,700,500);
		p15.setBounds(0,0,700,500);
		p16.setBounds(0,0,700,500);
		
		//Adicicinando os elementos na tela
		add(usuario);
		add(equipamentos);
		add(horarios);
		add(reservas);
		add(cadastrar);
		add(cadastrar_eq);
		add(cadastrar_hr);
		add(efetuarReserva);
		add(horarioUser);
		add(reservaUser);
		add(editar1);
		add(editar2);
		add(editar_hr);
		add(imagem11);
		add(imagem10);
		add(imagem9);
		add(imagem8);
		add(imagem7);
		add(imagem6);
		add(imagem5);
		add(imagem4);
		add(imagem3);
		add(imagem2);
		add(imagem);
		add(logar);
		add(p);
		add(p3);
		add(p4);
		add(usuarios2);
		add(senha);
		add(p5);
		add(p6);
		add(p7);
		add(p9);
		add(p10);
		add(p11);
		add(p12);
		add(p13);
		add(p14);
		add(p15);
		add(p16);
	}
	
	//Método de eventos
	public void eventos(){
		
		
		logar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<Usuario> usuarios = null;
				try {
					usuarios = UsuarioDAO.getUsuario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
					UsuarioDAO dao = new UsuarioDAO();
					for(Usuario user : usuarios){
						
						if(usuarios2.getText().equals(user.getLogin()) && dao.criptografiaDeSenha(senha.getText()).equals(user.getSenha())){
							System.out.println("Usuario:" + user.getAdmin());
								if(user.getAdmin() == 's'){
								p3.setVisible(true);
								usuario.setVisible(true);
								equipamentos.setVisible(true);
								reservas.setVisible(true);
								horarios.setVisible(true);
								p.setVisible(false);
								logar.setVisible(false);
								usuarios2.setVisible(false);
								senha.setVisible(false);
							}else{
								p4.setVisible(true);
								p.setVisible(false);
								logar.setVisible(false);
								usuarios2.setVisible(false);
								senha.setVisible(false);
								horarioUser.setVisible(true);
								reservaUser.setVisible(true);
							}
						}
					}
			}
		});
		
		usuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p3.isVisible()){
					p3.setVisible(false);
					p5.setVisible(true);
					usuario.setVisible(false);
					imagem.setVisible(true);
					cadastrar.setVisible(true);
					usuario.setVisible(false);
					equipamentos.setVisible(false);
					reservas.setVisible(false);
					horarios.setVisible(false);
					editar1.setVisible(true);
				}
				
			}
		});
		
		cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p5.isVisible()){
					p5.setVisible(false);
					p6.setVisible(true);
					cadastrar.setVisible(false);
					imagem2.setVisible(true);
					imagem.setVisible(false);
					editar1.setVisible(false);
				}
				
			}
		});
		
		
		
		imagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p5.isVisible()){
					p5.setVisible(false);
					p3.setVisible(true);
					usuario.setVisible(true);
					equipamentos.setVisible(true);
					reservas.setVisible(true);
					horarios.setVisible(true);
					imagem.setVisible(false);
					cadastrar.setVisible(false);
					editar1.setVisible(false);
				}
				
			}
		});
		
		imagem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p6.isVisible()){
					p6.setVisible(false);
					p5.setVisible(true);
					imagem2.setVisible(false);
					cadastrar.setVisible(true);
					imagem.setVisible(true);
					editar1.setVisible(true);
				}
				
			}
		});
		
		
		equipamentos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p3.isVisible()){
					p3.setVisible(false);
					p7.setVisible(true);
					usuario.setVisible(false);
					equipamentos.setVisible(false);
					reservas.setVisible(false);
					horarios.setVisible(false);
					imagem3.setVisible(true);
					cadastrar_eq.setVisible(true);
					editar2.setVisible(true);
				
				}
			}
		});
		
		horarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p3.isVisible()){
					p3.setVisible(false);
					p11.setVisible(true);
					usuario.setVisible(false);
					equipamentos.setVisible(false);
					reservas.setVisible(false);
					horarios.setVisible(false);
					cadastrar_hr.setVisible(true);
					editar_hr.setVisible(true);
					imagem6.setVisible(true);
				}
				
			}
		});
		
		reservas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p3.isVisible()){
					p3.setVisible(false);
					p13.setVisible(true);
					usuario.setVisible(false);
					equipamentos.setVisible(false);
					reservas.setVisible(false);
					horarios.setVisible(false);
					efetuarReserva.setVisible(true);
					imagem8.setVisible(true);
				}
				
			}
		});
		
		efetuarReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p13.isVisible()){
					p13.setVisible(false);
					p14.setVisible(true);
					efetuarReserva.setVisible(false);
					imagem9.setVisible(true);
				}
				
			}
		});
		
		
		editar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Usuario user = PainelUsuarios.linhaSelecionada();
					UsuarioDAO dao = new UsuarioDAO();

					try {
						dao.alteraUsuario(user);
						JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
					} catch (SQLException b) {
						b.printStackTrace();
					}
					
			}
		});
		
		editar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipamento eq = PainelEquipamentos.linhaSelecionada();
				EquipamentoDAO dao = new EquipamentoDAO();

				try {
					dao.alteraEquipamentos(eq);
					JOptionPane.showMessageDialog(null, "Equipamento alterado com sucesso!");
				} catch (SQLException b) {
					b.printStackTrace();
				}
				
				
			}
		});
		
		editar_hr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Horario hr = PainelHorarios.linhaSelecionada();
				HorarioDAO dao = new HorarioDAO();

				try {
					dao.alteraHorario(hr);
					JOptionPane.showMessageDialog(null, "Horário alterado com sucesso!");
				} catch (SQLException b) {
					b.printStackTrace();
				}
				
				
			}
		});
		
	
		
		imagem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p7.isVisible()){
					p3.setVisible(true);
					usuario.setVisible(true);
					equipamentos.setVisible(true);
					reservas.setVisible(true);
					horarios.setVisible(true);
					p7.setVisible(false);
					imagem3.setVisible(false);
					cadastrar_eq.setVisible(false);
					editar2.setVisible(false);
				}
			}
		});
		
		imagem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p10.isVisible()){
					p10.setVisible(false);
					p7.setVisible(true);
					imagem4.setVisible(false);
					cadastrar_eq.setVisible(true);
					editar2.setEnabled(false);
					editar2.setVisible(true);
				}
			}
		});
		
		imagem5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p9.isVisible()){
					p9.setVisible(false);
					p5.setVisible(true);
					editar1.setVisible(true);
					cadastrar.setVisible(true);
					imagem5.setVisible(false);
					
				}
				
			}
		});
		
		imagem6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p11.isVisible()){
					p11.setVisible(false);
					p3.setVisible(true);
					usuario.setVisible(true);
					equipamentos.setVisible(true);
					reservas.setVisible(true);
					horarios.setVisible(true);
					cadastrar_hr.setVisible(false);
					editar_hr.setVisible(false);
					imagem6.setVisible(false);
					
				}
				
			}
		});
		
		imagem7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p12.isVisible()){
					p12.setVisible(false);
					p11.setVisible(true);
					cadastrar_hr.setVisible(true);
					editar_hr.setVisible(true);
					imagem7.setVisible(false);
					
				}
				
			}
		});
		
		imagem8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p13.isVisible()){
					p13.setVisible(false);
					p3.setVisible(true);
					usuario.setVisible(true);
					equipamentos.setVisible(true);
					reservas.setVisible(true);
					horarios.setVisible(true);
					efetuarReserva.setVisible(false);
					imagem8.setVisible(false);
					
				}
				
			}
		});
		
		imagem9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p14.isVisible()){
					p14.setVisible(false);
					p13.setVisible(true);
					imagem9.setVisible(false);
					efetuarReserva.setVisible(true);
					
				}
				
			}
		});
		
		imagem10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p15.isVisible()){
					p15.setVisible(false);
					p4.setVisible(true);
					imagem9.setVisible(false);
					imagem10.setVisible(false);
					horarioUser.setVisible(true);
					reservaUser.setVisible(true);
					
				}
				
			}
		});
		
		imagem11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p16.isVisible()){
					p16.setVisible(false);
					p4.setVisible(true);
					horarioUser.setVisible(true);
					reservaUser.setVisible(true);
					imagem11.setVisible(false);
					
				}
				
			}
		});
		
		cadastrar_eq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p7.isVisible()){
					p7.setVisible(false);
					p10.setVisible(true);
					cadastrar_eq.setVisible(false);
					imagem4.setVisible(true);
					editar2.setVisible(false);
				}
				
			}
		});
		
		cadastrar_hr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p11.isVisible()){
					p11.setVisible(false);
					p12.setVisible(true);
					cadastrar_hr.setVisible(false);
					editar_hr.setVisible(false);
					imagem7.setVisible(true);
				}
				
			}
		});
		
		horarioUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p4.isVisible()){
					p4.setVisible(false);
					p15.setVisible(true);
					cadastrar_hr.setVisible(false);
					editar_hr.setVisible(false);
					horarioUser.setVisible(false);
					reservaUser.setVisible(false);
					imagem10.setVisible(true);
				}
				
			}
		});
		
		reservaUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(p4.isVisible()){
					p4.setVisible(false);
					p16.setVisible(true);
					horarioUser.setVisible(false);
					reservaUser.setVisible(false);
					imagem11.setVisible(true);
				}
				
			}
		});
}
	public static void main(String[] args) throws Exception{
		   new Login();
		   
	}
	
}
