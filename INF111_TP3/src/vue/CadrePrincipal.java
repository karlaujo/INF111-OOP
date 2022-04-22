package vue;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaceUtilisateur.ControleurClavier;
import modele.PlanDeJeu;

/**
 * Cadre principal, définit:
 * - un panneau principal
 * - un controleur clavier
 * 
 * définit un comportement de fin de programme par fenêtre de confirmation
 *
 * @author Frédéric Simard
 * @version E2018
 */
@SuppressWarnings("serial")
public class CadrePrincipal extends JFrame implements Runnable {
	
	// On adapte à la taille de l'écran qu'on saisit ici.
	Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
	ControleurClavier clavier = new ControleurClavier();
	PlanDeJeu planDeJeu = PlanDeJeu.getInstance();
	/**
	 * Constructeur, initialise la référence au modèle.
	 * @param problemManager
	 */
	public CadrePrincipal(){
		this.addKeyListener(clavier);
		clavier.attacherPlanDeJeu(planDeJeu);
	}

	/**
	 * Tâche du view-controller
	 */
	@Override
	public void run() {
		
    	// Panneau principal, conteneur de base qui remplace le ContentPane
    	PanneauPrincipal panPrincipal = new PanneauPrincipal();
    	
    	// ajoute une barre de menu au panneau principal
    	setContentPane(panPrincipal);
    	
    	panPrincipal.addKeyListener(clavier);
    	panPrincipal.panDonjon.addKeyListener(clavier);

    	// configure le Frame
    	configurerFrame();
    	
    	// rend visible
    	setVisible(true);	
    	
	}
	
	/**
	 * Configure le frame en maximisant la fenêtre, puis
	 * en ajoutant une gestion du exit par pop-up
	 */
	private void configurerFrame(){

    	// maximize la fenêtre
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	
    	// ajoute une gestion du EXIT par confirmation pop-up
		this.addWindowListener(new WindowAdapter() {
		      
			// gestionnaire d'événement
			public void windowClosing(WindowEvent we) {
				
		        int result = JOptionPane.showConfirmDialog(null,
		            "Do you want to Exit ?", "Exit Confirmation : ",
		            JOptionPane.YES_NO_OPTION);
		        
		        if (result == JOptionPane.YES_OPTION){
		          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        }
		        else if (result == JOptionPane.NO_OPTION){
		        	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        }
		      }
			
		});
	}
}