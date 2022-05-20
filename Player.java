
public class Player {

	private String user;
	
	
	
	public Player ( ) {
			
	}
	
	//Getters
	public String getUser() {
		return this.user;
	}

	//Setters
	public void setUser(String u) throws Exception {
		if( u == null) {
			throw new Exception("Name can't be null");
		}else if(u.length() > 15 ) {
			throw new Exception("Name is too long");
		}else {
			user = u;
		}
		
	}
}
