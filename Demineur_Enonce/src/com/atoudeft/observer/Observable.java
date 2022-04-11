package com.atoudeft.observer;

import java.util.ArrayList;
import java.util.ListIterator;
/**
 * @author A. Toudeft
 * @since 2002
 * @version 1.0
 */
public class Observable {
	//Liste des objets qui observent cet Observable :
	  private ArrayList<Observateur> observateurs = new ArrayList<>();
		
	  //Ajoute un observateur � la liste, s'il n'y est pas d�j� :
	  public boolean ajouterObservateur(Observateur observateur) {
		//System.out.print("HERE!");
		
		boolean ajoutEffectue = false;
			
		if (this.observateurs.contains(observateur)) {
			ajoutEffectue = false;
			//System.out.print("ajout pas reussi");
		}
		
		else {
			this.observateurs.add(observateur);
			//System.out.println("ajout Effectue");
			ajoutEffectue = true;
		}
		
		//if (ajoutEffectue)
			//observateur.seMettreAJour(this);
		return ajoutEffectue;
	  }
		
	  //Demande � tous les observateurs de se mettre � jour :
	  public void notifierObservateurs() {

		 ListIterator<Observateur> iterateur = this.observateurs.listIterator();
		 while (iterateur.hasNext())
			iterateur.next().seMettreAJour(this);
	  }
}
