
public class Player {

	private String user;
	private String role;
	private char gender;
	private int action;
	private boolean alive;
	
	
	public Player (String name, char gender) {
		user = name;
		this.gender = gender;
		role = "Policeman"; //TODO
		alive = true;
	}
	
	//Getters
	public String getUser() {
		return this.user;
	}
	 
	public String getRole() {
		return this.role;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public int getAction() {
		return this.action;
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	//Setters
	public void setUser(String u) {
		user = u;
	}
	
	public void setRole(String r) {
		role = r;
	}
	
	public void setGender(char g) {
		gender = g;
	}
	
	public void setAction(int a) {
		action = a;
	}
	
	public void setAlive(boolean b) {
		alive = b;
	}
}
