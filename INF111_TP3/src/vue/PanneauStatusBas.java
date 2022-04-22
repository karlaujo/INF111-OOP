package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;

import modele.GestionnaireCombat;
import modele.PlanDeJeu;
import observer.MonObserver;

public class PanneauStatusBas extends JPanel implements MonObserver{
	private JTextArea jtext;
	private JScrollPane jtextScroll = new JScrollPane();
	private PlanDeJeu plan = PlanDeJeu.getInstance();
	private GestionnaireCombat gestionCombat = plan.getGestionnaireCombat();
	
	public PanneauStatusBas() {
		super();
		initialiserComposants();
		// TODO Auto-generated constructor stub
	}

	public void initialiserComposants() {
		//a) creer region texte
		Border bordure = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(bordure);
				jtext = new JTextArea(16, 20);
				
				//b)rendre non editable
				jtext.setEditable(false);
				
				//c) initialiser reference membre
				
				//d)creer JScroll
				jtextScroll = new JScrollPane(jtext);
				
				//e) scrollbar policy
				jtextScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
				//f) initialiser reference membre
				//fait au d??
				//jtextScroll.add(jtext);
				jtext.setText(gestionCombat.getMsg()+"\n");
				
				//g) ajouter composants au panneau
				add(jtextScroll);
	}
	@Override
	public void avertir() {
		plan.getGestionnaireCombat();
		jtext.setText(gestionCombat.getMsg()+"\n");
	}

}
