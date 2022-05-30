package background;

import java.util.HashSet;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Scenery {
	private String background;
	private HashSet<Action> actions = new HashSet<Action>();
	int id;

	public Scenery(String bck, HashSet<Action> ar) {
		this.background = bck;
		this.actions = ar;
	}

	public Scenery(String m) {
		this.background = m;
	}

	public void setScenery(String m, HashSet<Action> a) {
		this.background = m;
		this.actions = a;
	}

	public String getScenery() {
		return this.background;
	}

	public HashSet<Action> getSetOfActions() {
		return this.actions;
	}

	public HashSet<Action> actionGroup(HashSet<Action> set, int id) throws Exception {
		Boolean validId = false;
		HashSet<Action> sol = new HashSet<Action>();
		for (Action act : set) {
			if (act.getId() == id) {
				sol.add(act);
				validId = true;
			}
		}
		if (validId) {
			return sol;
		} else {
			throw new Exception("Invalid scenary id");
		}
	}

	private void changeBackground(String m) throws Exception {
		if (m == this.background) {
			throw new Exception("You are already in this map");
		} /*
			 * else if(Comprobar que el mapa par�metro est� en lista de mapas) throw new
			 * Exception("Can't find this map in the files");
			 */
		else {
			System.out.print("Now you are at: ");
			for (int i = 0; i < m.length() - 4; i++) {
				System.out.print(m.charAt(i));
			}
			// setScenery(m);
			// Aqui cambiamos la imagen de fondo (el mapa)
		}
	}
	/*
	 * QUE ES ESTO???
	 * 
	 * 
	 * private void changeActions(Action a) throws Exception { if (a == this.a) {
	 * throw new Exception("You have already these actions"); }
	 * 
	 * }
	 * 
	 */

	JFrame window;

	public void showActions(HashSet<Action> act) {
		final JTextArea messageText;

		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		Iterator it = act.iterator();
		String msg = "";
		int cont = 1;
		while (it.hasNext()) {
			msg += String.valueOf(cont) + " " + it.next() + "\n" + "\n";
			cont++;
		}

		messageText = new JTextArea(msg);
		messageText.setBounds(50, 350, 700, 200);
		messageText.setBackground(Color.BLUE);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Times new Roman", Font.PLAIN, 26));
		window.add(messageText);

		window.setVisible(true);
	}

	public void showBackground() { // (String bck) {
		JPanel bgPanel[] = new JPanel[10];
		JLabel bgLabel[] = new JLabel[10];

		bgPanel[1] = new JPanel();
		bgPanel[1].setBounds(50, 50, 700, 350);
		bgPanel[1].setBackground(Color.YELLOW);
		bgPanel[1].setLayout(null);

		window.add(bgPanel[1]);
	}

}
