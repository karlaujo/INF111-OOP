package com.labo2;

import java.util.Locale;
import java.util.Scanner;

public class Exercice4 {
	public static void main(String args []) {
		Scanner clavier = new Scanner(System.in);
		clavier.useLocale(Locale.ENGLISH);
		
		int num, i;
		boolean prime = true;
		
		System.out.print("Veuillez saisir un nombre: ");
		num = clavier.nextInt();
		
		while (num != 0) 
		{ 
			for (i = 2; i <= num/2; i++)
			{
				if (num % i == 0)
				{
					prime = false;
					break;
				
				}
			}
				if (!prime)
				{
					System.out.println("Le nombre "+num+" n'est pas prime");
					
				}
				
				else 
				{
					System.out.println("Le nombre "+num+" est prime");
				}
			
			
		}
	}

}

