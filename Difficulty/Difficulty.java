package Example;

public class Difficulty implements iDifficulty {
	private final static int NUM_DIFFICULTY = 3;
	
	private int difficulty;
	private final static String[] difficultyNames = { "Easy", "Medium", "Hard" };
	private final static int[] difficultyTimes = { 100, 50, 10 };
	
	public Difficulty() {
	}
	
	public Difficulty(int diff) {
		if (diff < 0 || diff > NUM_DIFFICULTY-1) {
			throw new OutOfRange("El valor introcucido no coindice con ninguna difficultad.");
		}
		this.difficulty = diff;
	}
	
	public static Difficulty createDifficulty(int diff) {
		return new Difficulty(diff);
	}
	
	@Override
	public String[] getAllDifficulties(){
		return difficultyNames;
	}
	
	@Override
	public int[] getAllTimes() {
		return difficultyTimes;
	}

	@Override
	public String getDifficultyString() {
		return difficultyNames[difficulty];
	}

	@Override
	public void setDifficulty(int diff) {
		if (diff < 0 || diff > NUM_DIFFICULTY-1) {
			throw new OutOfRange("El valor introcucido no coindice con ninguna difficultad.");
		}
		this.difficulty = diff;
	}

	@Override
	public int getTotalTime() {
		return difficultyTimes[difficulty];
	}

}