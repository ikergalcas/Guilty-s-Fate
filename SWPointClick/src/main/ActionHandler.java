package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	 
	GameManager gm;
	
	public ActionHandler(GameManager gm) {
		 this.gm=gm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String yourChoice= e.getActionCommand();
		//"Hablar2","Abrir2","Correr2","Salir2"
		switch (yourChoice) {
		case "Hablar2": gm.sChanger.showScene1(); break;
		case "Abrir2": gm.ev1.Abrir2(); break;
		case "Correr2": gm.ev1.Correr2(); break;
		case "Salir2" : gm.ev1.Salir2(); break;
		//Cambiar Escena
		case "goScene1": gm.sChanger.showScene1(); break;
		case "goScene2": gm.sChanger.showScene2(); break;
		
		
		
		}

	}

}
