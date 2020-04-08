package br.com.locacao.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.locacao.modeloUsuario.Usuario;

public class PainelEditarUsuario extends JPanel{
	private JLabel titulo;
	private JLabel matricula;
	private static JTextField matriculatxt;
	private static JTextField nometxt;
	private static JTextField emailtxt;
	private JLabel nome2;
	private JLabel email;
	private JTextField line2;
	private JLabel usuariotxt;
	private JLabel txt;
	private JButton cadastrar;


	public PainelEditarUsuario(){
		inicializarComponentes();
		setBackground(new Color(255,255,255));
		setLayout(null);
	}

	public void inicializarComponentes() {

		usuariotxt = new JLabel("Usuário");
		usuariotxt.setFont(new Font("Arial", 15, 30));
		usuariotxt.setForeground(new Color(16,78,139)); 

		line2 = new JTextField();
		line2.setBorder(new LineBorder(new Color(70,130,180)));

		nome2 = new JLabel("Nome :");
		nome2.setFont(new Font("Arial", 4, 20));
		nome2.setForeground(new Color(16,78,139));

		nometxt = new JTextField();

		emailtxt = new JTextField();

		matriculatxt = new JTextField();

		email = new JLabel("Email :");
		email.setFont(new Font("Arial", 4, 20));
		email.setForeground(new Color(16,78,139)); 

		txt = new JLabel("Editar");
		txt.setFont(new Font("Arial", 4, 35));
		txt.setForeground(new Color(16,78,139)); 


		matricula = new JLabel("Nº Matrícula :");
		matricula.setFont(new Font("Arial", 4, 20));
		matricula.setForeground(new Color(16,78,139)); 


		cadastrar = new JButton("CADASTRAR");
		cadastrar.setFont(new Font("Arial", 5, 16));
		cadastrar.setForeground(new Color(70, 130, 180));
		cadastrar.setText(" EDITAR ");
		cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(211,211,211), 1));
		cadastrar.setRequestFocusEnabled(false);
		cadastrar.setRolloverEnabled(false);
		cadastrar.setMargin(new Insets(2, 100, 2, 14));


		nometxt.setBounds(250, 150, 250, 30);
		emailtxt.setBounds(250, 200, 250, 30);
		matriculatxt.setBounds(250, 100, 250, 30);
		usuariotxt.setBounds(280, -75, 300, 215);
		line2.setBounds(160,55,340, 1);
		nome2.setBounds(180,37,250,250);
		email.setBounds(183, 88, 250, 250);
		txt.setBounds(300,5,250,50);
		cadastrar.setBounds(180, 360, 350, 40);
		matricula.setBounds(120, -10, 250,250);


		add(txt);
		add(line2);
		add(nome2);
		add(nometxt);
		add(emailtxt);
		add(matriculatxt);
		add(email);
		add(cadastrar);
		add(matricula);
	}


	public void getUsuario(Usuario usr){
		matriculatxt.setText(String.valueOf(usr.getNum_matricula()));
		nometxt.setText(usr.getNome());
		emailtxt.setText(usr.getEmail());
	}
}
