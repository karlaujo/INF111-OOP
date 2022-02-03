package com.moumene.labo4;

import com.moumene.labo4.enregistrements.Point;
import com.moumene.labo4.enregistrements.PointFactory;
import com.moumene.util.PointsUtil;

public class Exercice2 {

	public static void main(String[] args) {
		double[] abscisses = {2,3,6,5,12,4,5,8,11,9,5,2};
		double[] ordonnees = {6,5,12,2,3,7,11,5,2,4,5,4};
		Point[] points = new Point[abscisses.length];//tableau de même taille
													 //que le tableau abscisses.
		int i;
		
		//On remplit le tableau avec des Points dont les coordonnées sont les
		//valeurs des tableaux abscisses et ordonnees :
		for (i=0;i<points.length;i++)
			points[i] = PointFactory.getNewPoint(abscisses[i], ordonnees[i]);

		//On affiche le tableau de points avant le tri :
		for (i=0;i<points.length;i++)
			System.out.print(PointsUtil.toString(points[i])+" ");
		
		PointsUtil.trier(points);
		
		//On affiche le tableau de points après le tri :
		for (i=0;i<points.length;i++)
			System.out.print(PointsUtil.toString(points[i])+" ");		
	}

}
