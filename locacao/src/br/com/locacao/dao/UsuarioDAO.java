package br.com.locacao.dao;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO usuario = null;

	public static UsuarioDAO getInstance(){
		if(usuario == null){
			usuario = new UsuarioDAO();
		}   
		return usuario;
	}
	
	

	public void adicionaUsuario(Usuario usr){
		String sql = "INSERT INTO usuario(num_matricula,nome,email,login,senha,admin)" + 
				"values(? , ? , ? , ? , ? , ?)";
		Connection con = Conexao.getConexao();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, usr.getNum_matricula());
			pstmt.setString(2, usr.getNome());
			pstmt.setString(3, usr.getEmail());
			pstmt.setString(4, usr.getLogin());
			pstmt.setString(5, criptografiaDeSenha(usr.getSenha()));
			pstmt.setString(6, String.valueOf(usr.getAdmin()));
			
			pstmt.execute();
			pstmt.close();

			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados!");
		}
	}
	
	public String criptografiaDeSenha(String original){
		String senha = null;
		MessageDigest algoritmo;
		byte messageDigest[];
		StringBuilder hexString;
		try{
			 algoritmo = MessageDigest.getInstance("MD5");  // 32 letras
			 messageDigest = algoritmo.digest(original.getBytes("UTF-8"));
			 hexString = new StringBuilder();
				for (byte b : messageDigest) {
					hexString.append(String.format("%02X", 0xFF & b));
				}
				senha = hexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return senha;
		
	}

	//Método para listar os usuários e em seguida validar o login
	public static List<Usuario> getUsuario() throws SQLException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection con = Conexao.getConexao();
		String sql = "SELECT * FROM usuario";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Usuario usuario = null;

		try {
			while(rs.next()){
				usuario = new Usuario();
				usuario.setNum_matricula(rs.getInt("num_matricula"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setAdmin(rs.getString("admin").charAt(0));
				
				
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	//Listando os usuários com o SELECT para por os dados em uma JTable
	public List<Usuario> getUsuarios(String nome) throws SQLException{
		List<Usuario> users = new ArrayList<Usuario>();
		Connection con = Conexao.getConexao();
		String sql = "SELECT * FROM usuario where nome like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + nome + "%");
		ResultSet rs =  pstmt.executeQuery();
		try {
			while(rs.next()){
				Usuario usr = new Usuario();
				usr.setNum_matricula(rs.getInt("num_matricula"));
				usr.setNome(rs.getString("nome"));
				usr.setEmail(rs.getString("email"));
				usr.setLogin(rs.getString("login"));
				usr.setSenha(rs.getString("senha"));
				try {
					usr.setAdmin(rs.getString("admin").charAt(0));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				users.add(usr);	
			}

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return users;

	}
	
	//Método para deletar os usuários
	public void deletarUsuario(int usr){
		Usuario usr2 = new Usuario();
		Connection con = Conexao.getConexao();
		String sql = "DELETE FROM usuario where id=" + "?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, usr2.getNum_matricula());
			pstmt.execute();
			pstmt.close();
			System.out.println("Deletado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Método para atualizar os dados com o UPDATE
	public void alteraUsuario(Usuario usr) throws SQLException{
		Connection con = Conexao.getConexao();
		String sql = "UPDATE usuario set nome= ?, email= ?, login= ?  WHERE num_matricula= ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, usr.getNome());
		pstmt.setString(2, usr.getEmail());
		pstmt.setString(3, usr.getLogin());
		pstmt.setInt(4, usr.getNum_matricula());
		
		pstmt.execute();
		pstmt.close();
		
		System.out.println("Dados alterados com sucesso !");
	}
	
          
        
        


}
