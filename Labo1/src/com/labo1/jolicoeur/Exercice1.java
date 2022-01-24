package com.labo1.jolicoeur;

import  java.util.Locale;
import java.util.Scanner;

/*Program: Temperature Converter
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program converts the temperature from Celsius to Kelvin.
	
	
*/
public class Exercice1 {
	public static void main(String args []) {
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		double tempC, tempF;
		
		System.out.print("Enter temperature in Celsius: ");
		tempC = user.nextDouble();
		
		tempF = (tempC*9)/5 + 32;
		
		System.out.print("Celsius: "+tempC+" \nFahrenheit: "+tempF);
	}
}
