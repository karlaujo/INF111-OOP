package vue;

/**
 * Engin de dessin pour le jeu de donjon
 * 
 * L'engin de dessin permet d'afficher le donjon dans une fenêtre graphique.
 * Les objets à dessiner sont passée par paramètre, lors de l'appel de la méthode
 * approprié.
 * 
 * Seul le constructeur par paramètre est disponible.
 * 
 * Voici la liste des services:
 * 	- EnginDessinDonjon, constructeur par paramètre
 *  - dessinerJoueur, dessine un joueur
 *  - dessinerCreatures, dessine toutes les créatures
 *  - dessinerDonjon, dessine le donjon
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Vector;

import creature.AbstractCreature;
import creature.Araigne;
import creature.Dragon;
import creature.Minotaure;
import dongon.Case;
import dongon.Configuration;
import dongon.Donjon;
import equipements.AbstractEquipement;
import joueur.Joueur;
import physique.Direction;
import physique.Position;

public class EnginDessinDonjon {

	private Dimension centre;
	private static int LONGUEUR_CASE = 30;
	
	@SuppressWarnings("unused")
	private EnginDessinDonjon(){}

	/**
	 * constructeur par paramètre
	 * @param centre(Dimension), point centrale du frame
	 */
	public EnginDessinDonjon(Dimension centre){
		this.centre = centre;
	}

	/**
	 * dessinerJoueur, permet de dessiner un joueur dans la vue
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param joueur(Joueur), joueur à dessiner
	 */
	public void dessinerJoueur(Graphics2D g2, Joueur joueur){
		
		// affiche le joueur en position labyrinthe
		dessinerJoueur(g2, convertirIJaPixel(joueur.getPos()));
	}

	/**
	 * dessinerCreatures, permet de dessiner toutes les creatures vivantes
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param creatures(vecteur), vecteur des créatures du jeu
	 */
	public void dessinerCreatures(Graphics2D g2, Vector<AbstractCreature> creatures){
		for(int i=0;i<creatures.size();i++){			
			AbstractCreature creature = creatures.get(i);
			if(creature.getCase().getDecouverte() && creature.estVivant()){
				dessinerCreature(g2, convertirIJaPixel(creature.getPos()), creature);
			}
		}
	}
	

	/**
	 * dessinerEquipements, permet de dessiner tous les équipements au sol
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param equipements(vecteur), vecteur des equipements du jeu
	 */
	public void dessinerEquipements(Graphics2D g2, Vector<AbstractEquipement> equipements){
		for(int i=0;i<equipements.size();i++){			
			AbstractEquipement equipement = equipements.get(i);
			if(equipement.getCase().getDecouverte() && equipement.estAusol()){
				dessinerEquipement(g2, convertirIJaPixel(equipement.getPos()), equipement);
			}
		}
	}


	/**
	 * convertirIJaPixel, permet de dessiner toutes les creatures vivantes
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param ij(Position), position en coordonnee labyrinthe
	 */
	private Position convertirIJaPixel(Position ij){
		Configuration config = Configuration.getInstance();
		Position hautGauche = new Position(centre.height - (int)config.getConfig(Configuration.NB_LIGNES)/2*LONGUEUR_CASE, centre.width - (int)config.getConfig(Configuration.NB_COLONNES)/2*LONGUEUR_CASE);		
		ij.multiplierPos(LONGUEUR_CASE, LONGUEUR_CASE);
		ij.additionnerPos(hautGauche);
		return ij;
	}
	

	/**
	 * dessinerDonjon, permet de dessiner le donjon
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param donjon(Donjon), reference au donjon
	 */
	public void dessinerDonjon(Graphics2D g2, Donjon donjon){

		Case[][] cases = donjon.getCases();
		
		// trace les murs
		for(int i=0;i<cases.length;i++){
			for(int j=0;j<cases[i].length;j++){
				dessinerCase(g2,convertirIJaPixel(cases[i][j].getPos()), cases[i][j]);
			}
		}
		
	}

	/**
	 * dessinerCase, permet de dessiner le donjon
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param pos(Position), position en coordonnee pixel
	 * @param cetteCase(Case), case a afficher
	 */
	private void dessinerCase(Graphics2D g2, Position pos, Case cetteCase){

		// point haut-gauche
		int yTop = pos.getI() - LONGUEUR_CASE/2;
		int xGauche = pos.getJ() - LONGUEUR_CASE/2;

		// point bas-droit
		int yBas = pos.getI() + LONGUEUR_CASE/2;
		int xDroit= pos.getJ() + LONGUEUR_CASE/2;

		// si la case est la fin, l'affiche en bleu
		if(cetteCase.getFin()){
			g2.setColor(Color.BLUE);
			g2.fillRect(xGauche, yTop, LONGUEUR_CASE, LONGUEUR_CASE);
		}

		// si cette case est découvert, affiche les murs selon le cas
		if(cetteCase.getDecouverte()){

			g2.setColor(Color.GRAY);
			g2.setStroke(new BasicStroke(7));
			
			// mur haut, bas, gauche, droit
			if(cetteCase.getVoisin(Direction.HAUT) == null){
				g2.drawLine(xGauche, yTop, xDroit, yTop);
			}
			if(cetteCase.getVoisin(Direction.BAS) == null){
				g2.drawLine(xGauche, yBas, xDroit, yBas);
			}
			if(cetteCase.getVoisin(Direction.DROITE) == null){
				g2.drawLine(xDroit, yTop, xDroit, yBas);
			}
			if(cetteCase.getVoisin(Direction.GAUCHE) == null){
				g2.drawLine(xGauche, yTop, xGauche, yBas);
			}

		}else{
			g2.setColor(Color.BLACK);
			g2.fillRect(xGauche, yTop, LONGUEUR_CASE, LONGUEUR_CASE);
		}
		
	}

	/**
	 * dessinerCreature, permet de dessiner une créature
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param posCreature(Position), position en coordonnee pixel
	 * @param creature(AbstractCreature), creature a afficher
	 */
	private void dessinerCreature(Graphics2D g2, Position posCreature, AbstractCreature creature){
		
		// affiche la créature en fonction du type de la classe
		if(creature instanceof Araigne){
			g2.setColor(Color.CYAN);
			g2.fillOval(posCreature.getJ()-15, posCreature.getI()-15, LONGUEUR_CASE, LONGUEUR_CASE);
		}else if(creature instanceof Dragon){
			g2.setColor(Color.BLUE);
			g2.fillOval(posCreature.getJ()-15, posCreature.getI()-15, LONGUEUR_CASE, LONGUEUR_CASE);
		}else if(creature instanceof Minotaure){
			g2.setColor(Color.GRAY);
			g2.fillOval(posCreature.getJ()-15, posCreature.getI()-15, LONGUEUR_CASE, LONGUEUR_CASE);
		}
	}

	/**
	 * dessinerEquipement, permet de dessiner une créature
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param pos(Position), position en coordonnee pixel
	 * @param equipement(AbstractEquipement), equipement à afficher
	 */
	private void dessinerEquipement(Graphics2D g2, Position pos, AbstractEquipement equipement){
		
		g2.setColor(Color.YELLOW);
		g2.fillOval(pos.getJ()-15, pos.getI()-15, LONGUEUR_CASE, LONGUEUR_CASE);
		
	}


	/**
	 * dessinerJoueur, permet de dessiner le joueur
	 * @param g2(Graphics2D), enginGraphic 2D java.swing
	 * @param posCreature(Position), position en coordonnee pixel
	 * @param creature(AbstractCreature), case a afficher
	 */
	private void dessinerJoueur(Graphics2D g2, Position posJoueur){

		g2.setColor(Color.ORANGE);
		g2.fillOval(posJoueur.getJ()-LONGUEUR_CASE/2, posJoueur.getI()-LONGUEUR_CASE/2, LONGUEUR_CASE, LONGUEUR_CASE);
	}
	
}
