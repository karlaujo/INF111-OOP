package equipements;

/**
 * Définition d'un Casque, un type d'équipement.
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP3
 */
import physique.Position;

public class Casque extends AbstractEquipement {

	private static final int MIN_EFFET = 1;
	private static final int MAX_EFFET = 10;

	/**
	 * Constructeur
	 * @param pos, position de l'équipement
	 */
	public Casque(Position pos) {
		super(pos, rand.nextInt((MAX_EFFET-MIN_EFFET))+MIN_EFFET);
	}

	/**
	 * méthode d'affichage
	 */
	public String toString(){
		return "Casque +" + valeur;
	}
}
