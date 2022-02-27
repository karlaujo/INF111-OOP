package com.atoudeft.tdas;

/**
 * Impl�mente une file d'objets de mani�re statique (avec un tableau)
 * Strat�gie de fonctionnement : FIFO (First In First Out).
 *
 * @author <a href="mailto:Abdelmoumene.Toudeft@etsmtl.ca">A. Toudeft</a>
 * @version 2005
 */
public class FileStatique{

	 private Object[] donnees;  //les donn�es de la file
	 private int premier; 		//indice du premier �l�ment de la file
	 private int dernier; 		//indice de la premi�re case disponible
	 private int nbElement; 	//Nombre d'�l�ments dans la file (utilis� pour
	 					//ne pas avoir � recalculer le nombre d'�l�ments dans 
	 					//la m�thode taille()). Ne pas oublier de l'incr�menter
	 					//lorsqu'on ajoute et le d�cr�menter lorsqu'on retire.

    /**
     * Constructeur sans param�tre
     * Cr�e une file avec une capacit� de 10.
     */
    public FileStatique(){
    	this.donnees = new Object[10];
    	this.premier = this.dernier = this.nbElement = 0;
    }

    /**
     * Cr�e une file de la taille demand�e.
     * @param taille La taille voulue pour la file.
     */
    public FileStatique(int taille){
    	this.donnees = new Object[taille];
    	this.premier = this.dernier = this.nbElement = 0;
    	
    }

    /**
     * Ajoute un �l�ment � la fin de la file.
     * 
     * @param element l'�l�ment � enfiler.
     * @return true si l'op�ration r�ussit et false sinon (file pleine)
     */
    public boolean enfiler(Object element) {
    	
    	if (taille() == this.donnees.length) {
    		return false;
    	}
    	
    	donnees[this.dernier] = element;
    	dernier = (dernier+1) % donnees.length;
    	this.nbElement++;
    	return true;
    }

    /**
     * Retire le premier �l�ment de la file.
     * 
     * @return Le premier �l�ment de la file s'il existe ou null sinon.
     */
    public Object defiler(){
    	if (estVide()) {
    		return null;
    	}
    	Object x = donnees[premier];
    	donnees[premier] = null;
    	premier = (premier+1)%donnees.length;
    	this.nbElement--;
    	return x;
    	
    }

    /**
     * Indique si la file est vide.
     * 
     * @return true si la  file est vide et false sinon.
     */
    public boolean estVide() {
    	return nbElement == 0;
    }

	 /**
	  * Vide la file.
	  */
	 public void vider(){
		 //Indication : utiliser une boucle while pour defiler la file aussi
		 //longtemps qu'elle n'est pas vide (2 lignes de code).
		 while (!estVide()){
			 this.defiler();
		 }
	 }

    /**
     * Permet de consulter le premier �l�ment de la file sans l'enlever.
     * 
     * @return Le premier �l�ment si la file n'est pas vide et null sinon.
     */
    public Object debut(){
    	if (estVide()) 
    		return null;
    	return donnees[premier];
    }


    /**
     * Retourne le nombre d'�l�ments dans la file.
     * 
     * @return Le nombre d'�l�ments actuellement dans la file.
     */
    public int taille(){
    	return this.nbElement;
    }
}
