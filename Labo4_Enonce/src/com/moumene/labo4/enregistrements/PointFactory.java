package com.moumene.labo4.enregistrements;

public class PointFactory {
	//Retourne un nouveau point d'abscisse 0 et d'ordonnée 0 :
	public static Point getNewPoint() {
		Point p = new Point();
		return p;
	}
	//Retourne un nouveau point d'abscisse x et d'ordonnée y :
	public static Point getNewPoint(double x, double y) {
		Point p = new Point();
		p.abscisse = x;
		p.ordonnee = y;
		return p;
	}
}
