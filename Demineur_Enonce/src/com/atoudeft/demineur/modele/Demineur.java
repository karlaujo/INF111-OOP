/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.demineur.modele;

import java.util.Random;

/**
 * Cette classe mod�lise le jeu de d�mineur.
 * @author A. Toudeft
 * @since 2002
 * @version 1.0
 */

public class Demineur {
   
    private Case[][] grille;
    
    /*
     *cr�e un demineur avec une grille de taille largeur x hauteur.
     */
    public Demineur(int largeur, int hauteur)
    {
        //� compl�ter :
    	grille = new Case[largeur][hauteur];
    	//grille = new Case[largeur][hauteur];
    	for (int i = 0; i < largeur; i++) {
    		for (int j = 0; j < hauteur; j++) {
    			grille[i][j] = new Case();
    			System.out.println("Case x:"+i+"y:"+j+" cree");
    		}
    	}
    	System.out.println("Demineur cree\n");
    }
    /*
     *cr�e un demineur avec une grille 10x10.
     */
    public Demineur() 
    {
        this(10,10); //appel au premier constructeur.
    }

    public int getLargeur()
    {
        return grille.length;
    }
    public int getHauteur()
    {
        return grille[0].length;
    }
    
    /*
     * Indique si la case x,y existe dans la grille du d�mineur.
     */
    public boolean caseValide(int x, int y) {
    	return (x>=0 && x<grille.length && y>=0 && y<grille[0].length);
    }
   
    /*
     * Retourne la case de la ligne x, colonne y si elle existe dans la grille
     *  du d�mineur. Retourne null sinon.
     */
    public Case getCase(int x, int y)
    {
        if (!caseValide(x,y)) {
        	//System.out.println("case " +x+ ","+y+ "vide");
            return null;
        }
        
        //System.out.println("Case recherchee: x="+x+" y="+y);
        return grille[x][y];
    }
    
    /*
     * Place les bombes al�atoirement dans la grille du d�mineur et m�morise
     * dans chacune des cases le nombre de bombes autours (en appelant
     * getNbBombesVoisines()).
     */
    public void placerBombes()
    {
        int x,y;
        int n = 0;
        int b = 0;
        
        //Nombre de bombes (environ 1 case sur 8 est une bombe) :
        int nbBombes = (grille.length*grille[0].length) * 1/8;
        
        //Placement des bombes :
        //� compl�ter :
        System.out.print("placement bombe...s");
        Random rn = new Random();
        
        for (n = 0; n < nbBombes; n++) {
        	x = rn.nextInt(getLargeur()-1);
        	y = rn.nextInt(getHauteur()-1);
        	
        	//if(caseValide(x,y)) {
	        grille[x][y].setBombe(true);
	        System.out.println("Bombe a x:"+x+" y:"+y);
			n++;
        	//}
        }
        
        //D�termination du nombre de bombes dans les cellules voisines :
        //� compl�ter :
        for (int i = 0; i < getLargeur(); i++) {
        	for (int j = 0; j < getHauteur(); j++) {
        		if (caseValide(i+1, j)) {
        			if (grille[i+1][j].isBombe())
        				b++;
        		};
        		
        		if (caseValide(i, j+1)) {
        			if (grille[i][j+1].isBombe())
        				b++;
        		};
        		
        		if (caseValide(i-1, j)) {
        			if (grille[i-1][j].isBombe())
        				b++;
        		};
        		
        		if (caseValide(i, j-1)) {
        			if (grille[i][j-1].isBombe())
        				b++;
        		};
        		
        		grille[i][j].setNbBombesAutour(b);
        	}
        }
        
    }
    
    /*
     * D�voile toutes les cases de la grille du d�mineur .
     */
    public void devoileTout()
    {
        //� compl�ter :
    	for (int i = 0; i < this.getLargeur(); i++){
    		for (int j = 0; j < this.getHauteur(); j++) {
    			grille[i][j].setDevoilee(true);
    		}
    	}
    }
    /*
     * Retourne le nombre de bombes autour de la case x,y
     */
    public int getNbBombesVoisines(int x, int y)
    {
        int compteur = 0;
        //� compl�ter :
        if (!caseValide(x,y))
        	return 0;
        compteur = grille[x][y].getNbBombesAutour();
        return compteur;
    }
    
    /*
     * M�thode r�cursive (s'appelle elle-m�me) qui d�voile la case x,y et ses
     * voisines s'il n'y a aucune bombe autour.
     * @return false si la case x,y est une bombe, true sinon.
     */
    public boolean devoiler(int x, int y)
    {
        if (!caseValide(x,y))
            return true;
        if (grille[x][y].isDevoilee())
            return true;
        if (grille[x][y].isBombe())
            return false;//perdu
        grille[x][y].setDevoilee(true);
        if (grille[x][y].getNbBombesAutour()!=0)
            return true;
        
        //0 bombes autour, d�voiler les 8 cases voisines :
        int dx, dy;
        for (dx=-1;dx<=1;dx++)
            for (dy=-1;dy<=1;dy++)
            {
                if (dx!=0 || dy!=0)
                    this.devoiler(x+dx, y+dy);//appel r�cursif
            }
        return true;
    }
    
    public void messagePerdu() {
    	System.out.print("Vous avez perdu!!!!");
    }
}
