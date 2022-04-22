package creature;

/**
 * Définition d'un minotaure, dérivé de abstractCreature.
 * Le minotaure est une créature qui évolue dans le donjon.
 * Pour l'instant, le comportement n'est pas surchargé
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import physique.Position;

public class Minotaure extends AbstractCreature{

	/**
	 * Constructeur par paramètre
	 * 
	 * @param pos, position de la créature
	 */
	public Minotaure(Position pos) {
		super(pos);

		armure=0;
		force=10;
		pointDeVie=50;
		pointDeVieMax=50;
	}
	
	@Override
	public String getType() {
		return "minotaur";
	}
	
	public String getClasse() {
		return "Minotaure";
	}
}
