
public class Escenary {
	private String mapa;

	public Escenary() {
	}

	public Escenary(String m) {
		this.mapa = m;
	}

	public void setEscenary(String m) {
		this.mapa = m;
	}

	public String getEscenary() {
		return this.mapa;
	}

	private void changeBackground(String m) throws Exception {
		if (m == this.mapa) {
			throw new Exception("You are already in this map");
		} /*
			 * else if(Comprobar que el mapa parámetro está en lista de mapas) throw new
			 * Exception("Can't find this map in the files");
			 */
		else {
			System.out.print("Now you are at: ");
			for (int i = 0; i < m.length() - 4; i++) {
				System.out.print(m.charAt(i));
			}
			setEscenary(m);
			// Aqui cambiamos la imagen de fondo (el mapa)
		}
	}
}
