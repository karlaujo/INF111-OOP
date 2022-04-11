/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.demineur.vue;

import com.atoudeft.demineur.controleur.EcouteurClics; 
import com.atoudeft.demineur.modele.Demineur;
import com.atoudeft.observer.Observable;
import com.atoudeft.observer.Observateur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author A. Toudeft
 * @since 2002
 * @version 1.0
 */
public class PanneauDemineur extends JPanel implements Observateur {

	private Demineur demineur;

	/*
	 * Cr�e le panneau de d�mineur en cr�ant un objet CaseButton pour chaque
	 * case. L'objet CaseButton observe la case.
	 * Les objets CaseButton sont palc�s dans le panneau sous forme d'une
	 * grille (GridLayout).
	 * L'�couteur est enregistr� pour �couter les clics sur chacun des 
	 * CaseButton.
	 */
	
	public PanneauDemineur(Demineur demineur, EcouteurClics ecouteur) {
		CaseButton btn = null;
		this.demineur = demineur;
		int largeur = demineur.getLargeur(), hauteur = demineur.getHauteur();
		
		//D�finir le gestionnaire de disposition du panneau :
		setBorder(BorderFactory.createEmptyBorder());
		setLayout(new GridLayout(largeur, hauteur));
		
		//Cr�er la grille de boutons :
		for (int i=0;i<largeur;i++)
			for (int j=0;j<hauteur;j++)
			{
				//Cr�er un nouveau bouton de type CaseButton :
				btn = new CaseButton();
				//(CaseButton) new JButton(""+demineur.getCase(i, j).getNbBombesAutour()+"");
						
				//Ajouter le bouton comme observateur de la case i,j du demineur:
				demineur.getCase(i, j).ajouterObservateur(btn);
				
				//D�finir la chaine i,j comme le nom de la commande d'action
				//(setActionCommand()) associ�e au bouton. Servira � trouver la
				//case du d�mineur correspondant au bouton :
				//System.out.println("setting action command");
				btn.setActionCommand(i+","+j);
				
				//Ajouter ce panneau de d�mineur comme �couteur des clics 
				//sur le bouton :
				//System.out.println("adding action listener");
				btn.addActionListener(ecouteur);
				
				//Ajouter le bouton � ce panneau de d�mineur :
				//System.out.println("adding button");
				add(btn);
				
				//Active le bouton :
				//System.out.println("enabling button");
				btn.setEnabled(true);
			}
		this.setVisible(true);
	}
	
	@Override
	public void seMettreAJour(Observable observable) {
		// TODO Auto-generated method stub
		this.repaint();
		
	}
}
