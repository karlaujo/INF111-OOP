package com.exercice2_5;

import java.util.Scanner;
import com.atoudeft.tdas.FileStatique;
import com.atoudeft.tdas.PileStatique;

public class Exercice2 {
	static Scanner clavier = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		System.out.print("Veuillez saisir le mot: ");
		String mot = clavier.nextLine();
		estUnPalindrome(mot);
		
		while (!mot.equals("!q")) {
			if (estUnPalindrome(mot)) {
				System.out.print(""+mot+" est un palindrome");
			}
			
			else {
				System.out.print(""+mot+" n'est pas un palindrome");
			}
			
			System.out.print("\n\n(saisir !q pour arreter)");
			System.out.print("\nVeuillez saisir un prochain mot: ");
			mot = clavier.nextLine();
		}
		
	}

	public static boolean estUnPalindrome(String mot) {
		char lettre;
		boolean testPalindrome = false;
		
		FileStatique file = new FileStatique(mot.length());
		PileStatique pile = new PileStatique(mot.length());
		
		for (int i=0; i < mot.length(); i++) {
			lettre = mot.charAt(i);
			file.enfiler(lettre);
			pile.empiler(lettre);
			
		}
		
		testPalindrome = true;
		while (!pile.estVide() && testPalindrome) {
			if (pile.depiler() != file.defiler())
				testPalindrome = false;
		}
		
		return testPalindrome;
	}
	
}


