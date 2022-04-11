/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.demineur;

import com.atoudeft.demineur.controleur.EcouteurClics;
import com.atoudeft.demineur.modele.Demineur;
import com.atoudeft.demineur.vue.PanneauDemineur;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * @author A. Toudeft
 * @since 2002
 * @version 1.0
 */
public class FenetrePrincipale extends JFrame {

	//Le mod�le :
	private Demineur demineur;
	
	//La vue :
	private PanneauDemineur panneauDemineur;

	//Le controleur :
	EcouteurClics ecouteur;
	
	private JButton bDevoileTout;

	public FenetrePrincipale() {
		initialiserComposants();
		configurerFenetrePrincipale();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void configurerFenetrePrincipale() {
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initialiserComposants() {
		
		//Cr�er le mod�le :
		demineur = new Demineur();
		
		//Placer les bombes :
		demineur.placerBombes();
				
		//Cr�er le contr�leur :
		ecouteur = new EcouteurClics(demineur);
		
		//Cr�er la vue :
		panneauDemineur = new PanneauDemineur(demineur, ecouteur);
		
		
		//Cr�er le bouton devoilerTout :
		bDevoileTout = new JButton("Devoiler tout");

		//Enregister l'�couteur aupr�s du bouton devoilerTout :
		bDevoileTout.addActionListener(ecouteur);

		//D�finir la commande d'action du bouton :
		bDevoileTout.setActionCommand("DEVOILE_TOUT");
	
		//Placer le bouton dans un panneau :
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		p.add(bDevoileTout);
		
		//Placer les 2 panneaux dans la fen�tre :
		this.add(p,BorderLayout.NORTH);
		this.add(panneauDemineur,BorderLayout.CENTER);
	}
	
	/**
	 * @param args the command line arguments
	 */
	 public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FenetrePrincipale().setVisible(true);
			} 
		 });
	 }
}