import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Scenery {
	private String background;
	private Action a;

	public Scenery() {
	}

	public Scenery(String m, Action a) {
		this.background = m;

	}

	public void setScenery(String m) {
		this.background = m;
	}

	public String getScenery() {
		return this.background;
	}

	private void changeBackground(String m) throws Exception {
		if (m == this.background) {
			throw new Exception("You are already in this map");
		} /*
			 * else if(Comprobar que el fondo parámetro está en lista de mapas) throw new
			 * Exception("Can't find this map in the files");
			 */
		else {
			System.out.print("Now you are at: ");
			for (int i = 0; i < m.length() - 4; i++) {
				System.out.print(m.charAt(i));
			}
			setScenery(m);
			// Aqui cambiamos la imagen de fondo (el mapa)
		}
	}

	private void changeActions(Action a) throws Exception {
		if (a == this.a) {
			throw new Exception("You have already these actions");
		}
		
	}
}
