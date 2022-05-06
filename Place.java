
import java.util.ArrayList;
import java.util.List;

public class Place {
	
	// Initialize the variable that are mandatory
	String place_name;
	List<String> actions;
	List<String> response;
	
	public Place(String name, List<String> acts, List<String> resp) {
		place_name = name;
		actions = new ArrayList<String>(acts);
		response = new ArrayList<String>(resp);
	}

	// Common funtions that all the places are using
	List<String> getActions(){
		return actions;
	}
	
	String getResponse(int pos) {
		return response.get(pos);
	}
	
	String getName() {
		return place_name;
	}
	
	void deleteAction(int pos) {
		actions.remove(pos);
		response.remove(pos);
	}

}
