package personnage;

/**
 * Classe abstraite d'un personnage d'un jeu
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import physique.Direction;
import physique.Position;

import java.util.Observable;

import dongon.AbstractObjet;
import dongon.Case;
import observer.MonObservable;

public abstract class AbstractPersonnage extends AbstractObjet {

	
	protected int armure=0;
	protected int force=10;
	protected int bonusAttaque = 0;
	protected int pointDeVie=100;
	protected int pointDeVieMax=100;

	/**
	 * constructeur
	 * @param pos, position I,J dans le labyrinthe
	 */
	
	public AbstractPersonnage(){}
	
	public AbstractPersonnage(Position pos){
		this.pos = pos;
	}
	
	/**
	 * méthode pour déplacer un personnage
	 * @param direction, direction du mouvement
	 */
	public void seDeplacer(int direction){
		
		// obtient une référence sur le voisin
		Case voisin = caseCourante.getVoisin(direction);
		
		// vérifie que le voisin est valide (ne l'est pas quand il y a un mur)
		if(voisin != null){
			
			// met à jour la position
			caseCourante = voisin;
			pos.additionnerPos(Direction.directionAPosition(direction));
			this.avertirLesObservers();
		}
	}

	public int getArmure() {
		return armure;
	}

	public int getForce() {
		return force + bonusAttaque;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}
	
	public int getPointDeVieMax() {
		return pointDeVieMax;
	}
	
	public void recoitCoup(int forceCoup) {
		forceCoup -= armure;
		
		if(forceCoup > 0){
			pointDeVie -= forceCoup;
		}
	}

	public boolean estVivant() {
		return (pointDeVie>0);
	}
	
}
