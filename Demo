package game;

import java.util.Scanner;

public class ChooseYourOwnAdventure {
	
	Scanner stringReader = new Scanner (System.in);
	Scanner numberReader= new Scanner (System.in);
	
	public ChooseYourOwnAdventure() {
		System.out.println ("You're Sherlock Holmes, renowned detective");
		System.out.println("You are on your way home, tired from work, when you hear...");
		System.out.println("HELP! HELP!");
		System.out.println("A stewardess runs to you");
		System.out.println("Mister Holmes!! We need your help! A man has been murdered");
		System.out.println("Enter 'help' or 'ignore':");
		
		String choice= stringReader.nextLine();
		if (choice.equals("help")) {
			startStory();
		}
		if (choice.equals("ignore")) {
			System.out.print("You lost the game! The assassin ran away");
		}
	}
	public void startStory() {
		System.out.println("You can either speak with the supervisor or inspect the body");
		System.out.println("Insert 'supervisor' or 'body':");
		String startStoryChoice = stringReader.nextLine();
		if (startStoryChoice.equals("supervisor")) {
			
		}
		if (startStoryChoice.equals("body")) {
			
		}
	}

	public static void main(String[] args) {
	 new ChooseYourOwnAdventure();
	}

}
