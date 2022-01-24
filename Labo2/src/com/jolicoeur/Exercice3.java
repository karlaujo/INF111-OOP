package com.jolicoeur;

/*Program: Wallis Product
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program calculates the value of pi using Wallis' Product.
	
	
*/

public class Exercice3 {
	public static void main (String args []) {
		
		double k, pi, halfpi=1;
		
		
		for (k = 0; k <= 10000; k++)
		{
			halfpi *= (2*k+2)/(2*k+1) * (2*k+2)/(2*k+3);
		}
		
		pi = halfpi*2;
		
		System.out.print("Pi = "+pi);
		
	}

}
