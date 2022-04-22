package equipements;

/**
 * Définition d'une Potion, un type d'équipement.
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP3
 */
import physique.Position;

public class Potion extends AbstractEquipement {

	private static final int EFFET = 100;

	/**
	 * Constructeur
	 * @param pos, position de l'équipement
	 */
	public Potion(Position pos) {
		super(pos, EFFET );
	}

	/**
	 * méthode d'affichage
	 */
	public String toString(){
		return "Potion +" + valeur;
	}
}
