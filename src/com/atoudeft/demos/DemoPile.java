package com.atoudeft.demos;

import com.atoudeft.tdas.PileChaineeSimple;

public class DemoPile {

	//Ce programme devra fonctionner normalement après l'implémentation
	//complète de la classe PileStatique :
	public static void main(String[] args) {
		
		PileChaineeSimple pile = new PileChaineeSimple(5);//pile de taille 5
		int valeur;
		
		//On empile 5 éléments :
		pile.empiler(59);
		pile.empiler(24);
		pile.empiler(32);
		pile.empiler(41);
		pile.empiler(71);
		
		//Tentative d'empiler un 6e élément (devrait échouer) :
		if (!pile.empiler(88))
			System.out.println("Pile pleine. 88 non empilé");
		
		//Dépiler tous les éléments de pile en les affichant ainsi que la taille
		//de la pile :
		while (!pile.estVide()) {
			valeur = (Integer)pile.depiler();
			System.out.println("Élément dépilé : "+valeur
							+"; Taille de la pile "+pile.taille());
		}
	}
}
