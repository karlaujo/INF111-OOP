package vue;

/**
 * Panneau principal du jeu
 * 
 * contient:
 * - le panneau du donjon
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanneauPrincipal extends JPanel{

	Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
	
	int xDonjon = tailleEcran.width/3 * 2;
	int yDonjon = tailleEcran.height;
	
	int yStatus = tailleEcran.height;
	int xStatus = tailleEcran.width/3;
	
	// Panneaux
	public PanneauDonjon panDonjon;
	private PanneauStatus panStatus;

	/**
	 * Constructeur
	 * @param taille La taille de l'ecran
	 */
	public PanneauPrincipal() {
		
		// assigne la tâche
		setSize(tailleEcran);
		setPreferredSize(tailleEcran);
		
		// initialise les composantes
		initialiserComposantes();
	}
	

	/*
	 * Dimensionne et ajoute les differents panneaux e leur place.
	 */
	private void initialiserComposantes() {

		// définit le layout
		setLayout(new BorderLayout());
		
		// définit le panneau de donjon
		panDonjon = new PanneauDonjon(new Dimension(xDonjon, yDonjon));
		add(panDonjon, BorderLayout.CENTER);
		
		panStatus = new PanneauStatus();
		panStatus.setPreferredSize(new Dimension(xStatus, yStatus));
		add(panStatus, BorderLayout.EAST);

		panDonjon.requestFocus();
		
	}


}
