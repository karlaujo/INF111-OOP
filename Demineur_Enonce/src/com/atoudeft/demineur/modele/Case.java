/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.demineur.modele;

import com.atoudeft.observer.Observable;

/**
 *
 * @author A. Toudeft
 * @since 2002
 * @version 1.0
 */

public class Case extends Observable {
	//� compl�ter (attributs) :
	private boolean bombe;
	private boolean devoilee;
	private int nbAutour;
	
	
	/*
	 * Cr�e une case qui est une bombe si le param�tre bombe est � true et qui
	 * n'est pas une bombe si le param�tre bombe est � false.
	 */
    public Case(boolean bombe) {
    	//� compl�ter :
    	this.bombe = bombe;
    }
    
	/*
	 * Cr�e une case qui n'est pas une bombe.
	 */
    public Case() {
    	//� compl�ter :
    	this.bombe = false;
    }

    /*
     * Indique si la case est une bombe ou non.
     */
    public boolean isBombe() {
    	//� modifier/compl�ter :
    	if(bombe)
    		return true;
    	return false;
    }

    /*
     * Marque la case comme �tant une bombe (true) ou non (false).
     */
    public void setBombe(boolean bombe) {
          //� compl�ter :
    	this.bombe = bombe;
    	this.notifierObservateurs();
    }

    /*
     * Indique si la case est d�voil�e/d�couverte ou non.
     */
    public boolean isDevoilee() {
		//� modifier/compl�ter :
    	if(this.devoilee)
    		return true;
		return false;
    }
    /*
     * Marque la case comme �tant d�voil�e/d�couverte (true) ou non (false).
     */
    public void setDevoilee(boolean devoilee) {
    	//� compl�ter :
    	this.devoilee = devoilee;
    	this.notifierObservateurs();
    }
    /*
     * Retourne le nombre de bombes autour de la case (dans ses cases voisines
     * imm�diates).
     */
    public int getNbBombesAutour() {
    	//� modifier/compl�ter :
    	//System.out.println("getting nb autour");
    	return nbAutour;
    }

    /*
     * Sp�cifie le nombre de bombes autour de la case (dans ses cases voisines
     * imm�diates).
     */
    public void setNbBombesAutour(int nbBombesAutour) {
    	//� compl�ter :
    	this.nbAutour = nbBombesAutour;
    } 
}
