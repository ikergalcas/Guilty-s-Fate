package main;

import java.awt.Desktop.Action;
import Event.Event01;

public class GameManager {
	
	
	ActionHandler aHandler= new ActionHandler(this);
	public UI ui = new UI(this);
	
	public Event01 ev1= new Event01(this);
	
	public static void main(String[] args) {
		new GameManager();
	}
	
	public GameManager() {
		
	}
}
