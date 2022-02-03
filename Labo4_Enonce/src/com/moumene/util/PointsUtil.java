package com.moumene.util;

import com.moumene.labo4.enregistrements.Point;
import com.moumene.labo4.enregistrements.PointFactory;

public class PointsUtil {
	//Retourne une chaine décrivant le point p sous la forme (abscisse,ordonnee)
	public static String toString(Point p) {
		return "("+p.abscisse+","+p.ordonnee+")";
	}

	//Tri le tableau de points par ordre croissant de leurs distances à
	//l'origine (0,0) :
	
	/* Exercice 2.2: On vous demande de compléter la méthode PointsUtil.trier() de manière à trier
	 * le tableau des points par ordre croissant de leurs distances à l’origine (point (0,0)).
	 * Vous utilisez l’algorithme de tri de votre choix.
	 */
	public static void trier(Point[] points) {
		
		int i,j;
		Point temp = PointFactory.getNewPoint();
		Point origine = PointFactory.getNewPoint(0, 0);
		
		
		for (i=0; i < points.length; i++) {
			temp = points[i];
			for (j=i; j > 0 && PointsUtil.distance(origine, points[j-1]) > (PointsUtil.distance(temp, origine)); j--) {
				points[j] = points[j-1]; 
			}
			points[j] = temp;
		}
		
		System.out.println("Liste points en ordre de distance a (0, 0): ");
}
	
	/*Exercice 2.1: Ajoutez à la classe PointsUtil une méthode distance() public et static qui reçoit
	 * 2 enregistrements Point et qui calcule puis retourne la distance entre eux (utilisez le
	 * théorème de Pythagore).
	 */
	public static double distance(Point p1, Point p2) {
		
		double distance = Math.sqrt(Math.pow((p2.abscisse-p1.abscisse), 2) + Math.pow((p2.ordonnee-p1.ordonnee), 2));
		return distance;
	}
	
	
}
