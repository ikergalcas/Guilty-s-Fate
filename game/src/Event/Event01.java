package Event;

import main.GameManager;

public class Event01 {

	
	GameManager gm;
	
	
	public Event01(GameManager gm) {
		
		
		this.gm= gm;
	}
	
	//"Hablar2","Abrir2","Correr2","Salir2"
	
	
	public void Hablar2() {
		 gm.ui.messageText.setText("OLEEE");
	}
	
	public void Abrir2() {
		 gm.ui.messageText.setText("OLEEE");
	}
	public void Correr2() {
		 gm.ui.messageText.setText("OLEEE");
	}
	public void Salir2() {
		 gm.ui.messageText.setText("OLEEE. \n (Adios)");
	}
	
	
}
