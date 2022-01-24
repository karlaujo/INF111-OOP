package com.jolicoeur;

import java.util.Locale;
import java.util.Scanner;

/*Program: Odd Numbers
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program increments a variable and  prints it everytime 
	it turn into an odd number.
	
	
*/

public class Exercice1 {
	public static void main(String args []) {
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		int num;
		
		for (num = 0; num < 200; num++)
		{
			if (num % 2 != 0)
			{
				System.out.print(" "+num+"\n");
			}
		}
	}

}
