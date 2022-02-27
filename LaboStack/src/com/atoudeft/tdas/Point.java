package com.atoudeft.tdas;

import java.util.Objects;

public class Point {
	
	private double abscisse, ordonnee;
	
	public Point() {
		this.abscisse = 0;
		this.ordonnee = 0;
		
	}
	
	public Point(double abscisse, double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	public Point(double abscisse) {
		this.abscisse = abscisse;
		this.ordonnee = 0;
	}
	
	public double getAbscisse() {
		return abscisse;
	}
	
	public double getOrdonnee() {
		return ordonnee;
	}
	
	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}
	
	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	
	@Override
	public String toString() {
		return "(" + abscisse + "," + ordonnee + ")";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (!(obj instanceof Point))
			return false;
		
		Point p = (Point) obj;
		return abscisse == p.abscisse && ordonnee == p.ordonnee;
	}
	
	public double distance(Point p) {
		double x = this.getAbscisse(),
				y = this.getOrdonnee(),
				xp = p.abscisse,
				yp = p.ordonnee;
		
		return Math.sqrt(Math.pow(x-xp, 2)+Math.pow(y-yp, 2));
	}
	
	public double distanceALOrigine() {
		return this.distance(new Point(0,0));
	}

}
