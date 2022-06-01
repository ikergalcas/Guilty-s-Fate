import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;

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

		// Restarts game if pressed
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				// Aquí debería crearse un nuevo juego pero no se terminarlo aun
			}
		});

		// add action listener
		b.addActionListener(this);

		// create a panel
		JPanel p1 = new JPanel();
		JOptionPane.showMessageDialog(p1, l2);
		// String getMessage = JOptionPane.showInputDialog(p1, "Introduce tu nombre de
		// usuario:");
		// JOptionPane.showMessageDialog(p1, "¡Tu nombre es: " + getMessage);

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
		JFrame jframe = new JFrame();
		JLabel jLabel = new JLabel();
		JButton b = new JButton("Ok");
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(1100, 25, 400, 100);

		jframe.add(jLabel);
		jframe.setVisible(true);

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 5;

			public void run() {

				jLabel.setText("Time left: " + i);
				i--;

				if (i < 0) {
					timer.cancel();
					jLabel.setText("Time Over");
					jframe.add(b);
					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							jframe.dispose();
							System.exit(0);
						}
					});

				}
			}
		}, 0, 1000);
		pop p = new pop();
	}

}
