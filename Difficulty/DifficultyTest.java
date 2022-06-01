package Test;

import Example.Difficulty;
import Example.OutOfRange;
import Example.iDifficulty;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DifficultyTest {
	private iDifficulty difficulty;
	private static int InititalDiff = 0;

	@BeforeEach
	public void setUp() {
		difficulty = Difficulty.createDifficulty(InititalDiff);
	}

	@AfterEach
	public void tearDown() {
		difficulty = null;
	}

	@Test
	public void crearDifficultyEasy() {
		difficulty.setDifficulty(0);
		assertEquals("Easy", difficulty.getDifficultyString());
	}

	@Test
	public void crearDifficultyMedium() {
		difficulty.setDifficulty(1);
		assertEquals("Medium", difficulty.getDifficultyString());
	}

	@Test
	public void crearDifficultyHard() {
		difficulty.setDifficulty(2);
		assertEquals("Hard", difficulty.getDifficultyString());
	}
	
	@Test
	public void getDifficultyEasy() {
		difficulty.setDifficulty(0);
		assertEquals(100, difficulty.getTotalTime());
	}
	
	@Test
	public void getDifficultyMedium() {
		difficulty.setDifficulty(1);
		assertEquals(50, difficulty.getTotalTime());
	}
	
	@Test
	public void getDifficultyHard() {
		difficulty.setDifficulty(2);
		assertEquals(10, difficulty.getTotalTime());
	}
	

	@Test
	public void crearDifficultyMenor() {
		Exception exception = assertThrows(OutOfRange.class, () -> Difficulty.createDifficulty(Integer.MIN_VALUE));
	}

	@Test
	public void crearDifficultyMayor() {
		Exception exception = assertThrows(OutOfRange.class, () -> Difficulty.createDifficulty(Integer.MAX_VALUE));
	}

}