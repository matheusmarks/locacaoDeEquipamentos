package br.com.locacao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection con = null;
    
    private Conexao(){
        System.out.println("Conexão Criada");
    }
    
    public static Connection getConexao(){
        
        if(con == null){
            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
            String url = "jdbc:mysql://localhost/locacaodeequipamentos?user=root&password=";
            try {
				con = (Connection) DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return con;
    }
    
    public void finalizar(){
        try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    } 
}
