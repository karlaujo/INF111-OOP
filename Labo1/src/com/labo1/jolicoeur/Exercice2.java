package com.labo1.jolicoeur;

import  java.util.Locale;
import java.util.Scanner;

/*Program: Cylinder Volume
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program calculates the volume of a cylinder by asking the user to enter the radius, and height.
	
	
*/
public class Exercice2 {
	public static void main(String args []) {
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		float radius, height, volume;
		
		System.out.print("Radius: ");
		radius = user.nextFloat();
		
		System.out.print("Height: ");
		height = user.nextFloat();
		
		volume = (float) ((Math.PI * Math.pow(radius,2)) * height);
		
		System.out.print("Volume: "+volume);
	}

}
