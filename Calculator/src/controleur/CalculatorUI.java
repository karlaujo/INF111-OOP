package controleur;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorUI extends JPanel {
	
	public CalculatorUI() {
		
		JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "Cls",
            "Bck",
            "",
            "Close",
            "7",
            "8",
            "9",
            "/",
            "4",
            "5",
            "6",
            "*",
            "1",
            "2",
            "3",
            "-",
            "0",
            ".",
            "=",
            "+"
        };

        for (int i = 0; i < buttons.length; i++) {
            if (i == 2) {
                panel.add(new JLabel(buttons[i]));
            } else {
                panel.add(new JButton(buttons[i]));
            }
        }
	}
}
