package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.Border;

import joueur.Joueur;
import modele.GestionnaireCombat;
import modele.PlanDeJeu;
import observer.MonObserver;

public class PanneauStatusHaut extends JPanel implements MonObserver{
	private JLabel nomHero, niveau, ennemisTues, temps;
	private Timer temp;
	private JProgressBar bar;
	private PlanDeJeu plan = PlanDeJeu.getInstance();
	private GestionnaireCombat gest = plan.getGestionnaireCombat();
	private Joueur joueur = plan.getJoueur();
	private int level, kills, time;
	
	public PanneauStatusHaut() {
		super();
		initialiserComposantes();
		startTimer();
	}

	public void initialiserComposantes() {
		//configurer bordure
		setLayout(new GridLayout(5,1));
		Border bordure = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(bordure);
		
		
		//configurer le nom du hero
		nomHero = new JLabel("Ichigo Kurosaki");
		nomHero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		nomHero.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		add(nomHero);
		
		//configurer bar de progres
		bar = new JProgressBar();
		bar.setBackground(Color.RED);
		bar.setForeground(Color.GREEN);
		add(bar);
		bar.setValue(joueur.getPointDeVie()*100 / joueur.getPointDeVieMax());
		
		//configurer niveau
		niveau = new JLabel("Niveau: "+level);
		niveau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		add(niveau);
		
		//configurer ennemis
		ennemisTues = new JLabel("Nb Ennemis Tues: "+kills);
		ennemisTues.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		add(ennemisTues);
		
		//configurer temps
		temps = new JLabel("Temps de jeu: ");
		temps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		add(temps);
		
		
	}
	
	private void startTimer() {
		temp = new Timer();
		temp.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	temps.setText("Temps du jeu: "+TempsHHMMSS());
		    	time++;
		    	
		    }
		}, 0, 1000);
	}

	public void resetTimer(){
		time = 0;
	}
	
	
	private String TempsHHMMSS(){
		long HH = time / 3600;
		long MM = (time % 3600) / 60;
		long SS = time % 60;
		String timeInHHMMSS = String.format("%02d:%02d:%02d (HH:MM:SS)", HH, MM, SS);
		return timeInHHMMSS;
	}
	
	@Override
	public void avertir() {
		
		//bar
		bar.setValue(joueur.getPointDeVie()*100 / joueur.getPointDeVieMax());

		//reset timer
		if (!joueur.estVivant())
			resetTimer();
		
		//niveau
		level = plan.getNiveau();
		niveau.setText("Niveau: "+level);
		
		//ennemis
		this.kills = gest.getKillStreak();
		ennemisTues.setText("Nb Ennemis Tues: "+kills);
	}
}
