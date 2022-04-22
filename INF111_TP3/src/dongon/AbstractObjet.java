package dongon;


/**
 * Définition d'un objet du labyrinthe.
 * L'objet peut-être:
 * 	un personnage, une pièce d'équipement, etc
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP3
 */

import observer.MonObservable;
import physique.Position;

public abstract class AbstractObjet extends MonObservable{

	// propriétés d'un personnage
	protected Position pos;
	protected Case caseCourante;
	

	public void setCase(Case caseCourante){
		this.caseCourante = caseCourante;
	}	

	public Case getCase(){
		return this.caseCourante;
	}	

	public Position getPos(){
		return new Position(pos);
	}	

	public void setPos(Position pos){
		this.pos = pos;
	}	


	
}
