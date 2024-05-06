package com.ferramenta.interazione;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		Scanner interceptor = new Scanner(System.in);
//		
//		System.out.println("Come ti chiami?");
//		String nome = interceptor.nextLine();
//		
//		System.out.println("Ciao " + nome);
		
		//------------------------------------------------
		
//		while(true) {
//			Scanner interceptor = new Scanner(System.in);
//			
//			System.out.println("Come ti chiami?");
//			String nome = interceptor.nextLine();
//			
//			System.out.println("Ciao " + nome);
//		}
		
		//------------------------------------------------
		
		boolean insAbi = true;
		
		while(insAbi) {
			Scanner interceptor = new Scanner(System.in);
			
			System.out.println("Come ti chiami? Digita Q per uscire");
			String input = interceptor.nextLine();
			
			if(input.equals("Q"))
				insAbi = false;
			else			
				System.out.println("Ciao " + input);
		}
		
	}

}
