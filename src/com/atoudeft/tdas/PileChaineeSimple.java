package com.atoudeft.tdas;

/**
 * Implémente une pile d'objets de manière dynamique (chainage simple)
 * Stratégie de fonctionnement : LIFO (Last In First Out).
 *
 * @author <a href="mailto:Abdelmoumene.Toudeft@etsmtl.ca">A. Toudeft</a>
 * @version 2005
 */

public class PileChaineeSimple {

	private Noeud sommet; 		//référence l'élément au sommet de la file

	private int nbElement; 	//Nombre d'éléments dans la pile (utilisé pour
						//ne pas avoir à recalculer le nombre d'éléments dans 
						//la méthode taille()). Ne pas oublier de l'incrémenter
						//lorsqu'on empile et le décrémenter lorsqu'on dépile.

	/**
	 * Constructeur sans paramètre
	 * Initialise la référence premier à null et nbElement à 0.
	 */
	public PileChaineeSimple(){

	}

	/**
	 * Crée une pile de la même façon que le premier constructeur.
     * Ce constructeur est laissé là juste pour que les programmes déjà écrits
     * avec le version statique de la pile continuent de fonctionner.
	 * @param taille La taille voulue pour la file.
	 */
	public PileChaineeSimple(int taille){

	}

	/**
	 * Ajoute un élément au sommet de la pile.
	 * 
	 * @param element l'élément à empiler.
	 * @return true si l'opération réussit et false sinon (ce qui n'arrive jamais)
	 */
	public boolean empiler(Object element) {
		Noeud nouveau = new Noeud(sommet,element);
		this.sommet = nouveau;
		this.nbElement++;
		return true;
	}

	/**
	 * Retire l'élément au sommet de la pile.
	 * 
	 * @return L'élément au sommet de la pile s'il existe ou null sinon.
	 */
	public Object depiler(){

		return null;
	}

	/**
	 * Indique si la pile est vide.
	 * 
	 * @return true si la  pile est vide et false sinon.
	 */
	public boolean estVide(){

		return nbElement==0;
	}

	/**
	 * Vide la pile.
	 */
	public void vider(){
		while (estVide())
			depiler();
	}

	/**
	 * Permet de consulter l'élément au sommet de la pile sans l'enlever.
	 * 
	 * @return L'élément au sommet si la pile n'est pas vide et null sinon.
	 */
	public Object peek(){

		return null;
	}


	/**
	 * Retourne le nombre d'éléments dans la pile.
	 * 
	 * @return Le nombre d'éléments actuellement dans la pile.
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
