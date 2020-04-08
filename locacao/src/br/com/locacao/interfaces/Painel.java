package br.com.locacao.interfaces;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Painel extends JPanel {
	
	ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/logo_test.png"));
	private JLabel lblImagem;
	private JLabel titulo;
	private JTextField line;
	private JTextField usuarios2;
	private JPasswordField senha;
	private JLabel usuariotxt;
	private JLabel senhatxt;
	

	
	public Painel(){
		setSize(700,500);
		setBackground(new Color(255,255,255));
		inicializarComponentes();
		setLayout(null);
		
	}
	

	public void inicializarComponentes() {
		
		
		titulo = new JLabel("LOGIN");
		
		line = new JTextField ();
		usuariotxt = new JLabel("USUARIO :");
		senhatxt = new JLabel("SENHA :");
		
		
		usuarios2 = new JTextField ();
		senha = new JPasswordField ();
		
		titulo.setFont(new Font("Arial", 4, 30));
		titulo.setForeground(new Color(16,78,139)); 
		
		line.setBorder(new LineBorder(new Color(70,130,180)));
		
		usuariotxt.setFont(new Font("Arial", Font.PLAIN, 18));
		usuariotxt.setForeground(new Color(16,78,139)); 
		
		
		senhatxt.setFont(new Font("Arial", Font.PLAIN, 18));
		senhatxt.setForeground(new Color(16,78,139)); 
		
		lblImagem = new JLabel(imagem);
		
		titulo.setBounds(400, 1, 115, 115);
		line.setBounds(300,90, 280, 1);
		usuariotxt.setBounds(300, 60, 115, 115);
		senhatxt.setBounds(300, 150, 115, 115);
		lblImagem.setBounds(15, 60, 320, 320);
		
		

		add(titulo);
		add(line);
		add(usuariotxt);
		add(senhatxt);
		add(lblImagem);
	}
}
