package com.paninoteca;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.paninoteca.classes.Panino;
import com.paninoteca.classes.PaninoDAL;

public class Main {

	public static void main(String[] args) {
		
		Scanner interceptor = new Scanner(System.in);
		boolean insAbi = true;
		
		while(insAbi) {
			System.out.println("Cosa vuoi fare?\n"
					+ "L - Lista panini con relativi dettagli\n"
					+ "V - Lista panini Vegani\n"
					+ "N - Lista panini NON Vegani\n"
					+ "Q - Uscita");
			
			String input = interceptor.nextLine();
			
			switch(input) {
			case "L":
				try {
					PaninoDAL padal = new PaninoDAL();
					ArrayList<Panino> elenco = padal.getAll();
					
					System.out.println("--------------- ELENCO PRODOTTI ---------------");
					for(int i=0; i<elenco.size(); i++) {
						System.out.println( elenco.get(i).stampaDettaglio() );
					}
					System.out.println("-----------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				break;
			case "V":
				try {
					PaninoDAL padal = new PaninoDAL();
					ArrayList<Panino> elenco = padal.getAllIsVegan(true);
					
					System.out.println("--------------- ELENCO PRODOTTI ---------------");
					for(int i=0; i<elenco.size(); i++) {
						System.out.println( elenco.get(i).stampaDettaglio() );
					}
					System.out.println("-----------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				break;
			case "N":
				try {
					PaninoDAL padal = new PaninoDAL();
					ArrayList<Panino> elenco = padal.getAllIsVegan(false);
					
					System.out.println("--------------- ELENCO PRODOTTI ---------------");
					for(int i=0; i<elenco.size(); i++) {
						System.out.println( elenco.get(i).stampaDettaglio() );
					}
					System.out.println("-----------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				break;
			case "Q":
				insAbi = false;
				break;
			default:
				System.out.println("Comando sconosciuto");
				break;
			}
		}
		
		System.out.println("Programma terminato");

	}

}
