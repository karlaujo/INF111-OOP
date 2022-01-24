package com.jolicoeur;

import java.util.Locale;
import java.util.Scanner;

/*Program: Number Divider
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program shows every divider of a number the user inputs.
	
	
*/

public class Exercice2 {
	public static void main(String args []) {
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		int num, i;
		
		System.out.print("Number: ");
		num = user.nextInt();
		
		for (i = 1; i<=num; i++)
		{
			if (num % i == 0)
			{
				System.out.print(""+i+"\n");
			}
		}
	}

}
