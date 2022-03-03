package com.atoudeft.demos;

import com.atoudeft.tdas.FileChaineeSimple;

public class DemoFile {

	//Ce programme devra fonctionner normalement apr�s l'impl�mentation
	//compl�te de la classe FileStatique :
	public static void main(String[] args) {
		
		FileChaineeSimple file = new FileChaineeSimple(3);//file de taille 3
		String valeur;
		
		//On enfile 3 �l�ments :
		file.enfiler("Suzie");
		file.enfiler("Salim");
		file.enfiler("Pierre");

		//Tentative d'enfiler un 4e �l�ment (devrait �chouer) :
		if (!file.enfiler("Georges"))
			System.out.println("File pleine. Georges non ajout�");
		
		//Retirer tous les �l�ments de file en les affichant ainsi que la taille
		//de la file :
		while (!file.estVide()) {
			valeur = (String)file.defiler();
			System.out.println("�l�ment d�pil� : "+valeur
							+"; Taille de la file "+file.taille());
		}
	}
}