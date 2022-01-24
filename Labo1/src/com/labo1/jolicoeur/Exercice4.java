package com.labo1.jolicoeur;

import  java.util.Locale;
import java.util.Scanner;

/*Program: Concrete Quantity Calculator
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program calculates the amount of concrete that can be produced depending on the amount of ingredients given by the user.
	
	
*/

public class Exercice4 {
	public static void main(String args []) { 
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		double cement, sand, gravel, concrete;
		double minCement, minSand, minGravel;
		
		System.out.print("Cement quantity(kg): ");
		cement = user.nextDouble();
		
		System.out.print("Sand quantity(kg): ");
		sand = user.nextDouble();
		
		System.out.print("Gravel quantity(kg): ");
		gravel = user.nextDouble();
		
		minCement = cement/350;
		minSand = sand/680;
		minGravel = gravel/1175;
		
		concrete = Math.min(Math.min(minCement, minSand), minGravel);
		System.out.println("Concrete: "+concrete);
	}

}
