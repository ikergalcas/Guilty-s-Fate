
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
	// Max time duration of the game // Right now each action costs 10 and movement
	// actions cost 5.
	private static final int MAX_TIME = 60;

	// Different rooms in the train.
	private static final Place[] places = {
			new Place("Luggage Room", Arrays.asList("Ask the supervisor.", "Inspect the body."), Arrays.asList(
					"The supervisor tells you that while he wasn't there, all the people were having lunch at the restaurant excetp him, one of the waiter, the cleaner and the waiter.",
					"You find out that he was killed by a right-handed person with a knife.")),
			new Place("Cabin Room 1",
					Arrays.asList("Ask to the vigilant of that zone.", "Search for some clues there."),
					Arrays.asList(
							"'When I was coming  from lunch I came across a man, he was running very fast so he couldn't see his face, but I'm sure that he was a man.'",
							"You see some little blood drops that lead directly into a room, which wasn't being used by anyone, so the only people that could get into the room were the supervisor, the cleaner and the coal worker.")),
			new Place("Cabin Room 2", Arrays.asList("Talk to the cleaner.", "Search for some clues there."),
					Arrays.asList(
							"You noticed that she is right-handed and she told you that she was cleaning the rooms when the crime happened, the supervisor was there with her because they were talking about work, so she has an alibi.",
							"You don't find anything, all the rooms are really clean.")),
			new Place("Restaurant", Arrays.asList("Talk to the waiter.", "Ask to the people who was eating there."),
					Arrays.asList(
							"You noticed that he is right-handed, he tells you that he was having a nap in his bedroom alone.",
							"They all agree that the coal worker hadn't left his room in any moment.")),
			new Place("Coal Room", Arrays.asList("Talk to the coal worker.", "I don't know."),
					Arrays.asList("He tells you that he was there all the time.", "I don't know.")) };

	// People you can accuse.
	private static final String[] possible_killers = { "Supervisor", "Cleaner", "Coal Worker", "Waiter" };
	private static final int response = 3;

	public static void main(String[] args) {

		// Scanner for keyboard inputs.
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner(System.in);

		// INTRODUCTION
		// ----------------------------------------------------------------------------------------------------------------------------------------
		System.out.println(
				"You find yourself in the luggage wagon with the dead body and a crowd of people counting on you to solve the mistery. // Actions will take you 10 minutes "
						+ "and moving between rooms 5 minutes.\n");

		// -----------------------------------------------------------------------------------------------------------------------------------------------------

		// It inicates the position of the array places.
		int actual_room = 0;
		// Counter of the time that has passed.
		int time = 0;

		while (time < MAX_TIME) {
			System.out.println("You are in the " + places[actual_room].getName() + ", Time remaining: "
					+ (MAX_TIME - time) + "\n");

			List<String> diffOptions = places[actual_room].getActions();
			int pos = 0;
			for (String action : diffOptions) {
				System.out.println("Option " + pos + ": " + action);
				pos++;
			}

			HashMap<Integer, String> go = showMoves(actual_room, pos);
			Set<Integer> nameGo = go.keySet();
			for (int place : nameGo) {
				System.out.println(go.get(place));
			}

			// We wait for a keyboard input.
			entradaTeclado = entradaEscaner.nextLine();
			try {
				int act_taken = Integer.valueOf(entradaTeclado);

				if (act_taken < diffOptions.size()) {
					String response = places[actual_room].getResponse(act_taken);
					System.out.println(response + "\n");
					places[actual_room].deleteAction(act_taken);
					time += 10;
				} else if (act_taken - diffOptions.size() < nameGo.size()) {
					int pos_arr = act_taken - diffOptions.size();
					actual_room = (int) nameGo.toArray()[pos_arr];
					time += 5;
				} else {
					System.out.println("That number was not an option.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please, introduce a number which is in the list.\n");
			}
		}

		
		// CONCLUSION OF THE GAME - INCRIMINATE THE KILLER
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("You must give your conclusion of who the killer is: ");
		for (int i = 0; i < possible_killers.length; i++) {
			System.out.println("Option " + i + ": " + possible_killers[i]);
		}
		entradaTeclado = entradaEscaner.nextLine();
		int act_taken = Integer.valueOf(entradaTeclado);
		if (act_taken == response) {
			System.out.println("THAT'S RIGHT! The killer was the " + possible_killers[response] + ".");
		} else {
			System.out.println("INCORRECT :( Restart the game if you want to try again.");
		}
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		entradaEscaner.close();
	}

	private static HashMap<Integer, String> showMoves(int pos, int start) {
		HashMap<Integer, String> go = new HashMap<Integer, String>();
		if (pos > 0) {
			go.put(pos - 1, "Option " + start + ": Go back to the " + places[pos - 1].getName());
			start++;
		}
		if (pos < places.length - 1) {
			go.put(pos + 1, "Option " + start + ": Go to the " + places[pos + 1].getName());
			start++;
		}
		return go;
	}

}
