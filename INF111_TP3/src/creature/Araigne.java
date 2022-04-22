package creature;

/**
 * Définition d'une araigné, dérivé de abstractCreature.
 * L'araigné est une créature qui évolue dans le donjon.
 * Pour l'instant, seul de déplacement est surdéfinit.
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import physique.Position;

public class Araigne extends AbstractCreature{

	/**
	 * Constructeur par paramètre
	 * 
	 * @param pos, position de la créature
	 */
	public Araigne(Position pos) {
		super(pos);

		armure=0;
		force=5;
		pointDeVie=25;
		pointDeVieMax=25;
	}
	
	/**
	 * Surdéfinition de la méthode de déplacement
	 * Une araigné peut faire un bond de 2 cases.
	 * 
	 * @param direction, la direction du bond
	 */
	public void seDeplacer(int direction){
		super.seDeplacer(direction);
		super.seDeplacer(direction);
	}
	
	@Override
	public String getType() {
		return "spider";
	}
	
	@Override
	public String getClasse() {
		return "Araigne";
	}

}
