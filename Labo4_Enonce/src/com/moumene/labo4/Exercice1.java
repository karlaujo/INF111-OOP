package com.moumene.labo4;

import java.util.Scanner;
//import java.util.Locale;

public class Exercice1 {
	public static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] fruits = {"Poires","Figues","Grenadines","Prunes","Mangues",
				"Raisins","Mandarines","Pommes","Melons","Kiwis","Abricots",
				"Bananes","Cerises"};
		/*Exercice 1.1: Utilisez un des algorithmes de tri vu en cours pour trier le tableau par ordre
		 * � alphab�tique �. Le tableau tri� doit �tre affich� � l��cran.
		 * */
		int i, j;
		String temp;
		for (i = 1; i < fruits.length; ++i) {
			temp = fruits[i];
			
			for (j = i; j > 0 && fruits[j-1].compareTo(temp) > 0; j--) {
			fruits[j] = fruits[j-1];
			}
			
			fruits[j] = temp;
		}
		System.out.println("Liste: ");
		for (i = 0; i < fruits.length; i++ ) {
			Exercice1.afficherProduit(fruits[i], i);
		}
		System.out.println();
		

		/*Exercice 1.2: Apr�s le tri, faites en sorte que le programme demande � l�utilisateur une s�rie
		 * de noms de fruits jusqu�� ce qu�il saisisse la chaine � fin �. Pour chacun des noms
		 * saisis, le programme doit effectuer une recherche dichotomique pour voir s�il est
		 * pr�sent dans le tableau. S�il est trouv�, le programme affiche sa position, sinon il
		 * affiche un message en cons�quence.
		 * */
		
		String fruit;
		System.out.print("Fruit recherche: ");
		fruit = clavier.nextLine();
		boolean trouve = false;
		int position=0;
		
		while (!fruit.equalsIgnoreCase("fin")) {
			
			for(i=0; i<fruits.length;i++) {
				if (fruits[i].equalsIgnoreCase(fruit)) {
					trouve = true;
					position = i;
				}	
			}
			
			if (trouve) {
				System.out.println("Present a la position: "+position);
			}
			else {
				System.out.println("Pas trouve");
			}
			System.out.print("Fruit recherche: ");
			fruit = clavier.nextLine();
		}
		System.out.print("Au Revoir!");
		
	}
	
	public static void afficherProduit(String fruit, int position) {
		System.out.println(position+" "+fruit);
	}

}
