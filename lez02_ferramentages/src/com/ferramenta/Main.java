package com.ferramenta;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ferramenta.classes.Prodotto;
import com.ferramenta.classes.ProdottoGestore;

public class Main {

	public static void main(String[] args) {
		
//		int eta = 12;
//		if(eta >= 18) {
//			System.out.println("Sei maggiorenne");
//		}
//		else {
//			System.out.println("Sei minorenne");
//		}
//		
//		System.out.println( eta >= 18 ? "Sei maggiorenne" : "Sei minorenne" );
		
		
		try {
			ProdottoGestore pg = new ProdottoGestore();
			
			//INSERT
//			Prodotto pro = new Prodotto("Nastro isolante", "Sigillante", 25, 1.23f);
//			if(pg.insert(pro))
//				System.out.println("STAPPOOOOOOO");
//			else
//				System.out.println("ERRORE DI INSERIMENTO");
			
			//DELETE
//			if(pg.delete(3))
//				System.out.println("STAPPOOOOOOO");
//			else
//				System.out.println("ERRORE DI INSERIMENTO");
			
			//FINDALL
//			ArrayList<Prodotto> ris = pg.getAll();
//			for(int i=0; i<ris.size(); i++) {
//				System.out.println( ris.get(i) );
//			}
			
			//FIND BY ID
//			System.out.println( pg.getById(24) ); 
			
			//UPDATE
//			Prodotto ese = new Prodotto(2, null, "Viscidissimo", 0, 0);
//			if(pg.update(ese))
//				System.out.println("STAPPOOOOOOO");
//			else
//				System.out.println("ERRORE DI MODIFICA");
				

			
		} catch (SQLException e) {
			System.out.println("ERRORE: " + e.getMessage());
		}
		

	}

}
