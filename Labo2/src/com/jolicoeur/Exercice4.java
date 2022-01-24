package com.jolicoeur;

import java.util.Locale;
import java.util.Scanner;

/*Program: Prime Number Verifier
Author: Karl-Eric Jolicoeur
Date: 16/01/2022
Description: This program calculates whether or not a number which the user inputs is prime.


*/
public class Exercice4 {
	public static void main(String args []) {
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		int num, i;
		boolean prime = true; 
		
		System.out.print("Number: ");
		num = user.nextInt();
		
		while (num != 0)
		{
			prime = true;
			
			for (i = 2; i <= num/2; i++)
			{
				if (num % i == 0)
				{
					prime = false;
				}
			}
			
			if(!prime || num == 1)
				System.out.print("not prime\n");
			
			else
				System.out.print("prime\n");
			
			System.out.print("Number: ");
			num = user.nextInt();
			
		}
		
		
		
		
	}

}
