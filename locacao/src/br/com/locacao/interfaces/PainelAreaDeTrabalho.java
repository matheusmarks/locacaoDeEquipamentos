package br.com.locacao.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PainelAreaDeTrabalho extends JPanel{
	private JLabel titulo;
	private JTextField line;
	ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/iconeeq.png"));
	private JLabel lblImagem;
	ImageIcon imagem2 = new ImageIcon(getClass().getResource("/imagens/reserva.png"));
	private JLabel lblImagem2;
	//private JButton reservas;
	ImageIcon imagem3 = new ImageIcon(getClass().getResource("/imagens/user.png"));
	private JLabel lblImagem3;
	//private JButton usuario;
	//private JButton horarios;
	//private JButton equipamentos;
	ImageIcon imagem4 = new ImageIcon(getClass().getResource("/imagens/horario.png"));
	private JLabel lblImagem4;
	
	
	PainelCadastro p3 = new PainelCadastro();
	
	public PainelAreaDeTrabalho() {
		setSize(700,500);
		setBackground(new Color(255,255,255));
		inicializarComponentes();
		setLayout(null);
		
	}
	
	public void inicializarComponentes() {
		titulo = new JLabel("�rea de Trabalho");
		titulo.setFont(new Font("Arial", 15, 30));
		titulo.setForeground(new Color(16,78,139)); 
		
		line = new JTextField ();
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		lblImagem = new JLabel(imagem);
		lblImagem2 = new JLabel(imagem2);
		lblImagem3 = new JLabel(imagem3);
		lblImagem4 = new JLabel(imagem4);
		
		
		
		/*equipamentos = new JButton("EQUIPAMENTOS");
		equipamentos.setFont(new Font("Arial", 5, 16));
		equipamentos.setForeground(new Color(70, 130, 180));
		equipamentos.setText(" EQUIPAMENTOS ");
		equipamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		equipamentos.setRequestFocusEnabled(false);
		equipamentos.setRolloverEnabled(false);
		equipamentos.setMargin(new Insets(2, 100, 2, 14));
		
		reservas = new JButton("RESERVAS");
		reservas.setFont(new Font("Arial", 5, 16));
		reservas.setForeground(new Color(70, 130, 180));
		reservas.setText(" RESERVAS ");
		reservas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		reservas.setRequestFocusEnabled(false);
		reservas.setRolloverEnabled(false);
		reservas.setMargin(new Insets(2, 100, 2, 14));*/
		
		/*usuario = new JButton("USU�RIOS");
		usuario.setFont(new Font("Arial", 5, 16));
		usuario.setForeground(new Color(70, 130, 180));
		usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		usuario.setRequestFocusEnabled(false);
		usuario.setRolloverEnabled(false);
		usuario.setMargin(new Insets(2, 100, 2, 14));*/
		
		/*horarios = new JButton("HOR�RIOS");
		horarios.setFont(new Font("Arial", 5, 16));
		horarios.setForeground(new Color(70, 130, 180));
		horarios.setText(" HOR�RIOS ");
		horarios.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		horarios.setRequestFocusEnabled(false);
		horarios.setRolloverEnabled(false);
		horarios.setMargin(new Insets(2, 100, 2, 14));*/
		
		
		titulo.setBounds(220, -75, 300, 215);
		line.setBounds(160,55,340, 1);
		lblImagem.setBounds(100, 70, 190, 120);
		//equipamentos.setBounds(115, 200, 150, 50);
		//horarios.setBounds(400, 385, 150, 50);
		//reservas.setBounds(400, 200, 150, 50);
		lblImagem2.setBounds(410, 70, 120, 120);
		
		lblImagem3.setBounds(135, 260, 120, 120);
		//usuario.setBounds(120, 385, 150, 50);
		lblImagem4.setBounds(400, 245, 150, 150);
		
		
		
		
		add(titulo);
		add(line);
		add(lblImagem);
		//add(equipamentos);
		add(lblImagem2);
		//add(reservas);
		add(lblImagem3);
		//add(usuario);
		add(lblImagem4);
		//add(horarios);
		
		
	}
	
	
	
	
}
