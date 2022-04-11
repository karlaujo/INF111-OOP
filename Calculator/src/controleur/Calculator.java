package controleur;

import java.awt.*;
import javax.swing.*;



public class Calculator extends JFrame {
	
	public Calculator() {
		initUI();
	}
	
	private void initUI(){
	
		JFrame fen = new JFrame("Calculatrice");

		 /*Menu*/
		 JMenuBar mb = new JMenuBar();
		 JMenu mFichier = new JMenu("Edition");
		 JMenu mOutils = new JMenu("Affichage");
		 JMenu mQuestion = new JMenu("?");

		 JMenuItem miUndo = new JMenuItem("Undo");
		 JMenuItem miSelectionner = new JMenuItem("Select All");
		 JMenuItem miCopy = new JMenuItem("Copy Answer");
		 JMenuItem miQuitter = new JMenuItem("Quitter");
		 mFichier.add(miUndo);
		 mFichier.add(miSelectionner);
		 mFichier.add(miCopy);
		 mFichier.addSeparator();
		 mFichier.add(miQuitter);
		 mOutils.add(new JMenuItem("Minimize"));
		 mOutils.add(new JMenuItem("Zoom"));
		 mOutils.add(new JMenuItem("FullScreen"));
		 mb.add(mFichier);
		 mb.add(mOutils);
		 mb.add(mQuestion);

		 setJMenuBar(mb);
		 setTitle("JMenu 1");
	
		JPanel p2Chiffres = new JPanel(),
				p2Ouest = new JPanel(),
				p2BackCEC = new JPanel(),
				pan4 = new JPanel();
				
		JTextField text = new JTextField();
		
        p2Chiffres.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        p2Chiffres.setLayout(new GridLayout(4, 4, 5, 5));
        p2Ouest.setLayout(new GridLayout(4,0, 5, 5));
        p2BackCEC.setLayout(new GridLayout(1,3, 5, 5));

        String[] numbers = {
            "7",
            "8",
            "9",
            "/",
            "sqrt",
            "4",
            "5",
            "6",
            "*",
            "%",
            "1",
            "2",
            "3",
            "1",
            "1/x",
            "0",
            "+/-",
            ".",
            "+",
            "="
        };
        
        String[] ms = {
        		"MC",
        		"MR",
        		"MS",
        		"M+"
        };
        
        String[] func = {
        		"Back",
        		"CE",
        		"C"
        };

        for (int i = 0; i < numbers.length; i++) {
           p2Chiffres.add(new JButton(numbers[i]));
        }
        
        for (int i = 0; i < ms.length; i++) {
            p2Ouest.add(new JButton(ms[i]));
         }
        
        for (int i = 0; i < func.length; i++) {
            p2BackCEC.add(new JButton(func[i]));
         }
		
        JPanel p1Centre = new JPanel();
        p1Centre.setLayout(new GridLayout(0,2));
        p1Centre.add(p2Ouest, BorderLayout.WEST);
        p1Centre.add(p2Chiffres, BorderLayout.CENTER);
        
        add(p1Centre, BorderLayout.SOUTH);
        
        JPanel pbright = new JPanel();
        JPanel vide = new JPanel();
        pbright.setLayout(new GridLayout(0,2));
        pbright.add(vide);
        pbright.add(p2BackCEC);
        add(pbright, BorderLayout.WEST);
        
        JPanel p1Nord = new JPanel();
        p1Nord.setLayout(new GridLayout(2,0));
        p1Nord.add(text, BorderLayout.NORTH);
        p1Nord.add(pbright);
        add(p1Nord, BorderLayout.NORTH);
        
        
        /*add(pan1, BorderLayout.SOUTH);
        add(pan2, BorderLayout.WEST);*/
        
		setTitle("Calculator");
		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				(new Calculator()).setVisible(true);
			}
		});
	}
}
