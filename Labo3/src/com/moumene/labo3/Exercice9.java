package com.moumene.labo3;

import java.util.Scanner;

import com.moumene.enregistrements.GestionnaireProduits;
import com.moumene.enregistrements.Magasin;
import com.moumene.enregistrements.Produit;
import com.moumene.enregistrements.ProduitFactory;

public class Exercice9 {
	public static Scanner clavier = new Scanner(System.in);
	public static final char QUITTER = 'q';
	
	public static void main(String args[]) {
		char choix;
		
		System.out.print("Nom de magasin: ");
		String nom = clavier.nextLine();
		
		System.out.print("Taille: ");
		int taille = clavier.nextInt();
		clavier.nextLine();
		
		Magasin magasin = ProduitFactory.getNouveauMagasin(nom, taille);
		Produit p;
		int i;
		
		choix=menu();
		while (choix!=QUITTER)
		{
			switch (choix)
			{
				case 'a':
					System.out.println("Afficher le Magasin");
					GestionnaireProduits.afficher(magasin);
					break;
				case '+':
					System.out.println("Nouveau Produits");
					p = ProduitFactory.getNouveauProduit();
					
					for (i=0; i < taille ; i++) {
						p = ProduitFactory.getNouveauProduit();
						
						System.out.print("Nom: ");
						String nomProd = clavier.nextLine();
						
						System.out.print("Prix: ");
						double prix = clavier.nextDouble();
						clavier.nextLine();
						
						GestionnaireProduits.initialiserProduit(p, nomProd, prix);
						GestionnaireProduits.ajouterProduit(magasin, p);
					}
					
					break;
				case 'n':
					System.out.println("Recherche par Numero");
					System.out.print("Numero produit: ");
					int numero = clavier.nextInt();
					clavier.nextLine();
					System.out.print(GestionnaireProduits.getProduitParNumero(magasin, numero).nom);
					break;
				case 'p':
					System.out.println("Recherche par Prix");
					System.out.print("Prix minimum: ");
					double min = clavier.nextDouble();
					clavier.nextLine();
					System.out.print("Prix maximum: ");
					double max = clavier.nextDouble();
					clavier.nextLine();
					Produit []liste = GestionnaireProduits.getProduitsCoutantEntre(magasin, min, max);
					if (liste == null) {
						System.out.println("Aucun produit entre: "+min+"$ et "+max+"$");
					}
					
					else
					{
						System.out.println("Produits trouves: ");
						for (int j=0; j<liste.length;j++) {
 
							System.out.println();
						}
					}
					break;
				default:
					System.out.println("Opération inconnue...");
			}
			choix=menu();
		}
		System.out.println("Bye Bye");
	}

	private static char menu() {
		char reponse;
		String str;
		System.out.println("\n------- MENU -------\n\na.Afficher le Magasin.\n+.Nouveau Produit.\nn.Recherche par Numero.\n"+
							"p.Recherche par Prix.\nq.Quitter.\n");
		
		System.out.print("\tVotre choix : ");
		str = clavier.nextLine();
		if (str.length()>0)
			reponse = str.charAt(0);
		else
			reponse = ' ';
		return reponse;
	}
}
