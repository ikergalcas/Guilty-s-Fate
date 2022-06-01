import java.util.HashSet;
import java.util.Set;

public class Action {
	private String name;
	private int delay;
	private String response;
	private int id;
	private final static int MAX_DELAY = 10;
	
	//Constructores
	public Action(String n, int scene) {
		name = n;
		id = scene;
		delay = 0;
	}
	
	public Action() {}
	
	//Devuelve un set de acciones con la id especificada, dado un set con todas las acciones posibles.
	public Set<Action> actionGroup(Set<Action> set, int id) throws Exception{
		Boolean validId = false;
		Set<Action> sol = new HashSet<Action>();
		for(Action act : set) {
			if(act.getId() == id) {
				sol.add(act);
				validId = true;
			}
		}
		if (validId) {
			return sol;
		} else {
			throw new Exception ("Invalid scenary id");
		}
	}
	
	//Muestra el nombre de la acción con su respectivo tiempo de espera. Si el tiempo es 0, solo muestra el nombre
	@Override
	public String toString() {
		if(delay != 0) {
			return name + " -> " + Integer.toString(delay) + "s";
		} else {
			return name;
		}
	}
	
	//Setters 
	public void addDelay(int time) throws Exception {
		if(time < 0) {
			throw new Exception ("Can't set delay to negative number");
		}
		
		if(time > MAX_DELAY) {
			throw new Exception ("Too much delay");
		}
		
		delay = time;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public static int getMaxDelay() {
		return MAX_DELAY;
	}

	public String getResponse() {
		return response;
	}
	
	public int getId() {
		return id;
	}
}
