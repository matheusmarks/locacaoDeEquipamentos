package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Horario;
import br.com.locacao.modeloUsuario.Usuario;

public class HorarioDAO {
	private static HorarioDAO horarios = null;

	public static HorarioDAO getInstance(){
		if(horarios == null){
			horarios = new HorarioDAO();
		}   
		return horarios;
	}
	
	public void adicionaHorario(Horario hr){
		
		String sql = "INSERT INTO horarios(dia_da_semana,tempo_aula) "
				+ "values(? , ?)";
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hr.getDiaDaSemana());
			pstmt.setString(2, hr.getTempo());
			
			pstmt.execute();
			pstmt.close();
			
			
			JOptionPane.showMessageDialog(null, "Horário cadastrado com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados!");
		}
	}
	
	public List<Horario> getHorarios(String nome) throws SQLException{
		List<Horario> horarios = new ArrayList<Horario>();
		Connection con = Conexao.getConexao();
		String sql = "SELECT * FROM horarios where dia_da_semana like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + nome + "%");
		ResultSet rs =  pstmt.executeQuery();
		try {
			while(rs.next()){
				Horario hr = new Horario();
				hr.setCod_horario(rs.getInt("cod_horario"));
				hr.setDiaDaSemana(rs.getString("dia_da_semana"));
				hr.setTempo(rs.getString("tempo_aula"));
				
				horarios.add(hr);	
			}

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return horarios;

	}
	
	public void alteraHorario(Horario hr) throws SQLException{
		Connection con = Conexao.getConexao();
		String sql = "UPDATE horarios set dia_da_semana= ?, tempo_aula= ?  WHERE cod_horario= ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, hr.getDiaDaSemana());
		pstmt.setString(2, hr.getTempo());
		pstmt.setInt(3, hr.getCod_horario());
		
		
		pstmt.execute();
		pstmt.close();
		
		
		System.out.println("Dados alterados com sucesso !");
	}
	
	
}
