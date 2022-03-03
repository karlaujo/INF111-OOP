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
	 * Ajoute un �l�ment � la position index.
	 * D�clenche l'exception si index est hors limites (<0 ou >nbElements)
	 */
	public void ajouter(int index, Object obj) throws IndexOutOfBoundsException{
		
	}
	
	/*
	 * Retourne l'�l�ment de la liste qui se trouve � la position index.
	 * D�clenche l'exception si index est hors limites (<0 ou >nbElements)
	 */
	public Object get(int index) throws IndexOutOfBoundsException{
		Object x = null;
		
		return x;
	}
	
	/*
	 * Retire le dernier �l�ment de la liste.
	 * D�clenche l'exception si la liste est vide
	 */
	public Object retirerDernier() throws NoSuchElementException {
		Object x = null;
		
		return x;
	}
	/*
	 * Retire le premier �l�ment de la liste.
	 * D�clenche l'exception si la liste est vide
	 */
	public Object retirerPremier() throws NoSuchElementException {
		Object x = null;
		
		return x;
	}
	/*
	 * Retire l'�l�ment de la liste qui se trouve � la position index.
	 * D�clenche l'exception IndexOutOfBoundsException si index est hors limites
	 * (<0 ou >nbElements)
	 * D�clenche l'exception NoSuchElementException si la liste est vide
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
	 * Retourne la position du premier �l�ment de la liste qui est equals � obj.
	 * Retourn -1 s'il n'y en a pas. 
	 */
	public int indexOf(Object obj) {
		int indice = -1;
		//� compl�ter :
		
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
