package joueur;

import java.util.ArrayList;

/**
 * Définition du Joueur.
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import java.util.Vector;

/**
 * Cette classe représente le joueur humain. Elle surcharge le
 * personnage abstrait pour le déplacement et propose une méthode
 * pour mettre à jours la visibilité des cases en fonction de la vision.
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */


import dongon.Case;
import equipements.AbstractEquipement;
import equipements.Arme;
import equipements.Armure;
import equipements.Casque;
import equipements.Potion;
import personnage.AbstractPersonnage;
import physique.Direction;
import physique.Position;
import pile.PileSChainee;

public class Joueur extends AbstractPersonnage {
	
	private final int PROFONDEUR_VISION = 2;
	private boolean mouvement = true;
	
	private Vector<AbstractEquipement> collection;
	private boolean remiseZero = false;
	private Casque casqueEquipe;
	private Armure armureEquipe;
	private Arme armeEquipe;
	
	/**
	 * Construceur par paramètre
	 */
	public Joueur() {
		pointDeVie=100;
		pointDeVieMax=100;
		collection = new Vector<>();
	}

	/**
	 * surcharge de la méthode pour déplacer le joueur dans la direction donnée
	 * @param direction(int), direction du mouvement
	 */
	public void seDeplacer(int direction){
		
		if(mouvement) {
			// se déplacer
			super.seDeplacer(direction);
			
			// mise à jour de la vision
			mettreAJourVision();
		}
	}
	

	/**
	 * surcharge de la méthode pour placer le joueur à sa case de départ
	 * @param caseCourante(Case), case courante
	 */
	public void setCase(Case caseCourante){
		
		// assigne la case
		super.setCase(caseCourante);

		// mise à jour de la vision
		mettreAJourVision();
	}
	
	/**
	 * méthode qui mets à jour la vision
	 */
	private void mettreAJourVision(){
		
		// rend visible la case courante
		super.caseCourante.setDecouverte(true);
		
		// dans toutes les directions
		for(int i=0;i<Direction.NB_DIRECTIONS;i++){
			
			// dévoile les voisins jusqu'à la profondeur de la vision
			Case voisin = super.caseCourante.getVoisin(i);
			for(int j=0;j<PROFONDEUR_VISION;j++){
				if(voisin!=null){
					voisin.setDecouverte(true);
					voisin = voisin.getVoisin(i);
				}
			}
		}
	}

	public void setMouvement(boolean etat){
		this.mouvement = etat;
	}
	

	/**
	 * Remise à zéro du joueur
	 * - remet les points de vie à max
	 * - vide équipement
	 */
	public void remiseAZero(){
		remiseZero = true;
		this.pointDeVie = this.pointDeVieMax;
		collection.removeAll(collection);
		remiserAZero();
		remiseZero = false;
	}
	
	public void ramasserEquipement(AbstractEquipement e) {
		e.setAuSol(false);
		collection.add(e);
	}
	
	public void validerEtatCollection(Vector<AbstractEquipement> equipements) {
		
		for(int i=0;i<equipements.size();i++){
				if(this.getPos().equals(equipements.get(i).getPos())){
					if(equipements.get(i).estAusol())
						ramasserEquipement(equipements.get(i));
				}
			}
	
	}
	
	public Vector<AbstractEquipement> getEquipements(){
		return collection;
	}
	
	public AbstractEquipement getCasqueEquipe() {
		return casqueEquipe;
	}
	
	public AbstractEquipement getArmureEquipe() {
		return armureEquipe;
	}
	
	public AbstractEquipement getArmeEquipe() {
		return armeEquipe;
	}

	public int getNombrePotion(){
		int ans = 0;
		for(AbstractEquipement equip:collection){
			if (equip instanceof Potion)
				ans++;
		}
		return ans;
	}
	
	public void equiper(AbstractEquipement e) {
		//a)identification du type de la piece
		if (e == null){
			this.casqueEquipe = null;
			this.armureEquipe = null;
			this.armeEquipe = null;
		}
		else if (e instanceof Casque) {
			this.casqueEquipe = (Casque) e;
		}
		else if (e instanceof Armure) {
			this.armureEquipe = (Armure) e;
		}
		else if (e instanceof Arme) {
			this.armeEquipe = (Arme) e;
		}
		
		//d)
		this.armure = 0;
		
		//e)
		int tempCorps, tempCasque;
		if (this.armureEquipe == null)
			tempCorps = 0;
		else
			tempCorps = this.armureEquipe.getValeur();
		if (this.casqueEquipe == null)
			tempCasque = 0;
		else
			tempCasque = this.casqueEquipe.getValeur();
		this.armure = tempCasque + tempCorps;
		
		///f)
		this.bonusAttaque = 0;
		
		//g)
		if (this.armeEquipe != null) {
			this.bonusAttaque = this.armeEquipe.getValeur();
		}
	}

	public void utiliserPotion() {
		if (pointDeVie != pointDeVieMax) {
			boolean potionNotUtil = true;
			for (int i = 0; i < collection.size(); i++) {
				if (collection.get(i) instanceof Potion && potionNotUtil) {
					collection.remove(i);
					this.pointDeVie = this.pointDeVieMax;
					potionNotUtil = false;
				}
			}
		}
	}
	
	public void remiserAZero() {
		if (remiseZero) {
			equiper(null);
		}
	}

}
