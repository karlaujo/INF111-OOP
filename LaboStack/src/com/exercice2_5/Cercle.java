package com.exercice2_5;

import com.atoudeft.tdas.Point;

public class Cercle {
	private Point centre;
	private double rayon;

	public Cercle() {
		this.centre = new Point();
		this.rayon = 10;
	}
	
	public Cercle(Point centre, double rayon) {
		this.centre = centre;
		this.rayon = rayon;
	}
	
	public Cercle(double xCentre, double yCentre, double rayon) {
		this.centre.setAbscisse(xCentre);
		this.centre.setOrdonnee(yCentre);
		this.rayon = rayon;
	}
	
	public double getRayon() {
		return this.rayon;
	}
	
	public double getSurface() {
		return Math.PI * Math.pow(rayon, 2);
	}
	
	public boolean contient(Point p) {
		if (centre.distance(p)<=rayon)
				return true;
		return false;
	}
	
	public String toString(double abscisse, double ordonnee, double rayon) {
		return "[("+centre.getAbscisse()+", "+centre.getOrdonnee()+"); "+rayon+"]";
	}
	
}
