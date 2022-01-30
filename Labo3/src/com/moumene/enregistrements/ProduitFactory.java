package com.moumene.enregistrements;

public class ProduitFactory {
	private static int prochainNumeroDeProduit = 1;
	
	public static Produit getNouveauProduit() {
		Produit p;
		p = new Produit();
		p.numero = prochainNumeroDeProduit;
		prochainNumeroDeProduit++;
		return p;
	}
	/*
	 * Exercice 3: Ajoutez à la classe ProduitFactory une méthode getNouveauMagasin() qui s’occupe de
	 * créer un magasin à partir de son nom et sa taille. La taille d’un magasin est le nombre
	 * maximum de produits qu’il peut contenir (taille de son tableau listeProduits). La
	 * méthode doit aussi initialiser le nombre de produits (attribut nombreProduits) à 0.
	 */
	
	public static Magasin getNouveauMagasin(String nomMagasin, int taille) {
		Magasin magasin = new Magasin();
		magasin.nombreProduits = 0;
		magasin.nom = nomMagasin;
		magasin.listeProduits = new Produit[taille];
		return magasin;
	}
}
