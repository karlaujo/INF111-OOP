package com.moumene.rummy;

import java.util.Scanner;

import com.moumene.util.Util;

/**
 * @author atoudeft
 *
 */
public class Rummy {

	//La pioche :
	public static Pioche pioche = new Pioche();

	//Combinaisons qui sont sur la table :
	public static Piece[][] tableDeJeu = 
		new	Piece[Constantes.MAX_COMBINAISONS][Constantes.LONGUEUR_MAX_COMBINAISON];
	
	//Indique le nombre effectif de combinaisons sur la table :
	public static int nombreCombinaisonsSurLaTable = 0;
	
	//Indique le nombre de pieces dans chaque combinaison :
	public static int[] nombresPieces = new int[Constantes.MAX_COMBINAISONS];	
	
	// Pour les saisies au clavier en mode console:
	public static Scanner clavier = new Scanner(System.in);
	
	public static Joueur joueur1 = new Joueur(),
						 joueur2 = new Joueur(),
						 joueurActif;

	public static void main(String[] args) {

		System.out.print("Nom premier joueur : ");
		joueur1.nom = clavier.next();
		System.out.print("Nom deuxi�me joueur : ");
		joueur2.nom = clavier.next();
		
		initialiserPioche(pioche);
		melangerPioche(pioche);
		distribuerMain(pioche,joueur1,Constantes.TAILLE_MANNE_DEPART);
		distribuerMain(pioche,joueur2,Constantes.TAILLE_MANNE_DEPART);

		joueurActif = joueur1;
		while (!mainVide(joueur1) && !mainVide(joueur2)) {
			faireJouer(joueurActif);
			passerAuSuivant();
		}
		if (mainVide(joueur1)) {
			System.out.println("Partie termin�e. Le gagnant est "+joueur1.nom);
		} else {
			System.out.println("Partie termin�e. Le gagnant est "+joueur2.nom);
		}
	}
	
/***** M�thodes de d�roulement du jeu *****/
	
	/**
	 * Donne le tour au joueur inactif, qui devient le joueur actif
	 */
	public static void passerAuSuivant() {
		
	}
	
	/**
	 * Fait jouer un tour au joueur.
	 * @param joueur
	 */
	public static void faireJouer(Joueur joueur) {

	}
	
/***** M�thodes de manipulation de pi�ces *****/	
	
	/**
	 * Retourne la valeur d'une piece.
	 * @param piece la pi�ce dont on retourne la valeur
	 * @return la valeur de la pi�ce
	 */
	public static int getValeur(Piece piece) {
		return piece.numero;
	}
	
	/**
	 * Retourne une chaine de caract�re d�crivant une piece.
	 * @param piece la pi�ce dont on retourne la repr�sentation
	 * @return la chaine d�crivant la pi�ce
	 */
	public static String toString(Piece piece) {
		return "["+piece.numero+""+piece.couleur+"]";
	}
	
	/**
	 * Retourne un tableau contenant les pi�ces d�crites dans la saisie.
	 * Cette m�thode suppose que la saisie a �t� v�rifi�e.
	 * 
	 * @param saisie chaine de caract�res d�crivant une liste de pi�ces.
	 * 		  Exemple : 3V12J5V
	 * @return tableau contenant les pi�ces d�crites dans la saisie.
	 */
	public static Piece[] extrairePieces(String saisie) {

		return null;
	}
	
	/**
	 * Ajoute une pi�ce � la main d'un joueur.
	 * @param joueur le joueur qui recevra la pi�ce dans sa main
	 * @param piece la pi�ce � ajouter
	 * @return true si la pi�ce a �t� ajout�e, false si la pi�ce n'a pas �t�
	 * 		   ajout�e car la main est pleine.	
	 */
	public static boolean ajouterPiece(Joueur joueur, Piece piece) {

		return false;
	}	
		
	/**
	 * Ajouter une liste de pi�ces � une combinaison de la table de jeu.
	 * @param pieces tableau contenant les pi�ces � ajouter
	 * @param numeroCombinaison le num�ro de la combinaison sur la table �
	 * 							laquelle les pi�ces vont �tre ajout�es. La 
	 * 							premi�re combinaison porte le num�ro 1.
	 * @return true si toutes le pi�ces ont �t� ajout�es, false sinon.	
	 */
	public static boolean ajouterPiecesALaCombinaison(Piece[] pieces,
														int numeroCombinaison) {

		return false;
	}

	/**
	 * Ajouter une liste de pi�ces dans une nouvelle combinaison de la table de 
	 * jeu.
	 * @param pieces tableau contenant les pi�ces composant la combinaison.
	 * @return true si la nouvelle combinaison a �t� ajout�e, false sinon.	
	 */
	public static boolean ajouterNouvelleCombinaisonALaTable(Piece[] pieces) {

		return false;
	}
	
/***** M�thodes de v�rification *****/	
	
	/**
	 * V�rifie si la main d'un joueur est vide ou non.
	 * @param joueur le joueur
	 * @return true si la main du joueur est vide, false sinon.
	 */
	public static boolean mainVide(Joueur joueur) {
		
		return false;
	}
	
	/**
	 * V�rifie si un caract�re correspond � une couleur du jeu.
	 * @param caractere
	 * @return true si le caract�re est une couleur valide, false sinon.
	 */
	public static boolean estUneCouleurValide(char caractere) {

		return false;
	}	

	/**
	 * V�rifie si une chaine de caract�res d�crit correctement une liste de
	 * pi�ces.
	 * @param chaine la chaine de caract�res � v�rifier
	 * @return true, si la chaine est une description correcte d'une liste de
	 * 			pi�ces, false sinon.
	 */
	public static boolean saisieCorrecte(String chaine) {

		return false;
	}
	
	/**
	 * V�rifie si une liste de pi�ces fait partie de la main d'un joueur.
	 * @param joueur le joueur
	 * @param pieces la liste des pi�ces
	 * @return true si toutes les pi�ces de la liste sont dans la main du 
	 * 		   joueur, false sinon.
	 */
	public static boolean valide(Joueur joueur, Piece[] pieces) {

		return false;
	}
	
	/**
	 * V�rifie si une liste de pi�ces constitue une combinaison (suite ou s�rie)
	 * @param pieces la liste des pi�ces
	 * @return true si la liste est une combinaison, false sinon.
	 */
	public static boolean estUneCombinaison(Piece[] pieces) {

		return false;
	}




/***** M�thodes de manipulation de la pioche *****/	
	
	/**
	 * Retire des pi�ces d'une pioche et les place dans la main d'un joueur.
	 * @param pioche la pioche
	 * @param joueur le joueur
	 * @param nombrePieces le nombre de pi�ces � extraire de la pioche
	 */
	public static void distribuerMain(Pioche pioche, Joueur joueur, 
										int nombrePieces) {

	}
	
	/**
	 * Extrait une pi�ce d'une pioche. Le choix de la pi�ce d�pend de
	 * l'impl�mentation.
	 * @param pioche la pioche
	 * @return la pi�ce extraite
	 */
	public static Piece piocher(Pioche pioche) {

		return null;
	}
	
	/**
	 * Remplace une pi�ce d'une pioche par une autre pi�ce. La pi�ce 
	 * remplac�e est retourn�e. La strat�gie de choix de la pi�ce � retirer
	 * d�pend de l'impl�mentation.
	 * @param pioche La pioche d'o� la pi�ce va �tre retir�e.
	 * @param piece La pi�ce � placer dans la pioche.
	 * @return La pi�ce retir�e de la pioche.
	 */
	public static Piece echanger(Pioche pioche, Piece piece) {

		return null;
	}
	
	/**
	 * G�n�re les 106 pi�ces du jeu et les place dans une pioche.
	 * @param pioche La pioche o� les pi�ces vont �tre plac�es.
	 */
	//Place les 106 pieces dans la pioche (incluant les 2 jokers) :
	public static void initialiserPioche(Pioche pioche) {

	}
	
	/**
	 * Vide une pioche et y retirant toutes les pi�ces.
	 * @param pioche La pioche � vider
	 */
	public static void vider(Pioche pioche) {

	}
	
	/**
	 * Ajoute une pi�ce � une pioche.
	 * @param pioche La pioche o� la pi�ce va �tre ajout�e
	 * @param pioche La pi�ce � ajouter
	 * @return true si l'ajout a r�ussi, false sinon (faute de place)
	 */
	public static boolean ajouterPiece(Pioche pioche, Piece piece) {

		return false;
	}
	
	/**
	 * M�lange al�atoirement toutes les pieces de la pioche.
	 * @param pioche La pioche
	 */
	public static void melangerPioche(Pioche pioche) {

	}


/***** M�thodes d'affichage *****/
	
	/**
	 * Affiche � l'�cran les premi�res pi�ces d'une liste.
	 * @param pieces La liste des pi�ces
	 * @param nombre Le nombre de pi�ces de la liste � prendre en consid�ration.
	 */
	public static void afficherPieces(Piece[] pieces, int nombre) {

	}	
	
	/**
	 * Affiche � l'�cran la main d'un joueur.
	 * @param joueur Le joueur
	 */
	public static void afficherMain(Joueur joueur) {

	}	
	
	/**
	 * Affiche le contenu de la table de jeu.
	 */
	public static void afficherTable() {
	
	}
}