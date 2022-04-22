package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import creature.AbstractCreature;
import creature.Araigne;
import creature.Dragon;
import creature.Minotaure;
import joueur.Joueur;
import modele.GestionnaireCombat;
import observer.MonObserver;

public class FenetreCombat extends JFrame implements MonObserver{
	
	//2) La classe contient les variables membres suivants:
	private Joueur joueur;
	private AbstractCreature creature;
	private GestionnaireCombat gestionCombat;
	private JTextArea jtext;
	private JScrollPane jscroll = new JScrollPane();
	private JPanel jpanel;
	private JScrollPane jtextScroll;
	private static Image image;
	
	//3) Le constructeur reçoit 3 paramètres, des références au: héro, créature et gestionnaire
	//de combat
	public FenetreCombat(Joueur joueur, AbstractCreature creature, GestionnaireCombat gestionnaire) {
		super();
		this.joueur = joueur;
		this.creature = creature;
		this.gestionCombat = gestionnaire;
		initialiserComposantes();
	}
	
	public FenetreCombat(){
		super();
		initialiserComposantes();
	}
	
	public void initialiserComposantes() {
		configurationDuFrame();
		configurationImageHero();
		configurationBoiteMessage();
		configurationImageCreature();
		this.setVisible(true);
		this.requestFocus();
	}
	
	//4) configuration du frame
	public void configurationDuFrame(){
		//a)initialiser reference au jpanel
		jpanel = (JPanel) this.getContentPane();
		
		//b)definit position fenetre
		this.setLocation(600, 300);
		
		//c) definir taille fenetre
		this.setSize(800, 400);
		
		//d)definir gridlayout
		GridLayout grid = new GridLayout(0,3);
		this.setLayout(grid);
		
		//e)ajouter windowlistener
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				if (gestionCombat != null ) {
					gestionCombat.combatTermine();
				}
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	//5) configuration image héro:
	public void configurationImageHero() {
		try {
			image = ImageIO.read(new File("images/hero.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panneauHero = new JPanel();
		panneauHero.add(new JLabel(new ImageIcon(image)));
		jpanel.add(panneauHero, BorderLayout.NORTH);
	}
	
	//6) configuration de la boîte de message:
	public void configurationBoiteMessage() {
		
		//a) creer region texte
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
		
		//g) ajouter composants au panneau
		jpanel.add(jtextScroll, BorderLayout.CENTER);
		pack();
		
	}
	
	//7) configuration image créature:
	public void configurationImageCreature() {
		//Creer tableau de chaque type creature et leur assigner une image
		
		AbstractCreature[] tab = new AbstractCreature[3];
		tab[0] = new Araigne(null);
		tab[1] = new Dragon(null);
		tab[2] = new Minotaure(null);
		
		Image image_a=null;
		Image image_d=null;
		Image image_m=null;
		
		for (int i = 0; i <3; i++) {
			if (i==0) {
			try {
				image_a = ImageIO.read(new File("images/"+tab[i].getType()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
			else if (i==1) {
				try {
					image_d = ImageIO.read(new File("images/"+tab[i].getType()+".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			else if (i==2) {
				try {
					image_m = ImageIO.read(new File("images/"+tab[i].getType()+".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			
		}
		
		//Ajouter l'image selon le type de creature
		JPanel panneauCreature = new JPanel();
		
		if (creature instanceof Araigne)
			panneauCreature.add(new JLabel(new ImageIcon(image_a)));
			
			else if (creature instanceof Dragon)
				panneauCreature.add(new JLabel(new ImageIcon(image_d)));
			
			else if (creature instanceof Minotaure)
				panneauCreature.add(new JLabel(new ImageIcon(image_m)));
		
		jpanel.add(panneauCreature, BorderLayout.SOUTH);
	}
	
	//8) ajout de la fonctionnalité MonObserver:
	public void getMessagesGestion() {
		jtext.setText(gestionCombat.getMsg()+"\n");
	}
	
	@Override
	public void avertir() {
		// TODO Auto-generated method stub
    	getMessagesGestion();
		if (!gestionCombat.combatEstEnCours()){
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}
