package com.labo2.jolicoeur;

import  java.util.Locale;
import java.util.Scanner;
import java.util.Scanner;

/*Program: Odd Numbers
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program prints odd numbers from 0 to 200.
	
	
*/

public class Exercice1 {
	public static void main(String args[]) {
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		int num;
		
		for (num = 0; num < 200; num++)
		{
			if (num % 2 != 0)
			{
				System.out.print(""+num+"\n");
			}
		}
	}

}
