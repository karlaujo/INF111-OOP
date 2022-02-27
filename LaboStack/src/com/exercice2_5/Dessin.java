package com.exercice2_5;

import java.util.ArrayList;
import java.util.ListIterator;

import com.atoudeft.tdas.*;

public class Dessin {
	private ArrayList<Cercle> c = new ArrayList<>();

	public void deleteCercle(Cercle c) {
		c = null;
	}
	
	public boolean add(Cercle c) {
		return this.c.add(c);
	}
	
	public Cercle getPremierCercle(Point p) {
		ListIterator<Cercle> i = this.c.listIterator();
		Cercle cercle, trouve = null;
		
		while(i.hasNext() && trouve == null) {
			cercle = i.next();
			if (cercle.contient(p))
				trouve = cercle;
		}
		return trouve;
	}
	
	public double getSurface() {
		double surface = 0;
		int taille = this.c.size(),
				i = 0;
		
		while (i<taille) {
			surface += c.get(i).getSurface();
			i++;
		}
		
		return surface;
	}
}
