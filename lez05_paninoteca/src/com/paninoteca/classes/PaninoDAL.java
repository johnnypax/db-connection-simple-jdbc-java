package com.paninoteca.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;

public class PaninoDAL {
	
	private MysqlDataSource ds;
	
	public PaninoDAL() throws SQLException{
		ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setUser("root");
		ds.setPassword("toor");
		ds.setDatabaseName("java_lez03_paninoteca");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
	}
	
	public ArrayList<Panino> getAll() throws SQLException{
		Connection conn = ds.getConnection();
		ArrayList<Panino> risultato = new ArrayList<Panino>();
		
		String query = "SELECT paninoID, nome, codice, descrizione, prezzo, isvegan FROM Panino";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Panino pan = new Panino(
					rs.getInt("paninoID"),
					rs.getString("nome"),
					rs.getString("codice"),
					rs.getString("descrizione"),
					rs.getFloat("prezzo"),
					rs.getBoolean("isvegan")
					);
			
			risultato.add(pan);
		}
		
		conn.close();
		return risultato;
	}
	
	public ArrayList<Panino> getAllIsVegan(boolean varVegano) throws SQLException{
		Connection conn = ds.getConnection();
		ArrayList<Panino> risultato = new ArrayList<Panino>();
		
		String query = "SELECT paninoID, nome, codice, descrizione, prezzo, isvegan FROM Panino WHERE isvegan = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setBoolean(1, varVegano);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Panino pan = new Panino(
					rs.getInt("paninoID"),
					rs.getString("nome"),
					rs.getString("codice"),
					rs.getString("descrizione"),
					rs.getFloat("prezzo"),
					rs.getBoolean("isvegan")
					);
			
			risultato.add(pan);
		}
		
		conn.close();
		return risultato;
	}

}
