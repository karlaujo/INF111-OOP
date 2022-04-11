/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.demineur.vue;

import com.atoudeft.demineur.controleur.EcouteurClics;
import com.atoudeft.demineur.modele.Case;
import com.atoudeft.observer.Observable;
import com.atoudeft.observer.Observateur;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Un bouton qui observe une case de d�mineur.
 * @author A. Toudeft
 * @since 2002
 * @version 1.0
 */

public class CaseButton extends JButton implements Observateur{
	private static Image image;//image repr�sentant une bombe

	public CaseButton() {
		super();
		try {
			image = ImageIO.read(new File("images/bombe.jpg"));				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void seMettreAJour(Observable observable) {
		Case c = null;
		c = (Case)observable; //� d�commenter
		if (c.isBombe()) //partie perdue
		{
			if (image != null) { //Si l'image de la bombe existe, on l'affiche.
				Image image2 = image.getScaledInstance(this.getWidth(), 
						this.getHeight(), 
						Image.SCALE_AREA_AVERAGING);
				Icon icone = new ImageIcon(image2);
				this.setIcon(icone);
			}            	
			else {  //Si l'image de la bombe n'existe pas, on affiche la lettre
					// B en rouge � sa place.
				this.setText("B");
				this.setBackground(Color.red);
			}
		}
		
		else
		{
			int n = c.getNbBombesAutour();
			//System.out.println(n+" bombes autour.");
			if (n==0)
				this.setEnabled(false);
			else
				this.setText(n+"");
		}
	}
}