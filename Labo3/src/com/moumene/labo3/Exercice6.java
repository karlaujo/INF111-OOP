package com.moumene.labo3;

import java.util.Scanner;

import com.moumene.enregistrements.GestionnaireProduits;
import com.moumene.enregistrements.Magasin;
import com.moumene.enregistrements.Produit;
import com.moumene.enregistrements.ProduitFactory;

public class Exercice6 {
	public static Scanner clavier = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		/* Exercice 6: Dans un nouveau programme Exercice6, utilisez les méthodes précédentes pour :
		 * - Créer un magasin de nom FruiETS inc. et de taille 10.
		 * - Ajouter au magasin quelques produits puis l’afficher à l’écran.
		 * */
		
		String nomMagasin = "FruiETS inc.";
		int tailleMagasin = 3;
		
		Magasin store1 = ProduitFactory.getNouveauMagasin(nomMagasin, tailleMagasin);
		int i, j;
		
		Produit p;
		
		for (i=0; i < tailleMagasin ; i++) {
			p = ProduitFactory.getNouveauProduit();
			
			System.out.print("Nom: ");
			String nom = clavier.nextLine();
			
			System.out.print("Prix: ");
			double prix = clavier.nextDouble();
			clavier.nextLine();
			
			GestionnaireProduits.initialiserProduit(p, nom, prix);
			GestionnaireProduits.ajouterProduit(store1, p);
		}
		
		GestionnaireProduits.afficher(store1);
	}
	
	
}
