package com.moumene.labo3;

import java.util.Scanner;

import com.moumene.enregistrements.GestionnaireProduits;
import com.moumene.enregistrements.Produit;
import com.moumene.enregistrements.ProduitFactory;

public class Exercice1 {
	
	public static Scanner clavier = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		/*Exercice1: créez 3 produits avec cette méthode. Affichez à chaque
		 * fois les numéro, nom et prix du produit créé.
		 */
		
		//Creation de 3 produits
		Produit p1 = ProduitFactory.getNouveauProduit();
		Produit p2 = ProduitFactory.getNouveauProduit();
		Produit p3 = ProduitFactory.getNouveauProduit();
		
		//Demander les noms
		System.out.println("Trois noms: ");
		p1.nom = clavier.nextLine();
		p2.nom = clavier.nextLine();
		p3.nom = clavier.nextLine();
		System.out.print("\n");
		
		//Demander les prix
		System.out.print("Troix prix: ");
		p1.prix = clavier.nextDouble();
		p2.prix = clavier.nextDouble();
		p3.prix = clavier.nextDouble();
		clavier.nextLine();
		System.out.print("\n");
		
		//Creer les 3 produits
		GestionnaireProduits.initialiserProduit(p1, p1.nom, p1.prix);
		GestionnaireProduits.initialiserProduit(p2, p2.nom, p2.prix);
		GestionnaireProduits.initialiserProduit(p3, p3.nom, p3.prix);
		
		//Afficher les 3 Produits
		System.out.print(""+p1.numero+" "+p1.nom+" "+p1.prix+"\n");
		System.out.print(""+p2.numero+" "+p2.nom+" "+p2.prix+"\n");
		System.out.print(""+p3.numero+" "+p3.nom+" "+p3.prix+"\n");
		
	}
}
