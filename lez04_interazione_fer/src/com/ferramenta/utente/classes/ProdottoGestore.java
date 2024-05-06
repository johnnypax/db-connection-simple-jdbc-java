package com.ferramenta.utente.classes;

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
	
	public Prodotto getById(int varId) throws SQLException {
		Connection conn = ds.getConnection();
		Prodotto ris = null;
		
		String query = "SELECT prodottoID, nome, descrizione, quantita, prezzo FROM Prodotto WHERE prodottoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, varId);
		
		ResultSet rs = ps.executeQuery();
		rs.next();

		ris = new Prodotto();
		ris.setId( rs.getInt("prodottoID") );
		ris.setNome( rs.getString("nome") );
		ris.setDesc( rs.getString("descrizione") );
		ris.setQuan( rs.getInt("quantita") );
		ris.setPrez( rs.getFloat("prezzo") );
		
		conn.close();
		return ris;
	}
	
	public boolean update(Prodotto objProdDaMod) throws SQLException  {
		Connection conn = ds.getConnection();
		boolean risultato = false;
		
		Prodotto vecProd = this.getById( objProdDaMod.getId() );
		if(vecProd != null) {
			String query = "UPDATE Prodotto SET "
					+ "nome = ?, "
					+ "descrizione = ?, "
					+ "quantita = ?, "
					+ "prezzo = ? "
					+ "WHERE prodottoID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, objProdDaMod.getNome() != null ? objProdDaMod.getNome() : vecProd.getNome());
			ps.setString(2, objProdDaMod.getDesc() != null ? objProdDaMod.getDesc() : vecProd.getDesc());
			ps.setInt(3, objProdDaMod.getQuan() != 0 ? objProdDaMod.getQuan() : vecProd.getQuan());
			ps.setFloat(4, objProdDaMod.getPrez() != 0 ? objProdDaMod.getPrez() : vecProd.getPrez());
			ps.setInt(5, objProdDaMod.getId());
			
			int affRows = ps.executeUpdate();
			if(affRows > 0)
				risultato = true;
		}
		
		conn.close();
		return risultato;
	}
}
