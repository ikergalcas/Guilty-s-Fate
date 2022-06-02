package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameTimer {

	public static void gameTimer() {
		final JFrame jframe = new JFrame();
		final JLabel jLabel = new JLabel();
		final JButton b = new JButton("Play again");
		final JButton b2 = new JButton("Exit the game");
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(1100, 25, 400, 100);

		jframe.add(jLabel);
		jframe.setVisible(true);

		final Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 5;

			public void run() {

				jLabel.setText("Time left: " + i);
				i--;

				if (i < 0) {
					timer.cancel();
					jLabel.setText("Time's up! The train crashed");
					jLabel.setVisible(true);
					jframe.add(b);
					jframe.add(b2);
					jframe.setBounds(500, 200, 400, 100);
					// Start over
					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							jframe.dispose();
							UI.window.setVisible(false);
							
						}
					});

					// Exit the game
					b2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							jframe.dispose();
							System.exit(0);
						}
					});

				}
			}
		}, 0, 1000);
	}
}
