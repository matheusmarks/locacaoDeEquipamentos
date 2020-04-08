package br.com.locacao.modeloUsuario;

public class Usuario {
	private int num_matricula;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private char admin;
	
	public int getNum_matricula() {
		return num_matricula;
	}
	
	public void setNum_matricula(int num_matricula) {
		this.num_matricula = num_matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public char getAdmin() {
		return admin;
	}
	
	public void setAdmin(char admin) {
		this.admin = admin;
	}
	


}
