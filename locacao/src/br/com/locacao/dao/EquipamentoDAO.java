package br.com.locacao.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Equipamento;
import br.com.locacao.modeloUsuario.Usuario;



public class EquipamentoDAO {
	private static EquipamentoDAO equipamentos = null;

	public static EquipamentoDAO getInstance(){
		if(equipamentos == null){
			equipamentos = new EquipamentoDAO();
		}   
		return equipamentos;
	}
	
	public void adicionaEquipamento(Equipamento eq){
		
		String sql = "INSERT INTO equipamentos(cod_equipamento,nome_equipamento,descricao) "
				+ "values(? , ? , ?)";
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eq.getCod_equipamentos());
			pstmt.setString(2, eq.getNome_equipamento());
			pstmt.setString(3, eq.getDescricao());
			
			pstmt.execute();
			pstmt.close();
		
			
			JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados!");
		}
	}
	
	
	public List<Equipamento> getEquipamento(String nome2) throws SQLException{
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		Connection con = Conexao.getConexao();
		
		String sql = "SELECT * FROM equipamentos where nome_equipamento like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, "%" + nome2 + "%");
		
		ResultSet rs =  pstmt.executeQuery();
		try {
			while(rs.next()){
				Equipamento eq = new Equipamento();
				eq.setCod_equipamentos(rs.getInt("cod_equipamento"));
				eq.setDescricao(rs.getString("descricao"));
				eq.setNome_equipamento(rs.getString("nome_equipamento"));
				
				
				equipamentos.add(eq);	
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return equipamentos;
	}
	
	public void deletarEquipamento(int eq){
		Equipamento eq2 = new Equipamento();
		Connection con = Conexao.getConexao();
		String sql = "DELETE FROM equipamentos where cod_equipamento=" + "?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eq2.getCod_equipamentos());
			pstmt.execute();
			
			System.out.println("Deletado com sucesso!");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alteraEquipamentos(Equipamento eq) throws SQLException{
		Connection con = Conexao.getConexao();
		String sql = "UPDATE equipamentos set nome_equipamento= ?, descricao= ?  WHERE cod_equipamento= ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, eq.getNome_equipamento());
		pstmt.setString(2, eq.getDescricao());
		pstmt.setInt(3, eq.getCod_equipamentos());
		
		
		pstmt.execute();
		pstmt.close();
		
	
	}
}
