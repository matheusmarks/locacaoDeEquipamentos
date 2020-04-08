package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.com.locacao.jdbc.Conexao;
import br.com.locacao.modeloUsuario.Horario;
import br.com.locacao.modeloUsuario.Reserva;
import br.com.locacao.modeloUsuario.Usuario;

public class ReservaDAO {
	private static ReservaDAO reservas = null;

	public static ReservaDAO getInstance(){
		if(reservas == null){
			reservas = new ReservaDAO();
		}   
		return reservas;
	}
	
	public void adicionaReserva(Reserva rs){
		
		String sql = "INSERT INTO reservas(num_matricula,data,tempo_aula_inicial,tempo_aula_final,disciplina,turma) "
				+ "values(? , ? , ?,  ? , ? , ?)";
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rs.getNumMatricula());
			pstmt.setString(2, rs.getDataReserva());
			pstmt.setString(3, rs.getTempoInicial());
			pstmt.setString(4, rs.getTempoFinal());
			pstmt.setString(5, rs.getDisciplina());
			pstmt.setString(6, rs.getTurma());
			
			
			pstmt.execute();
			pstmt.close();
			
			
			JOptionPane.showMessageDialog(null, "Reserva efetuada com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados!");
		}
	}
	
	public List<Reserva> getReservas(String nome) throws SQLException{
		List<Reserva> reservas = new ArrayList<Reserva>();
		Connection con = Conexao.getConexao();
		String sql = "SELECT * FROM reservas where data like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + nome + "%");
		ResultSet rs =  pstmt.executeQuery();
		try {
			while(rs.next()){
				Reserva rv = new Reserva();
				rv.setReserva(rs.getInt("cod_reserva"));
				rv.setNumMatricula(rs.getInt("num_matricula"));
				rv.setDataReserva((rs.getString("data")));
				rv.setTempoInicial((rs.getString("tempo_aula_inicial")));
				rv.setTempoFinal((rs.getString("tempo_aula_final")));
				rv.setDisciplina((rs.getString("disciplina")));
				rv.setTurma((rs.getString("turma")));
				
				reservas.add(rv);	
			}

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return reservas;

	}
	
	public static List<Reserva> getReserva() throws SQLException{
		List<Reserva> reservas = new ArrayList<Reserva>();
		Connection con = Conexao.getConexao();
		String sql = "SELECT * FROM reservas";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Reserva rv = null;

		try {
			while(rs.next()){
				rv = new Reserva();
				rv.setReserva((rs.getInt("cod_reserva")));
				rv.setNumMatricula((rs.getInt("num_matricula")));
				rv.setDataReserva((rs.getString("data")));
				rv.setTempoInicial((rs.getString("tempo_aula_inicial")));
				rv.setTempoFinal((rs.getString("tempo_aula_final")));
				rv.setDisciplina((rs.getString("disciplina")));
				rv.setTurma((rs.getString("turma")));
			
				reservas.add(rv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservas;
	}
}
