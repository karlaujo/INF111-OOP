package physique;

/**
 * La classe position permet de garde une position de labyrinthe en mémoire.
 * La classe est également utilisé pour encode une position en pixel à l'écran.
 * 
 * La position est définit dans un plan cartésien et utilise la convention I, J
 * 
 * services offerts:
 * - contructeur par paramètre
 * - contructeur par copie
 * - accesseur/mutateur
 * - additionner, soustraire, multiplier
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

public class Position {
	private int i;
	private int j;
	
	public Position(){}

	public Position(int i, int j){
		this.i = i;
		this.j = j;
	}

	public Position(Position position){
		this.i = position.i;
		this.j = position.j;
	}
	
	public void setI(int i){
		this.i = i;
	}

	public void setJ(int j){
		this.j = j;
	}
	
	public int getI(){
		return i;
	}

	public int getJ(){
		return j;
	}
	
	public void additionnerPos(Position pos){
		i += pos.i;
		j += pos.j;
	}
	
	public void soustrairePos(Position pos){
		i -= pos.i;
		j -= pos.j;
	}

	public void multiplierPos(double multiI,double multiJ){
		i *= multiI;
		j *= multiJ;
	}
	
	public boolean equals(Position pos){
		if(i==pos.i && j==pos.j){
			return true;
		}
		return false;
	}
}
