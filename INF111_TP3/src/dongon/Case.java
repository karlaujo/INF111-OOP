package dongon;

/**
 * Une case du labyrinthe. Chaque case consiste en une position dans le
 * labyrinthe.
 * 
 * Les cases adjacentes ne sont pas nécessairement connecté. Si elles sont
 * connecté, alors la case contient une référence sur sa case voisine sinon
 * la référence est nulle.
 * 
 * Lors du développement du labyrinthe, le boolean developpe, determine
 * si la case a été évalué par l'algorithme.
 * 
 * Une case peut-être decouverte(visible), ou non-decouverte.
 * Une case par niveau est choisit pour être la fin du niveau.
 * 
 * Plusieurs services sont définis:
 * 	- Constructeur par paramètre, qui reçoit la position
 *  - getPos, informatrice qui retourne la position
 *  - get/setDeveloppe, info/mutatrice pour le champ developpe
 *  - get/setVoisin, info/mutatrice pour accéder aux cases voisines, si connectés
 *  - get/setFin, info/mutatrice pour la dernière case du niveau
 *  - get/setDecouverte, info/mutatrice indiquer si le héro à découvert cette cases
 *  - toString, pour afficher les infos sur la case
 * 
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import physique.Direction;
import physique.Position;
import java.util.Random;

import personnage.AbstractPersonnage;

public class Case {
	
	// générateur pseudo-aléatoire
	private Random rand = new Random();

	// contient la positiondes la classes
	private Position pos = null;
	
	// indique que la case a été découverte par le héro
	private boolean decouverte = false;

	// indique si la case a été évalué par l'algorithme de labyrinthe
	private boolean developpe = false;
	
	// références sur les voisins
	private Case[] voisins = new Case[4];
	
	// indique que la case est la dernière du tableau
	private boolean estFin = false;

	/**
	 * Constructeur par paramètre
	 * 
	 * @param pos, position de la case
	 */
	public Case(Position pos){
		this.pos = pos;
	}

	/**
	 * informatrice, retourne la position de la case
	 * @return position de la case (par copie)
	 */
	public Position getPos(){
		return new Position(pos);
	}

	/**
	 * mutatrice, indique que la case a été développé
	 */
	public void setDeveloppe(){
		this.developpe = true;
	}

	/**
	 * informatrice, indique si la case a été développé
	 * @return boolean, true si la case a été développé, false, sinon.
	 */
	public boolean getDeveloppe(){
		return this.developpe;
	}

	/**
	 * mutatrice, permet d'assigner un voisin à la case
	 * 
	 * @param direction(int), direction du voisin
	 * @param caseVoisine(Case), référence à la case voisine
	 */
	public void setVoisin(int direction, Case caseVoisine){
		this.voisins[direction] = caseVoisine;
	}

	/**
	 * informatrice, permet d'obtenir une référence au voisin dans la direction
	 *               donnée
	 * @param direction(int), direction du voisin demandé
	 * @return Case, reference à la case voisine ou null si pas connecté
	 */
	public Case getVoisin(int direction){
		return this.voisins[direction];
	}
	

	/**
	 * mutatrice, assigne la case comme étant la fin du niveau
	 */
	public void setFin(){
		this.estFin = true;
	}

	/**
	 * informatrice, indique si la case est la fin du niveau
	 * @return true, si c'est la fin, false sinon
	 */
	public boolean getFin(){
		return this.estFin;
	}

	/**
	 * mutatrice, permet d'indiquer si la case doit être visible ou non
	 * @param etat(boolean), true si case est visible
	 */
	public void setDecouverte(boolean etat){
		this.decouverte = etat;
	}

	/**
	 * informatrice, indique si la case est visible
	 * @return true, si case est visible, false sinon
	 */
	public boolean getDecouverte(){
		return this.decouverte;
	}

	/**
	 * retourne une représentation de la case comme un chaîne de caractère
	 * @return String
	 */
	public String toString(){
		return "i: " + pos.getI() + "j: " + pos.getJ();
	}
	
}
