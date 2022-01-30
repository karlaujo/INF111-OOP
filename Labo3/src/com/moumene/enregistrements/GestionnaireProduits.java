package com.moumene.enregistrements;

public class GestionnaireProduits {
	
	/* Exercice 2: Ajoutez à la classe GestionnaireProduits une méthode initialiserProduit() public et
	 * static qui initialise un produit avec les valeurs reçues en paramètre.
	 */
	
	public static void initialiserProduit(Produit p, String nomProduit, double prixProduit) {
		p.nom = nomProduit;
		p.prix = prixProduit;
		
	}
	
	
	/* Exercice 4: Ajoutez à la classe GestionnaireProduits une méthode ajouterProduit() public et
	 * static qui reçoit un magasin et un produit et qui ajoute le produit à la liste des produits
	 * du magasin, s’il y a de la place. La méthode doit retourner true si l’ajout a réussi et false
	 * sinon. Si l’ajout réussi, la méthode doit mettre à jour l’attribut nombreProduits du
	 * magasin.
	 */
	
	public static boolean ajouterProduit(Magasin magasin, Produit p) {
		boolean testAjout = true;
		
		if (magasin.nombreProduits >= magasin.listeProduits.length)
		{
			testAjout = false;
		}
			
		else
		{
			int i = magasin.nombreProduits;
			magasin.listeProduits[i] = p;
			magasin.nombreProduits++;
		}
	
		
		return testAjout;
	}
	
	/*Exercice 5: Ajoutez à la classe GestionnaireProduits une méthode afficher() public et static qui
	 * reçoit un magasin et qui affiche à l’écran son nom et la liste de ses produits (numéros,
	 * noms et prix).
	 * */
	public static void afficher(Magasin magasin) {
		System.out.println("Bienvenue Chez "+magasin.nom);
		
		for (int i=0; i < magasin.nombreProduits; i++ ) {
			Produit p =magasin.listeProduits[i];
			System.out.println(""+p.numero+" "+p.nom+" "+p.prix+" ");
		}
	}
	
	/*Exercice 7: Ajoutez à la classe GestionnaireProduits une méthode getProduitParNumero() public
	 * et static qui reçoit un magasin et un numéro de produit et qui retourne le produit du
	 * magasin qui porte le numéro fourni. Si le produit n’existe pas, la méthode doit retourner
	 * null*/
	public static Produit getProduitParNumero(Magasin magasin, int numero) {
		Produit chercheProduit = null;
		
		for (int i = 0; i < magasin.nombreProduits; i++) {
			if (magasin.listeProduits[i].numero ==  numero)
			{
				 chercheProduit = magasin.listeProduits[i];
			}
			
		}
		
		return chercheProduit;
	}
	
	/* Exercice 8: Ajoutez à la classe GestionnaireProduits une méthode getProduitsCoutantEntre()
	 * public et static qui reçoit un magasin, un prix minimum et un prix maximum et qui
	 * retourne un tableau contenant la liste des produits du magasin qui coutent entre les 2
	 * prix fournis.
	 * */
	public static Produit[] getProduitsCoutantEntre(Magasin magasin, double prixMin, double prixMax) {
		Produit []resultatFiltre = new Produit[magasin.nombreProduits];
		int j=0;
		for (int i=0; i<magasin.nombreProduits; i++) {
			if (magasin.listeProduits[i].prix >= prixMin && magasin.listeProduits[i].prix <= prixMax) {
				resultatFiltre[j] = magasin.listeProduits[i];
				j++;
			}
		}
		
		return resultatFiltre;	
	}
	

}
