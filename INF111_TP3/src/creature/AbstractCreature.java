package creature;

/**
 * Définition d'une Creature Abstraite. Les créatures
 * Évolue dans le labyrinthe et sont des énemis de notre héro.
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import personnage.AbstractPersonnage;
import physique.Position;

public abstract class AbstractCreature extends AbstractPersonnage {


	/**
	 * Constructeur par paramètre
	 * 
	 * @param pos, position de la créature
	 */
	public AbstractCreature(Position pos){
		super(pos);
	}
	
	public String getType() {
		return null;
	}
	
	public String getClasse() {
		return null;
	}
}
