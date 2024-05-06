package com.ferramenta.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ProdottoGestore {

	private MysqlDataSource ds;
	
	public ProdottoGestore() throws SQLException{
		ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setUser("root");
		ds.setPassword("toor");
		ds.setDatabaseName("java_lez02_ferramenta");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
	}
	
	public boolean insert(Prodotto objPro) throws SQLException {
		Connection conn = ds.getConnection();
		boolean risultato = false;
		
		String query = "INSERT INTO Prodotto(nome, descrizione, quantita, prezzo) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, objPro.getNome());
		ps.setString(2, objPro.getDesc());
		ps.setInt(3, objPro.getQuan());
		ps.setFloat(4, objPro.getPrez());
		
		int affRows = ps.executeUpdate();
		if(affRows > 0)
			risultato = true;
		
		conn.close();
		
		return risultato;
	}
	
	public boolean delete(int varId) throws SQLException{
		Connection conn = ds.getConnection();
		boolean risultato = false;
		
		String query = "DELETE FROM Prodotto WHERE prodottoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, varId);
		
		int affRows = ps.executeUpdate();
		if(affRows > 0)
			risultato = true;
		
		conn.close();
		
		return risultato;
	}
	
	public ArrayList<Prodotto> getAll() throws SQLException{
		Connection conn = ds.getConnection();
		ArrayList<Prodotto> elenco =  new ArrayList<Prodotto>();
		
		String query = "SELECT prodottoID, nome, descrizione, quantita, prezzo FROM Prodotto";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Prodotto temp = new Prodotto();
			temp.setId( rs.getInt("prodottoID") );
			temp.setNome( rs.getString("nome") );
			temp.setDesc( rs.getString("descrizione") );
			temp.setQuan( rs.getInt("quantita") );
			temp.setPrez( rs.getFloat("prezzo") );
			
			elenco.add(temp);
		}
		
		conn.close();
		return elenco;
	}
}
