package com.ferramenta.utente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ferramenta.utente.classes.Prodotto;
import com.ferramenta.utente.classes.ProdottoGestore;

public class Main {

	public static void main(String[] args) {

		Scanner interceptor = new Scanner(System.in);
		boolean insAbi = true;
		
		while(insAbi) {
			System.out.println("Scegli l'operazione:\n"
					+ "I - Inserimento\n"
					+ "S - Stampa\n"
					+ "Q - Esci");
			String input = interceptor.nextLine();
			
			switch(input.toUpperCase()) {
				case "I":

					try {
						System.out.println("Nome?");
						String nome = interceptor.nextLine();
						System.out.println("Descrizione?");
						String desc = interceptor.nextLine();
						System.out.println("Quantita?");
						int quan = Integer.parseInt( interceptor.nextLine() );
						System.out.println("Prezzo?");
						float prez = Float.parseFloat( interceptor.nextLine() );
						
						Prodotto temp = new Prodotto(nome, desc, quan, prez);
					
						ProdottoGestore pg = new ProdottoGestore();
						if(pg.insert(temp))
							System.out.println("STAPPOOOOOOOOOO");
						else
							System.out.println("ERrore di inserimento");
					}
					catch (NumberFormatException e) {
						System.out.println("ERRORE di input numerico: " + e.getMessage());
					}
					catch (SQLException e) {
						System.out.println("ERRORE di query SQL: " + e.getMessage());
					}
					catch (Exception e) {
						System.out.println("ERRORE: " + e.getMessage());
					}
					
					break;
				case "S":
					try {
						ProdottoGestore pg = new ProdottoGestore();
						ArrayList<Prodotto> elenco = pg.getAll();
						
						for(int i=0; i<elenco.size(); i++) {
							System.out.println(elenco.get(i) );
						}
					} catch (Exception e) {
						System.out.println("ERRORE: " + e.getMessage());
					}
					break;
				case "Q":
					insAbi = false;
					break;
				default:
					System.out.println("Comando non riconosciuto");
					break;
			}
		}
		
		System.out.println("Programma terminato");
		
	}

}
