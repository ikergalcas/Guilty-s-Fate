package main;

import java.awt.*;
import java.util.Hashtable;

import javax.swing.*;

public class LoginForm {

	// Pantalla para meter tu usuario y contraseña
	public boolean login(JFrame frame) {
		//Hashtable<String, String> logininformation = new Hashtable<String, String>();

		JPanel panel = new JPanel(new BorderLayout(5, 5));

		JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
		label.add(new JLabel("E-Mail", SwingConstants.RIGHT));
		label.add(new JLabel("Password", SwingConstants.RIGHT));
		panel.add(label, BorderLayout.WEST);

		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField username = new JTextField();
		controls.add(username);
		JPasswordField password = new JPasswordField();
		controls.add(password);
		panel.add(controls, BorderLayout.CENTER);

		JOptionPane.showMessageDialog(frame, panel, "login", JOptionPane.QUESTION_MESSAGE);

		//logininformation.put("user", username.getText());
		//logininformation.put("pass", new String(password.getPassword()));
		String password1= new String(password.getPassword());

		return authenticate(username.getText().toString(), password1);
	}
	
	

	//Mira si las credenciales d antes son correctas
	public static boolean authenticate(String string, String string2) {
		// hardcoded username and password (solo puedes jugar al juego con este usuario y contraseña), 
		// es una base de datos cutre
		if (string.equals("a") && string2.equals("a")) {
			return true;
		}
		return false;
	}
}
