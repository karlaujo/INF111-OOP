package physique;

/**
 * La classe direction offre une interface pour travailler avec
 * les termes relatifs: HAUT, BAS, GAUCHE, DROITE.
 * 
 * Il s'agit d'un module utilitaire, l'entier est utilisé comme support
 * au codes de directions.
 * 
 * services offerts:
 * - directionOpposee, retourne la direction opposé
 * - directionAPosition, convertie une direction en position
 * - positionRelADirection, une position unitaire en direction
 * - obtenirDirAlea, permet d'obtenir une direction aléatoire
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import java.util.Random;

public class Direction {
	
	// définition des constantes publiques, utilisé pour les directions
	// toutes de type entier
	public static final int HAUT = 0;
	public static final int BAS = 1;
	public static final int GAUCHE = 2;
	public static final int DROITE = 3;

	public static final int NB_DIRECTIONS = 4;
	
	// générateur de nombre pseudo-aléatoire.
	private static Random rand = new Random(System.currentTimeMillis());
	
	/**
	 * Retourne la direction opposé
	 * @param direction, direction pour laquelle on veut l'opposé
	 * @return (entier), valeur de la direction opposé
	 */
	public static int directionOpposee(int direction){
		
		if(direction == HAUT){
			return BAS;
		}else if(direction == BAS){
			return HAUT;
		}else if(direction == GAUCHE){
			return DROITE;
		}else{
			return GAUCHE;
		}
	}

	/**
	 * Convertir une direction en position
	 * @param direction, direction pour laquelle on veut la position
	 * @return (Position), valeur de la position unitaire correspondante
	 */
	public static Position directionAPosition(int direction){

		if(direction == HAUT){
			return new Position(-1,0);
		}else if(direction == BAS){
			return new Position(1,0);
		}else if(direction == GAUCHE){
			return new Position(0,-1);
		}else{
			return new Position(0,1);
		}
	}

	/**
	 * Convertir une position unitaire en direction
	 * @param pos, position à convertir, dont une seule coordonnée est égal à abs(1)
	 * @return (int), valeur de la direction correspondante
	 */
	public static int positionRelADirection(Position pos){

		if(pos.getI() == -1){
			return HAUT;
		}else if(pos.getI() == 1){
			return BAS;
		}else if(pos.getJ() == -1){
			return GAUCHE;
		}else if(pos.getJ() == 1){
			return DROITE;
		}else{
			return -1;
		}
	}

	/**
	 * retourne une direction aléatoire
	 * @return (int), valeur de la direction choisit
	 */
	public static int obtenirDirAlea(){
		return rand.nextInt(NB_DIRECTIONS);
	}
}
