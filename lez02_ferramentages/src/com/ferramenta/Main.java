package com.ferramenta;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ferramenta.classes.Prodotto;
import com.ferramenta.classes.ProdottoGestore;

public class Main {

	public static void main(String[] args) {
		
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
			
			ArrayList<Prodotto> ris = pg.getAll();
			for(int i=0; i<ris.size(); i++) {
				System.out.println( ris.get(i) );
			}
				

			
		} catch (SQLException e) {
			System.out.println("ERRORE DI CONN.");
		}
		

	}

}
