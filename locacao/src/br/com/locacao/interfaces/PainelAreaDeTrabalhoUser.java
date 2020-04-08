package br.com.locacao.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PainelAreaDeTrabalhoUser extends JPanel {
	private JLabel titulo;
	private JTextField line;
	
	ImageIcon imagem2 = new ImageIcon(getClass().getResource("/imagens/teluser2.png"));
	private JLabel lblImagem2;
	private JButton reservas;
	
	ImageIcon imagem4 = new ImageIcon(getClass().getResource("/imagens/teluser1.png"));
	private JLabel lblImagem4;
	private JButton horarios;
	
	public PainelAreaDeTrabalhoUser() {
		setSize(700,500);
		setBackground(new Color(255,255,255));
		inicializarComponentes();
		setLayout(null);
		
	}
	
	public void inicializarComponentes() {
		titulo = new JLabel("Área de Trabalho");
		titulo.setFont(new Font("Arial", 15, 30));
		titulo.setForeground(new Color(16,78,139)); 
		
		line = new JTextField ();
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		lblImagem2 = new JLabel(imagem2);
		lblImagem4 = new JLabel(imagem4);
		
		reservas = new JButton("RESERVAS");
		reservas.setFont(new Font("Arial", 5, 16));
		reservas.setForeground(new Color(70, 130, 180));
		reservas.setText(" RESERVAS ");
		reservas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		reservas.setRequestFocusEnabled(false);
		reservas.setRolloverEnabled(false);
		reservas.setMargin(new Insets(2, 100, 2, 14));
		
		horarios = new JButton("HORÁRIOS");
		horarios.setFont(new Font("Arial", 5, 16));
		horarios.setForeground(new Color(70, 130, 180));
		horarios.setText(" HORÁRIOS ");
		horarios.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		horarios.setRequestFocusEnabled(false);
		horarios.setRolloverEnabled(false);
		horarios.setMargin(new Insets(2, 100, 2, 14));
		
		titulo.setBounds(220, -75, 300, 215);
		line.setBounds(160,55,340, 1);
		lblImagem2.setBounds(80, 90, 160, 160);
		
		lblImagem4.setBounds(400, 100, 150, 150);
		
		
		add(titulo);
		add(line);
		add(lblImagem2);
		add(reservas);
		add(lblImagem4);
		add(horarios);
	}
	
}
