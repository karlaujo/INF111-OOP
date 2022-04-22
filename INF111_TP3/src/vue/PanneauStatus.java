package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import modele.PlanDeJeu;
import observer.MonObserver;

public class PanneauStatus extends JPanel implements MonObserver{
	
	private PanneauStatusHaut panStatusHaut;
	private PanneauStatusMilieu panStatusMilieu;
	private PanneauStatusBas panStatusBas; 

	public PanneauStatus(Dimension dimension) {
		super();
		initialiserComposants();
	}
	
	public PanneauStatus() {
		super();
		initialiserComposants();
	}
	/**
	 * Créer les composants à l'intérieur du panneau.
	 * 
	 */
	private void initialiserComposants() {
		
		//configurer layout et bordures
		setLayout(new GridLayout(3,1));
		Border borderPanneauHaut = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(borderPanneauHaut);
        
        //ajouter les panneaux internes
		panStatusHaut = new PanneauStatusHaut ();
		panStatusMilieu = new PanneauStatusMilieu();
		panStatusBas = new PanneauStatusBas();
		
		add(panStatusHaut);
		add(panStatusMilieu);
		add(panStatusBas);
		
		// Ajouter au PlanDeJeu PanneauStatus comme Observer.
		PlanDeJeu planDeJeu = PlanDeJeu.getInstance();
		planDeJeu.attacherObserver(this);
	}
	
	@Override
	public void avertir() {
		this.panStatusHaut.avertir();
		this.panStatusMilieu.avertir();
		this.panStatusBas.avertir();
	}
}
