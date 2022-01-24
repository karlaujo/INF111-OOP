package com.moumene.exemple;

import java.util.Scanner;

/**
 * Exemple de programme en mode console avec un menu.
 * @author atoudeft
 *
 */
public class MenuAvecSwitchCase
{
	public static Scanner clavier = new Scanner(System.in);
	public static final char QUITTER = 'q';
	
	public static void main(String args[]) {
		char choix;
		
		choix=menu();
		while (choix!=QUITTER)
		{
			switch (choix)
			{
				case '+':
					System.out.println("Addition");
					break;
				case '-':
					System.out.println("Soustraction");
					break;
				case '*':
					System.out.println("Multiplication");
					break;
				case '/':
					System.out.println("Division");
					break;
				default:
					System.out.println("Opération inconnue...");
			}
			choix=menu();
		}
		System.out.println("Bye Bye");
	}

	private static char menu() {
		char reponse;
		String str;
		System.out.println("\n------- MENU -------\n\n+.Nouveau.\n-.Ouvrir.\n*.Fermer.\n"+
							"/.Enregistrer.\nq.Quitter.\n");
		
		System.out.print("\tVotre choix : ");
		str = clavier.nextLine();
		if (str.length()>0)
			reponse = str.charAt(0);
		else
			reponse = ' ';
		return reponse;
	}
}
