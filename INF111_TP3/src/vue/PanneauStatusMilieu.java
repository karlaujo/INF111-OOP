package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import equipements.*;
import joueur.Joueur;
import modele.PlanDeJeu;
import observer.MonObserver;

public class PanneauStatusMilieu extends JPanel implements MonObserver{
	private JPanel PanneauHero;
	private JPanel PanneauEquipement;
	private Image image;
	private PlanDeJeu plan;
	private Joueur joueur;
	private Vector<AbstractEquipement> equipement;
	
	//Defense
	private JLabel defenseTotale, casque, armure;
	private JComboBox<Casque> boxCasque;
	private JComboBox<Armure> boxArmure;
	
	//Attaque
	private JLabel attaqueTotale, arme, nbPotions;
	private JComboBox<Arme> boxArme;
	private JButton potion;
	
	private int potionCount;
	
	public PanneauStatusMilieu() {
		super();
		initialiserComposants();
	}
	
	public void initialiserComposants() {
		//configurer layout
		setLayout(new GridLayout(1,2));
		Border bordure = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(bordure);
		
		//configurer joueur
		plan = PlanDeJeu.getInstance();
		joueur = plan.getJoueur();
		
		//Panneau Hero
		PanneauHero = new JPanel();
		try {
			image = ImageIO.read(new File("images/hero.png"));
			PanneauHero.add(new JLabel(new ImageIcon(image)));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PanneauHero.setBorder(bordure);
		add(PanneauHero);
		
		//Panneau Equipement
		PanneauEquipement = new JPanel();
		PanneauEquipement.setLayout(new GridLayout(10,1));
		
		//Label Defense et attaque
		defenseTotale = new JLabel("Defense Totale: "+joueur.getArmure());
		casque = new JLabel("Casque:");
		armure = new JLabel("Armure: ");
		attaqueTotale = new JLabel("Attaque Totale: "+joueur.getForce());
		arme = new JLabel("Arme: ");
		nbPotions = new JLabel("Nb Potions: "+potionCount);
		
		//ComboBox attaque et defense
		boxCasque = new JComboBox<Casque>();
		boxArmure = new JComboBox<Armure>();
		boxArme = new JComboBox<Arme>();
		
		//Boutton potion
		potion = new JButton("Utiliser Potion");
		
		
		PanneauEquipement.add(defenseTotale);
		PanneauEquipement.add(casque);
		PanneauEquipement.add(boxCasque);
		PanneauEquipement.add(armure);
		PanneauEquipement.add(boxArmure);
		PanneauEquipement.add(attaqueTotale);
		PanneauEquipement.add(arme);
		PanneauEquipement.add(boxArme);
		PanneauEquipement.add(nbPotions);
		PanneauEquipement.add(potion);
		add(PanneauEquipement);
	}
	
	
	@Override
	public void avertir() {
		//Vide les ComboBox (removeAllItems)
		boxCasque.removeAllItems();
		boxArmure.removeAllItems();
		boxArme.removeAllItems();

		//Crée un compteur de potions égal à zéro.
		potionCount=0;

		//Pour chaque ComboBox (Casque, Armure, Arme), ajoute d’abord une référence à
		//l’Équipement équipé, s’il y en a un.
		if (joueur.getCasqueEquipe() != null )
			boxCasque.addItem((Casque) joueur.getCasqueEquipe());

		if (joueur.getArmureEquipe() != null)
			this.boxArmure.addItem((Armure) joueur.getArmureEquipe());

		if (joueur.getArmeEquipe() != null )
			this.boxArme.addItem((Arme) joueur.getArmeEquipe());

		//Obtient ensuite une référence à la liste d’équipement: joueur.getEquipements()
		equipement = joueur.getEquipements();

		for (AbstractEquipement tool : equipement) {
			if (tool instanceof Casque) {
				boxCasque.addItem((Casque)tool);
			}
			else if (tool instanceof Armure) {
				boxArmure.addItem((Armure)tool);
			}
			else if (tool instanceof Arme) {
				boxArme.addItem((Arme)tool);
			}
			if (tool instanceof Potion) {
				potionCount++;
			}
		}

		boxCasque.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object item = event.getItem();
					joueur.equiper((AbstractEquipement) item);
				}
			}
		});

		boxArme.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object item = event.getItem();
					joueur.equiper((AbstractEquipement) item);
				}
			}
		});

		boxArmure.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object item = event.getItem();
					joueur.equiper((AbstractEquipement) item);
				}
			}
		});

		//boutton potion

		potion.setEnabled(potionCount != 0);

		potion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				joueur.utiliserPotion();
			}
		});

		nbPotions.setText("Nb Potions: "+potionCount);
		defenseTotale.setText("Defense Totale: "+joueur.getArmure());
		attaqueTotale.setText("Attaque Totale: "+joueur.getForce());
	}
}
