import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest2 {
	Player p = new Player();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		p.setUser("Maria");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testPlayer() {
//		fail("Not yet implemented");
//	}

	@Test
	void gettingTheNameReturnsTheOneOrigilnallySet() {
		assertTrue(p.getUser().contains("Maria"));
	}

	@Test
	void whenNameIsSetGetReturnsTheNewName() throws Exception {
		p.setUser("Luisa");
		assertTrue(p.getUser().contains("Luisa"));
	}

	@Test
	void whenANullNameIsSetAnExceptionIsThrown() throws Exception {
		Exception e = assertThrows(Exception.class, () -> p.setUser(null));
		assertTrue(e.getMessage().contains("Name can't be null"));
	}
	
	@Test
	void whenALongNameIsSetAnExceptionIsThrown() throws Exception {
		Exception e = assertThrows(Exception.class, () -> p.setUser("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		assertTrue(e.getMessage().contains("Name is too long"));
	}
}
