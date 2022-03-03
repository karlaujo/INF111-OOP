package com.atoudeft.tdas;

/**
 * Implémente une file d'objets de manière dynamique (chainage simple)
 * Stratégie de fonctionnement : FIFO (First In First Out).
 *
 * @author <a href="mailto:Abdelmoumene.Toudeft@etsmtl.ca">A. Toudeft</a>
 * @version 2005
 */
public class FileChaineeSimple{

	 private Noeud premier; 		//référence le premier élément de la file
	 private Noeud dernier; 		//référence le dernier élément de la file
	 
	 private int nbElement; 	//Nombre d'éléments dans la file (utilisé pour
	 					//ne pas avoir à recalculer le nombre d'éléments dans 
	 					//la méthode taille()). Ne pas oublier de l'incrémenter
	 					//lorsqu'on ajoute et le décrémenter lorsqu'on retire.

    /**
     * Constructeur sans paramètre
     * Initialise les références premier et dernier à null et nbElement à 0.
     */
    public FileChaineeSimple(){
    	
    }

    /**
     * Crée une file de la même façon que le premier constructeur.
     * Ce constructeur est laissé là juste pour que les programmes déjà écrits
     * avec le version statique de la file continuent de fonctionner.
     * @param taille La taille voulue pour la file.
     * 
     */
    public FileChaineeSimple(int taille){
    	
    }

    /**
     * Ajoute un élément à la fin de la file.
     * 
     * @param element l'élément à enfiler.
     * @return true si l'opération réussit et false sinon (ce qui n'arrive jamais)
     */
    public boolean enfiler(Object element) {
    	
    	return false;
    }

    /**
     * Retire le premier élément de la file.
     * 
     * @return Le premier élément de la file s'il existe ou null sinon.
     */
    public Object defiler(){
    	
    	return null;
    }

    /**
     * Indique si la file est vide.
     * 
     * @return true si la  file est vide et false sinon.
     */
    public boolean estVide(){
       
    	return nbElement == 0;
    }

	 /**
	  * Vide la file.
	  */
	 public void vider(){
		 while (!estVide())
			 defiler();		 
	 }

    /**
     * Permet de consulter le premier élément de la file sans l'enlever.
     * 
     * @return Le premier élément si la file n'est pas vide et null sinon.
     */
    public Object debut(){

    	return null;
    }


    /**
     * Retourne le nombre d'éléments dans la file.
     * 
     * @return Le nombre d'éléments actuellement dans la file.
     */
    public int taille(){
    	
    	return nbElement;
    }
    
    private class Noeud {
    	public Object donnee;
		public Noeud suivant;
		
		public Noeud(Noeud next, Object data) {
		   this.donnee = data;
		   this.suivant = next;
		}
	}
}
