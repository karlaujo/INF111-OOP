package com.labo1.jolicoeur;

import  java.util.Locale;
import java.util.Scanner;

/*Program: Time Converter
	Author: Karl-Eric Jolicoeur
	Date: 16/01/2022
	Description: This program calculates the time in hours:minutes:seconds by asking the user to enter the time in seconds.
	
	
*/

public class Exercice3 {
	public static void main(String args[]) {
		Scanner user = new Scanner(System.in);
		user.useLocale(Locale.ENGLISH);
		
		int timeUser, timeHrs, timeMins, timeSecs;
		
		System.out.print("Time in seconds: ");
		timeUser = user.nextInt();
		
		timeHrs = timeUser / 3600;
		timeMins = (timeUser % 3600) / 60;
		timeSecs = (timeUser % 3600) % 60;
		
		System.out.print(""+timeHrs+":"+timeMins+":"+timeSecs);
		
	}

}
