
public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Difficulty dificultad = new Difficulty();
		dificultad.selectDifficultyGraphical();
		
		System.out.println("La dificultad es: " + dificultad.getDifficultyString());
	}

}
