package com.atoudeft.demos;

import com.atoudeft.tdas.FileChaineeSimple;

public class DemoFile {

	//Ce programme devra fonctionner normalement après l'implémentation
	//complète de la classe FileStatique :
	public static void main(String[] args) {
		
		FileChaineeSimple file = new FileChaineeSimple(3);//file de taille 3
		String valeur;
		
		//On enfile 3 éléments :
		file.enfiler("Suzie");
		file.enfiler("Salim");
		file.enfiler("Pierre");

		//Tentative d'enfiler un 4e élément (devrait échouer) :
		if (!file.enfiler("Georges"))
			System.out.println("File pleine. Georges non ajouté");
		
		//Retirer tous les éléments de file en les affichant ainsi que la taille
		//de la file :
		while (!file.estVide()) {
			valeur = (String)file.defiler();
			System.out.println("Élément dépilé : "+valeur
							+"; Taille de la file "+file.taille());
		}
	}
}
