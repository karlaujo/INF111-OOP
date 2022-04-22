package creature;

/**
 * Définition d'un dragon, dérivé de abstractCreature.
 * Le dragon est une créature qui évolue dans le donjon.
 * Pour l'instant, le comportement n'est pas surchargé
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import physique.Position;

public class Dragon extends AbstractCreature{

	/**
	 * Constructeur par paramètre
	 * 
	 * @param pos, position de la créature
	 */
	public Dragon(Position pos) {
		super(pos);

		armure=5;
		force=15;
		pointDeVie=50;
		pointDeVieMax=50;
	}
	
	@Override
	public String getType() {
		return "dragon";
	}
	
	public String getClasse() {
		return "Dragon";
	}
}
