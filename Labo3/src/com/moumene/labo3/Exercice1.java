package com.moumene.labo3;

import java.util.Scanner;

import com.moumene.enregistrements.GestionnaireProduits;
import com.moumene.enregistrements.Produit;
import com.moumene.enregistrements.ProduitFactory;

public class Exercice1 {
	
	public static Scanner clavier = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		//Enregistrement Produit
		Produit p1 = ProduitFactory.getNouveauProduit();
		Produit p2 = ProduitFactory.getNouveauProduit();
		Produit p3 = ProduitFactory.getNouveauProduit();
		
		//Initialisation noms
		System.out.println("Trois noms: ");
		String nom1 = clavier.nextLine();
		String nom2 = clavier.nextLine();
		String nom3 = clavier.nextLine();
		
		//Initialisations prix:
		System.out.println("Trois prix: ");
		double prix1 = clavier.nextDouble();
		double prix2 = clavier.nextDouble();
		double prix3 = clavier.nextDouble();
		
		//Ajout de la classe de gestion des données
		GestionnaireProduits.initialiserProduit(p1, nom1, prix1);
		GestionnaireProduits.initialiserProduit(p2, nom2, prix2);
		GestionnaireProduits.initialiserProduit(p3, nom3, prix3);
		
		//Affichage données
		System.out.println(p1.numero+" "+p1.nom+" "+p1.prix+"");
		System.out.println(p2.numero+" "+p2.nom+" "+p2.prix+"");
		System.out.println(p3.numero+" "+p3.nom+" "+p3.prix+"");
	}
}
