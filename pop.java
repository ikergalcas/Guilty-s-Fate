package guiltysfate.maven.eclipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class pop extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// popup
	Popup p;

	// constructor
	pop() {
		// create a frame
		JFrame f = new JFrame("End of game");

		// create a label
		// JLabel l = new JLabel("This is a popup");
		JLabel l2 = new JLabel("The game is over!");

		f.setSize(400, 100);

		PopupFactory pf = new PopupFactory();

		// create a panel
		JPanel p2 = new JPanel();

		// set Background of panel
		p2.setBackground(Color.white);

		// p2.add(l);

		// create a popup
		p = pf.getPopup(f, p2, 152, 180);

		// create a button
		JButton b = new JButton("Play again");
		JButton b2 = new JButton("Exit the game");
		
		// Exits program if b2 pressed
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				System.exit(0);
			}
		});
		
		//Restarts game if pressed
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				//Aquí debería crearse un nuevo juego pero no se terminarlo aun
			}
		});

		// add action listener
		b.addActionListener(this);

		// create a panel
		JPanel p1 = new JPanel();
		JOptionPane.showMessageDialog(p1, l2);

		p1.add(b);
		p1.add(b2);
		f.add(p1);
		f.show();

		/*
		 * if(b2.getModel().isArmed()) { JOptionPane.showMessageDialog(p1, "hi???");
		 * ((JFrame) f).dispose(); }
		 */
	}

	// if the button is pressed
	public void actionPerformed(ActionEvent e) {
		p.show();
	}

	// main class
	public static void main(String args[]) {
		pop p = new pop();
	}
}
