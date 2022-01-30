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
	 * Exercice 3: Ajoutez � la classe ProduitFactory une m�thode getNouveauMagasin() qui s�occupe de
	 * cr�er un magasin � partir de son nom et sa taille. La taille d�un magasin est le nombre
	 * maximum de produits qu�il peut contenir (taille de son tableau listeProduits). La
	 * m�thode doit aussi initialiser le nombre de produits (attribut nombreProduits) � 0.
	 */
	
	public static Magasin getNouveauMagasin(String nomMagasin, int taille) {
		Magasin magasin = new Magasin();
		magasin.nombreProduits = 0;
		magasin.nom = nomMagasin;
		magasin.listeProduits = new Produit[taille];
		return magasin;
	}
}
