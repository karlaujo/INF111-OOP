package vue;

/**
 * Panneau donjon
 * 
 * Panneau qui dessine le donjon et les éléments du donjon.
 * 
 * Est un observer des éléments du jeu. Lors d'un changement dans le jeu
 * rafraîchit l'affichage.
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import dongon.Donjon;
import interfaceUtilisateur.ControleurClavier;
import modele.PlanDeJeu;
import observer.MonObserver;
import personnage.AbstractPersonnage;
import physique.Position;

public class PanneauDonjon extends JPanel implements MonObserver{
	
	Dimension taille;
	EnginDessinDonjon enginDessinDonjon;
	
	PlanDeJeu planDeJeu = PlanDeJeu.getInstance();
	
	/**
	 * Constructeur
	 * @param taille, taille de la fenêtre
	 */
	public PanneauDonjon(Dimension taille){
		
		Dimension centre = new Dimension(taille.width/3, taille.height/2);
		enginDessinDonjon = new EnginDessinDonjon(centre);
		planDeJeu.attacherObserver(this);
		this.taille = taille;
		validate();
		repaint();		
	}

	
	/**
	 * Exécuté chaque rafraîchissement d'écran.  On ne dessine pas les liens si la
	 * carte est à null.
	 * @param g, référence à l'engin graphique
	 */
	public void paintComponent(Graphics g) {
		
		// convertie en engin graphique 2D
		Graphics2D g2 = (Graphics2D) g;
		
		// appel au paint de base
		super.paintComponent(g);
		// efface l'écran
		g2.clearRect(0, 0, taille.width, taille.height);
		// re-dessine les éléments du jeu
		enginDessinDonjon.dessinerDonjon(g2, planDeJeu.getDonjon());
		enginDessinDonjon.dessinerCreatures(g2, planDeJeu.getCreatures());
		enginDessinDonjon.dessinerEquipements(g2, planDeJeu.getEquipements());
		enginDessinDonjon.dessinerJoueur(g2, planDeJeu.getJoueur());

		if(!planDeJeu.estEnCombat()){
			requestFocus();
		}
	}


	@Override
	/**
	 * méthode callback, pour la gestion de l'observer
	 */
	public void avertir() {
		repaint();	
	}

}
