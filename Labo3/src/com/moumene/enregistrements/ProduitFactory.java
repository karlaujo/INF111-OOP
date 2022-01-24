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
}
