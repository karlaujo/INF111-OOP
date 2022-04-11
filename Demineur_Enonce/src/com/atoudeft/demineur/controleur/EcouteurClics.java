package com.atoudeft.demineur.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.atoudeft.demineur.modele.Case;
import com.atoudeft.demineur.modele.Demineur;

public class EcouteurClics implements ActionListener {

	private Demineur demineur;
	
	public EcouteurClics(Demineur demineur) {
		this.demineur = demineur;
		//System.out.println("ecouteur cree");
	}

	/*
	 * M�thode ex�cut�e chaque fois qu'on clique sur un des boutons du
	 * panneau de d�mineur.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click");

		JButton b = (JButton)e.getSource();

		String s = b.getActionCommand();
		
		if ("DEVOILE_TOUT".equals(s)) {
			 int r = JOptionPane.showConfirmDialog(b, 
					 "Etes-vous sur de vouloir abandonner ?");
			 if (r==JOptionPane.OK_OPTION)
				 demineur.devoileTout();
		}
		
		else {
			//� compl�ter :
			//Extraire de la chaine s la ligne et la colonne de la case
			//Ensuite, d�voiler la case et si c'est une bombe (devoiler() 
			//retourne false), d�voiler toutes les cases et afficher le
			//message "Vous avez perdu!" dans une boite de dialogue de messages.
			
			String[] pos = s.split(",");
			int x = Integer.parseInt(pos[0]);
			int y = Integer.parseInt(pos[1]);
			Case c = demineur.getCase(x,  y);
			c.setDevoilee(true);
			
			if (!c.isDevoilee()) {
				demineur.devoileTout();
				JOptionPane.showMessageDialog(null, "Vous avez perdu!!!");
			}
			
			c.notifierObservateurs();
		}
	}
	
	public void setDemineur(Demineur demineur) {
		this.demineur = demineur;
	}
}