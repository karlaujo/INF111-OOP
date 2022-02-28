package com.moumene.rummy;

import java.util.Arrays;
import java.util.Scanner;

import com.moumene.util.Util;

/**
 * @author Equipe 12: Victor, Karl-Eric et Paul
 *
 */
public class Rummy_Alpha {

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

	/**
	 * Donne le tour au joueur inactif, qui devient le joueur actif
	 */
	public static void passerAuSuivant() {
		if(joueurActif == joueur1){
			joueurActif = joueur2;
		}
		else
			joueurActif = joueur1;
	}
	
	/**
	 * Fait jouer un tour au joueur.
	 * @param joueur: joueur actif
	 */
	public static void faireJouer(Joueur joueur) {
		System.out.println("Voici le tour du joueur " + joueur.nom);
		System.out.println("La Table:");
		afficherTable();
		System.out.println("Votre main:");
		afficherMain(joueur);
		boolean played = false;
		String toPlay;
		System.out.println("Choisissez les pieces que vous voulez jouer\nSi vous ne voulez rien jouer, entrez q");
		toPlay = clavier.next();
		while(!toPlay.equals("q")){
			if (saisieCorrecte(toPlay)){
				Piece[] pieces = extrairePieces(toPlay);
				if (valide(joueur, pieces)){
					if (estUneCombinaison(pieces)){
						System.out.println("Votre choix est une combinaison\nEntrez:\n+ pour commencer une nouvelle combinaison\nle numero d'une combinaison existante pour l'ajouter a celle ci\nq pour annuler");
						String ans = clavier.next();
						while (!ans.equals("+") && !ans.equals("q") && !ans.matches("\\d+")){
							System.out.println("Votre choix n'etait pas valide\nEntrez:\n+ pour commencer une nouvelle combinaison\nle numero d'une combinaison existante pour l'ajouter a celle ci\nq pour annuler");
							ans = clavier.next();
						}
						if (ans.equals("+")){
							if(!ajouterNouvelleCombinaisonALaTable(pieces)){
								System.out.println("Les pieces n'ont pas reussi a etre ajoute a la table");
							}
							else{
								played = true;
								enleverPieces(joueurActif, pieces);
								System.out.println("La Table:");
								afficherTable();
								System.out.println("Votre main:");
								afficherMain(joueur);
							}
						}
						else if(ans.matches("\\d+")){
							int combi = Integer.parseInt(ans);
							if (ajouterPiecesALaCombinaison(pieces, combi)){
								played = true;
								enleverPieces(joueurActif, pieces);
								System.out.println("La Table:");
								afficherTable();
								System.out.println("Votre main:");
								afficherMain(joueur);
							}
							else{
								System.out.println("Les pieces n'ont pas reussi a etre ajoute a cette combinaison");
							}
						}
					}
					else{
						System.out.println("Votre choix n'est pas une combinaison\nEntrez:\nle numero d'une combinaison existante pour l'ajouter a celle ci\nq pour annuler");
						String ans = clavier.next();
						while (!ans.equals("q") && !ans.matches("\\d+")){
							System.out.println("Votre choix n'etait pas valide\nEntrez:\nle numero d'une combinaison existante pour l'ajouter a celle ci\nq pour annuler");
							ans = clavier.next();
						}
						if(ans.matches("\\d+")){
							int combi = Integer.parseInt(ans);
							if (ajouterPiecesALaCombinaison(pieces, combi)){
								played = true;
								enleverPieces(joueurActif, pieces);
								System.out.println("La Table:");
								afficherTable();
								System.out.println("Votre main:");
								afficherMain(joueur);
							}
							else{
								System.out.println("Les pieces n'ont pas reussi a etre ajoute a cette combinaison");
							}
						}
					}
				}
				else {
					System.out.println("Vous ne possedez pas les pieces que vous avez entrez");
				}
			}
			else{
				System.out.println("Votre entree n'a pu etre decortique en pieces");
			}
			System.out.println("Saisissez a nouveau les pieces que vous voulez jouer\nSi vous ne voulez rien jouer, faites q");
			toPlay = clavier.next();
		}
		if (!played){
			System.out.println("Choisissez une piece qui sera echange pour une piece aleatoire de la pioche");
			toPlay = clavier.next();
			while(!played){
				if(saisieCorrecte(toPlay)){
					Piece[] pieces = extrairePieces(toPlay);
					if (pieces[1] != null){
						System.out.println("Vous devez choisir seulement une piece");
					}
					else if (valide(joueur,pieces)){
						Piece p = echanger(pioche, pieces[0]);
						System.out.println("La piece que vous avez recu est le " + toString(p));
						enleverPieces(joueurActif, pieces);
						ajouterPiece(joueur, p);
						played = true;
					}
					else{
						System.out.println("Vous devez choisir une piece dans votre main");
					}
				}
				else {
					System.out.println("Votre saisie n'a pu etre traduite en pieces");
				}
				if (!played){
					System.out.println("Veuillez entrer a nouveau une piece qui sera echange pour une piece aleatoire de la pioche");
					toPlay = clavier.next();
				}
			}
		}
		System.out.println("La Table:");
		afficherTable();
		System.out.println("Votre main:");
		afficherMain(joueur);
		System.out.println("Votre tour a fini");
	}

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
		Piece[] ps = new Piece[Constantes.LONGUEUR_MAX_COMBINAISON];
		String[] lists = saisie.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		int i = 0, j = 0;
		while (i < lists.length){
			Piece p = new Piece();
			p.numero = Integer.parseInt(lists[i]);
			p.couleur = Character.toUpperCase(lists[i + 1].charAt(0));
			ps[j] = p;
			j++;
			i += 2;
		}
		return ps;
	}
	
	/**
	 * Ajoute une pi�ce � la main d'un joueur.
	 * @param joueur le joueur qui recevra la pi�ce dans sa main
	 * @param piece la pi�ce � ajouter
	 * @return true si la pi�ce a �t� ajout�e, false si la pi�ce n'a pas �t�
	 * 		   ajout�e car la main est pleine.	
	 */
	public static boolean ajouterPiece(Joueur joueur, Piece piece) {
		int i, y = 0;
		boolean ajoutReussie = false;
		// On veut ajouter la pi�ce dans la main du joueur � la fin
		while (y != 1) {
			for (i = 0; (i < joueur.manne.length) && (!ajoutReussie); i++) {
				if (joueur.manne[i] == null) {
					joueur.manne[i] = piece;
					ajoutReussie = true;
					y=1;
				}
			}
		}
		return ajoutReussie;
	}

		
	/**
	 * Ajouter une liste de pi�ces � une combinaison de la table de jeu.
	 * @param pieces tableau contenant les pi�ces � ajouter
	 * @param numeroCombinaison le num�ro de la combinaison sur la table �
	 * 							laquelle les pi�ces vont �tre ajout�es. La 
	 * 							premi�re combinaison porte le num�ro 1.
	 * @return true si toutes le pi�ces ont �t� ajout�es, false sinon.	
	 */
	public static boolean ajouterPiecesALaCombinaison(Piece[] pieces, int numeroCombinaison) {
		int i = 0, j = 0, y = 0;
		boolean testAjout = true;
		while (y != 1) {
			for (Piece p : tableDeJeu[numeroCombinaison]) {
				if (p == null) {
					i += 1;
				}
			}
			for (Piece p : pieces) {
				if (p != null)
					j += 1;
			}

			if (j >= i) {
				testAjout = false;
				y=1;
			}

			int k = 0;
			Piece[] test_combinaison = new Piece[Constantes.LONGUEUR_MAX_COMBINAISON];
			for (Piece p : tableDeJeu[numeroCombinaison]) {
				if (p != null) {
					test_combinaison[k] = p;
					k += 1;
				}
			}
			for (Piece p : pieces) {
				if (p != null) {
					test_combinaison[k] = p;
					k += 1;
				}
			}
			if (!estUneCombinaison(test_combinaison)) {
				testAjout = false;
				y = 1;
			}
			i = 0;
			j = 0;
			for (Piece p : tableDeJeu[numeroCombinaison]) {
				if (p == null) {
					tableDeJeu[numeroCombinaison][i] = pieces[j];
					j++;
				}
				i++;
			}
		}

		rearrangerMain(tableDeJeu[numeroCombinaison]);
		return testAjout;
	}

	/**
	 * Ajouter une liste de pi�ces dans une nouvelle combinaison de la table de 
	 * jeu.
	 * @param pieces tableau contenant les pi�ces composant la combinaison.
	 * @return true si la nouvelle combinaison a �t� ajout�e, false sinon.	
	 */
	public static boolean ajouterNouvelleCombinaisonALaTable(Piece[] pieces) {
		int i = 0, y = 0;
		boolean testAjout = false;
		while (y != 1) {
			for (Piece[] p : tableDeJeu) {
				if (p[0] == null) {
					int j = 0;
					for (Piece p2 : pieces) {
						tableDeJeu[i][j] = p2;
						j++;
					}
					rearrangerMain(tableDeJeu[i]);
					testAjout = true;
					y = 1;
				}
				i++;
			}
		}
		return testAjout;
	}

	/**
	 * V�rifie si la main d'un joueur est vide ou non.
	 * @param joueur le joueur
	 * @return true si la main du joueur est vide, false sinon.
	 */
	public static boolean mainVide(Joueur joueur) {
		boolean mainVide = true;
		int y = 0;
		while (y != 1)
		for (int i = 0; (i < Constantes.LONGUEUR_MAX_MAIN) && (mainVide); i++) {
			if (joueur.manne[i] != null)
			{
				mainVide = false;
				y=1;
			}
		}
		return mainVide;
	}
	
	/**
	 * V�rifie si un caract�re correspond � une couleur du jeu.
	 * @param caractere : couleur a verifier
	 * @return true si le caract�re est une couleur valide, false sinon.
	 */
	public static boolean estUneCouleurValide(char caractere) {
		boolean couleurValide = false;
		int y = 0;
		// On convertit le caractere en majuscule
		caractere = Character.toUpperCase(caractere);
		while (y != 1) {
			for (int i = 0; (i < Constantes.COULEURS.length) && (!couleurValide); i++) {
				if (caractere == Constantes.COULEURS[i]) {
					couleurValide = true;
					y = 1;
				}
			}
		}
		return couleurValide;
	}

	/**
	 * V�rifie si une chaine de caract�res d�crit correctement une liste de
	 * pi�ces.
	 * @param chaine la chaine de caract�res � v�rifier
	 * @return true, si la chaine est une description correcte d'une liste de
	 * 			pi�ces, false sinon.
	 */
	public static boolean saisieCorrecte(String chaine) {
		boolean testSaisie = true;
		String[] lists = chaine.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		int i = 0, y = 0;
		while (y != 1) {
			if (lists.length % 2 == 1) {
				testSaisie = false;
				y = 1;
			}
			while (i < lists.length) {
				int num = Integer.parseInt(lists[i]);
				if (!((num >= 1 && num <= 13) || num == 25)) {
					testSaisie = false;
					y = 1;
				}
				if (lists[i + 1].length() != 1) {
					testSaisie = false;
					y = 1;
				}
				char color = lists[i + 1].charAt(0);
				if (!(estUneCouleurValide(color) || Character.toUpperCase(color) == Constantes.NOIR)) {
					testSaisie = false;
					y = 1;
				}
				if ((num == 25 && Character.toUpperCase(color) != Constantes.NOIR) || (num != 25 && Character.toUpperCase(color) == Constantes.NOIR)) {
					testSaisie = false;
					y = 1;
				}
				i += 2;
			}
		}
		return testSaisie;
	}
	
	/**
	 * V�rifie si une liste de pi�ces fait partie de la main d'un joueur.
	 * @param joueur le joueur
	 * @param pieces la liste des pi�ces
	 * @return true si toutes les pi�ces de la liste sont dans la main du 
	 * 		   joueur, false sinon.
	 */
	public static boolean valide(Joueur joueur, Piece[] pieces) {
		// On verifie si il y a une seule piece dans la la liste des pieces qui n'existe pas
		// la main de joueur, il faut qu'on sort de la boucle et retourne false.
		boolean existe = true;
		// Parcourir la liste des pieces.
		for (int i = 0; (i < pieces.length) && (pieces[i] != null) && (existe); i++) {
			// On verifie si la piece existe dans la main de joueur.
			// Il faut parcourir la liste de pieces dans la main de joueur actif.
			for ( int j = 0; (j < joueur.manne.length)  && (joueur.manne[j] != null) ; j++){
				if (pieces[i].numero != joueur.manne[j].numero) {
					existe = false;
				}
				if (pieces[i].couleur != joueur.manne[j].couleur) {
					existe = false;
				}
			}
		}
		return existe;
	}

	/**
	 * Enleve les pieces jouees de la main d'un joueur.
	 * @param joueur le joueur
	 * @param pieces la liste des pi�ces
	 */
	public static void enleverPieces(Joueur joueur, Piece[] pieces) {
		int y = 0;
		for (Piece p : pieces) {
			if (p != null) {
				int i = 0;
				while (i < Constantes.LONGUEUR_MAX_MAIN) {
					if (joueur.manne[i] != null) {
						while (y != 1) {
							if (joueur.manne[i].couleur == p.couleur && joueur.manne[i].numero == p.numero) {
								joueur.manne[i] = null;
								y = 1;
							}
						}
						i++;
					}
				}
			}
		}
	}
	
	/**
	 * V�rifie si une liste de pi�ces constitue une combinaison (suite ou s�rie)
	 * @param pieces la liste des pi�ces
	 * @return true si la liste est une combinaison, false sinon.
	 */
	public static boolean estUneCombinaison(Piece[] pieces) {
		int i = 0;
		boolean suite = true, series = true;
		for (Piece p:pieces){
			if (p != null)
				i += 1;
		}
		int[] num = new int[i];
		char[] color = new char[i];
		i = 0;
		for (Piece p: pieces){
			if (p != null){
				num[i] = getValeur(p);
				color[i] = p.couleur;
				i += 1;
			}
		}
		Arrays.sort(num);
		if (i < 3){
			series = false;
			suite = false;
		}

		int y=0;
		int num_joker = 0;
		int num_joker_var;

		for (int k:num){
			while (y != 1) {
				if (k != num[0] && k != 25) {
					series = false;
					y = 1;
				}
			}
		}

		y=0;
		for (char c : color) {
			while (y != 1) {
				if (c != color[0] && c != Constantes.NOIR) {
					suite = false;
					y = 1;
				}
			}
		}

		y=0;
		if (i > 4)
			series = false;
		else {
			for (int compt1 = 0; compt1 < i; compt1++)
				for (int compt2 = compt1 + 1; compt2 < i; compt2++)
					while (y != 1) {
						if (compt2 != compt1 && color[compt2] == color[compt1] && color[compt1] != Constantes.NOIR) {
							series = false;
							y = 1;
						}
					}
		}
		for (int k:num){
			if (k == 25){
				num_joker += 1;
			}
		}

		y=0;
		int[] num_no_joker = new int[i-num_joker];
		System.arraycopy(num, 0, num_no_joker, 0, i - num_joker);
		num_joker_var = num_joker;
		for (int compt1 = 1;compt1 < i - num_joker;compt1++){

				if (num_no_joker[compt1] != (num_no_joker[compt1 - 1] + 1)) {
					int diff = num_no_joker[compt1] - (num_no_joker[compt1 - 1] + 1);
					while (y != 1) {
					if (diff >= 0 && num_joker_var > 0 && num_joker_var >= diff) {
						num_joker_var -= diff;
					} else {
						suite = false;
						y = 1;
					}
				}
			}
		}
		return suite || series;
	}


	/**
	 * Retire des pi�ces d'une pioche et les place dans la main d'un joueur.
	 * @param pioche la pioche
	 * @param joueur le joueur
	 * @param nombrePieces le nombre de pi�ces � extraire de la pioche
	 */
	public static void distribuerMain(Pioche pioche, Joueur joueur, int nombrePieces) {
		int i = 0, j = 0, y = 0;
		while (i < nombrePieces && y!=1){
			i++;
			if (j < Constantes.LONGUEUR_MAX_MAIN) {
				if (!ajouterPiece(joueur, piocher(pioche))) {
					System.out.println("On a pas reussi a ajouter plus de pieces dans la main du joueur");
					y=1;
				}
				j++;
			}
		}

		return;
	}
	
	/**
	 * Extrait une pi�ce d'une pioche. Le choix de la pi�ce d�pend de
	 * l'impl�mentation.
	 * @param pioche la pioche
	 * @return la pi�ce extraite
	 */
	public static Piece piocher(Pioche pioche) {
		melangerPioche(pioche);
		int i = 0, x=0, y=0;
		Piece p;
		while (i < pioche.pieces.length && y !=1){
			if (pioche.pieces[i] == null) {
				x = i;
				y=1;
			}
			i ++;
		}

		if (pioche.pieces[x] == null) {
			p = pioche.pieces[x-1];
			pioche.pieces[x-1] = null;
		}

		else {
			p = pioche.pieces[(pioche.pieces.length) - 1];
			pioche.pieces[pioche.pieces.length - 1] = null;
		}

		return p;
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
		melangerPioche(pioche);
		int i = 0, x=0, y = 0;
		Piece p;
		while (i < pioche.pieces.length && y != 1){
			if (pioche.pieces[i] == null){
				x = i;
				y = 1;
			}
			i ++;
		}

		if (pioche.pieces[x] == null){
			p = pioche.pieces[x-1];
			pioche.pieces[x-1] = piece;
		}
		else {
			p = pioche.pieces[(pioche.pieces.length) - 1];
			pioche.pieces[pioche.pieces.length - 1] = piece;
		}


		return p;
	}

	/**
	 * G�n�re les 106 pi�ces du jeu et les place dans une pioche.
	 * @param pioche La pioche o� les pi�ces vont �tre plac�es.
	 */
	//Place les 106 pieces dans la pioche (incluant les 2 jokers) :
	public static void initialiserPioche(Pioche pioche) {
		Rummy_Alpha.vider(pioche);
		int count, r=0, v=0, b=0, j=0, n=0;
		boolean test = true;
		while (test) {

			count=1;
			while (count<=Constantes.LONGUEUR_MAX_COMBINAISON) {

				Piece p = new Piece();
				p.numero = count;

				if(r<26) {
					p.couleur = Constantes.ROUGE;
					r++;
				} else if (v<26) {
					p.couleur = Constantes.VERT;
					v++;
				} else if (b<26) {
					p.couleur = Constantes.BLEU;
					b++;
				} else if (j<26) {
					p.couleur = Constantes.JAUNE;
					j++;
				} else if (n<2) {
					p.couleur = Constantes.NOIR;
					p.numero = Constantes.VINGT_CINQ;
					n++;
				}
				test = ajouterPiece(pioche, p);
				count++;
			}
		}
	}
	
	/**
	 * Vide une pioche et y retirant toutes les pi�ces.
	 * @param pioche La pioche � vider
	 */
	public static void vider(Pioche pioche) {
		Arrays.fill(pioche.pieces, null);
	}
	
	/**
	 * Ajoute une pi�ce � une pioche.
	 * @param pioche La pioche o� la pi�ce va �tre ajout�e
	 * @param piece La pi�ce � ajouter
	 * @return true si l'ajout a r�ussi, false sinon (faute de place)
	 */
	public static boolean ajouterPiece(Pioche pioche, Piece piece) {
		int i = 0, j = 0;
		boolean testAjout = false;
		while (i < pioche.pieces.length && j != 1){
			if (pioche.pieces[i] == null){
				pioche.pieces[i] = piece;
				testAjout = true;
				j=1;
			}
			i++;
		}
		return testAjout;
	}

	/**
	 * M�lange al�atoirement toutes les pieces de la pioche.
	 * @param pioche La pioche
	 */
	public static void melangerPioche(Pioche pioche) {
		int i, j = 0;
		Piece temp;
		for (i = 0; i < pioche.pieces.length; i++){
			if (!(pioche.pieces[i] == null)){
				pioche.pieces[j] = pioche.pieces[i];
				if (j != i)
					pioche.pieces[i] = null;
				j ++;
			}
		}
		int random;
		for (i=j - 1; i > 0;i--) {
			random = Util.getNbAleatoireEntre(0, i);
			temp = pioche.pieces[i];
			pioche.pieces[i] = pioche.pieces[random];
			pioche.pieces[random] = temp;
		}
	}


	/**
	 * Affiche � l'�cran les premi�res pi�ces d'une liste.
	 * @param pieces La liste des pi�ces
	 * @param nombre Le nombre de pi�ces de la liste � prendre en consid�ration.
	 */
	public static void afficherPieces(Piece[] pieces, int nombre) {
		int i = 0;
		while (i < nombre && pieces[i] != null){
			System.out.print(toString(pieces[i]));
			i++;
		}
		System.out.println();
	}	
	
	/**
	 * Affiche � l'�cran la main d'un joueur.
	 * @param joueur Le joueur
	 */
	public static void afficherMain(Joueur joueur) {
		rearrangerMain(joueur.manne);
		afficherPieces(joueur.manne, Constantes.LONGUEUR_MAX_MAIN);
	}

	/**
	 * Rearrange la main d'un joueur.
	 * @param manne Les pieces
	 */
	public static void rearrangerMain(Piece[] manne) {
		int n = manne.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (manne[j] == null && manne[j+1] != null){
					Piece temp = manne[j];
					manne[j] = manne[j+1];
					manne[j+1] = temp;
				}
				else if (manne[j] != null && manne[j+1] != null) {
					if (manne[j].numero > manne[j + 1].numero) {
						Piece temp = manne[j];
						manne[j] = manne[j + 1];
						manne[j + 1] = temp;
					}
				}
	}

	/**
	 * Affiche le contenu de la table de jeu.
	 */
	public static void afficherTable() {
		int i = 0;
		for (Piece[] p:tableDeJeu){
			if (p[0] != null) {
				System.out.print("Combinaison " + i + ":");
				afficherPieces(p, Constantes.LONGUEUR_MAX_COMBINAISON);
				i++;
			}
		}
	}
}