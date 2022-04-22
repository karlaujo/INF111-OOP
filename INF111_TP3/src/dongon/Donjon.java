package dongon;
/**
 * Le donjon est le tableau 2D qui contient les cases du labyrinthe.
 * Le donjon offre les méthodes d'initialisation et d'accès aux cases
 * 
 * Les services offerts:
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */


import physique.Direction;
import physique.Position;
import pile.PileSChainee;

import java.util.Random;


public class Donjon {

	private final int NB_VOISINS = 4;
	
	private Case depart;
	private Case fin;
	private Case[][] cases = null;
	private Random rand = new Random(System.currentTimeMillis());
	

	/**
	 * Constructeur par défaut, initialise tous les éléments
	 * du donjon: tableau de case, labyrinthe
	 * 
	 * @param pos, position de la case
	 */
	public Donjon(){

		int i,j;
		
		// crée le tableau
		Configuration config = Configuration.getInstance();
		this.cases = new Case[(int)config.getConfig(Configuration.NB_LIGNES)][(int)config.getConfig(Configuration.NB_COLONNES)];

		// ajoute des cases au donjon
		for(i=0;i<this.cases.length;i++){
			for(j=0;j<this.cases[i].length;j++){
				this.cases[i][j] = new Case(new Position(i,j));
			}
		}

		// choisit une case départ aléatoire
		i = rand.nextInt(this.cases.length);
		j = rand.nextInt(this.cases[0].length);
		depart = this.cases[i][j];
		
		// produit le labyrinthe
		this.produireLabyrinthe();
		
		// assigne la fin
		this.fin.setFin();
		
	}

	/**
	 * Informatrice 
	 * @return case du départ
	 */
	public Case getDepart(){
		return depart;
	}

	/**
	 * Informatrice 
	 * @return case de la fin
	 */
	public Case getFin(){
		return fin;
	}


	/*
	 * Informatrice, obtient une référence au tableau de case
	 */
	public Case[][] getCases(){
		return cases;
	}
	
	/**
	 * Utilitaire 
	 * @return une position I,J choisit aléatoirement
	 */
	public Position getPositionAlea(){
		return new Position(rand.nextInt(this.cases.length), rand.nextInt(this.cases[0].length));
	}

	/**
	 * cette méthode crée le labyrinthe dans le tableau. 
	 * @return une position I,J choisit aléatoirement
	 */
	private void produireLabyrinthe(){
		
		// développe le labyrinthe a partir de la case départ
		PileSChainee pile = new PileSChainee();
		
		// commence à partir de la première position
		pile.empiler(depart);
		
		//roule tant que la pile n'est pas vide
		while(!pile.estVide()){
			
			// prend l'élément du haut de la pile
			Case caseCourante = (Case)pile.regarder();
			
			// obtient position courante
			Position posCourante = caseCourante.getPos();
			// indique qu'il est développé
			caseCourante.setDeveloppe();
			
			// vérifie s'il y a un voisin non-développé
			if(getNbVoisinsNonDeveloppe(posCourante)>0){

				// choisit une case non développé voisine au hasard
				Case caseVoisine = getVoisinLibreAlea(posCourante);
				
				// obtient la position du voisin
				Position positionVoisin = caseVoisine.getPos();

				// calcul la direction du et vers le voisin
				positionVoisin.soustrairePos(posCourante);
				int direction = Direction.positionRelADirection(positionVoisin);
				
				// ajoute à la case, comme voisin réciproque
				caseCourante.setVoisin(direction, caseVoisine);
				caseVoisine.setVoisin(Direction.directionOpposee(direction), caseCourante);
				
				// ajoute le voisin à la pile
				pile.empiler(caseVoisine);
				this.fin = (Case)pile.regarder();
			}else{
				
				// cul-de-sac, dépile et essaye à nouveau
				pile.depiler();
			}
		}
	}

	/**
	 * retourne le nombre de voisins non-développé
	 * @param positionReference(Position), position pour laquelle on cherche les voisins
	 * @return (int) nombre de voisins non-développé
	 */
	private int getNbVoisinsNonDeveloppe(Position positionReference){

		int compte = 0;
		
		// itére dans toutes les directions
		for(int i=0;i<Direction.NB_DIRECTIONS;i++){
			
			// pour la direction, calcul la position du voisin
			Position pos = Direction.directionAPosition(i);
			pos.additionnerPos(positionReference);
			
			// s'assure que la position est dans le labyrinthe
			if(pos.getI() >= 0 && pos.getI() < this.cases.length &&
			   pos.getJ() >= 0 && pos.getJ() < this.cases[0].length){
				
					// s'assure que le voisin n'est pas développé
					if(this.cases[pos.getI()][pos.getJ()].getDeveloppe()==false){
						compte++;
				}
			}
		}
		return compte;
	}

	/**
	 * retourne un voisin choisit aléatoirement
	 * @param positionReference(Position), position pour laquelle on cherche les voisins
	 * @return (Case) voisins choisit
	 */
	private Case getVoisinAlea(Position positionReference) {
		
		// tire une position de voisin aléatoire
		Position posVoisin = Direction.directionAPosition(rand.nextInt(4));
		posVoisin.additionnerPos(positionReference);
		
		// valide qu'elle ne tombe pas en dehors de la carte
		while(posVoisin.getI() < 0 || posVoisin.getI()>=this.cases.length ||
		      posVoisin.getJ() < 0 || posVoisin.getJ()>=this.cases[0].length){
			
			posVoisin = Direction.directionAPosition(rand.nextInt(4));	
			posVoisin.additionnerPos(positionReference);
		}

		return this.cases[posVoisin.getI()][posVoisin.getJ()];
	}
	

	/**
	 * retourne un voisin non-développé choisit aléatoirement
	 * @param positionReference(Position), position pour laquelle on cherche les voisins
	 * @return (Case) voisins non-développé choisit
	 * @note considère que le nombre de voisin non-développé est >0 (voir méthode getNbVoisinsNonDeveloppe)
	 */
	private Case getVoisinLibreAlea(Position positionReference) {
		
		Case caseVoisine = getVoisinAlea(positionReference);
		
		while(caseVoisine.getDeveloppe()){
			caseVoisine = getVoisinAlea(positionReference);
		}
		
		return caseVoisine;
	}

}
