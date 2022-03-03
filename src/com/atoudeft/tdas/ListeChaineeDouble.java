package com.atoudeft.tdas;

import java.util.NoSuchElementException;

public class ListeChaineeDouble {

	private Noeud tete;
	private Noeud fin;
	private int nbElements;
	
	public ListeChaineeDouble() {
		this.tete = this.fin = null;
		this.nbElements = 0;
	}
	
	public void ajouterAuDebut(Object obj) {
		
	}
	public void ajouterALaFin(Object obj) {
		
	}
	/*
	 * Ajoute un élément à la position index.
	 * Déclenche l'exception si index est hors limites (<0 ou >nbElements)
	 */
	public void ajouter(int index, Object obj) throws IndexOutOfBoundsException{
		
	}
	
	/*
	 * Retourne l'élément de la liste qui se trouve à la position index.
	 * Déclenche l'exception si index est hors limites (<0 ou >nbElements)
	 */
	public Object get(int index) throws IndexOutOfBoundsException{
		Object x = null;
		
		return x;
	}
	
	/*
	 * Retire le dernier élément de la liste.
	 * Déclenche l'exception si la liste est vide
	 */
	public Object retirerDernier() throws NoSuchElementException {
		Object x = null;
		
		return x;
	}
	/*
	 * Retire le premier élément de la liste.
	 * Déclenche l'exception si la liste est vide
	 */
	public Object retirerPremier() throws NoSuchElementException {
		Object x = null;
		
		return x;
	}
	/*
	 * Retire l'élément de la liste qui se trouve à la position index.
	 * Déclenche l'exception IndexOutOfBoundsException si index est hors limites
	 * (<0 ou >nbElements)
	 * Déclenche l'exception NoSuchElementException si la liste est vide
	 */
	public Object retirer(int index) 
			throws IndexOutOfBoundsException, NoSuchElementException {
		Object x = null;
		
		return x;
	}
	
	/*
	 * Vide la liste
	 */
	public void vider() {
	
	}

	/*
	 * Retourne la position du premier élément de la liste qui est equals à obj.
	 * Retourn -1 s'il n'y en a pas. 
	 */
	public int indexOf(Object obj) {
		int indice = -1;
		//À compléter :
		
		return indice;
	}
	
	
	/*
	 * Indique si la liste est vide
	 */
	public boolean estVide() {
		return nbElements==0;
	}
	
	/*
	 * Taille de la liste
	 */
	public int taille() {
		return nbElements;
	}
	
	private class Noeud {
		public Object donnee;
		public Noeud suivant;
		public Noeud precedent;
		
		public Noeud(Noeud next, Noeud previous, Object data) {
		   this.donnee = data;
		   this.suivant = next;
 		   this.precedent = previous;
		}
	}
}
