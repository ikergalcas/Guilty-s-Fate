package test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import background.Action;



import background.Scenery;

public class SceneryTest {
	
private static Scenery sc;
private static int InitialId = 0;
static HashSet<Action> actions = new HashSet<Action>();

		@BeforeEach
		public static void setUp() {
		sc = new Scenery(InitialId, actions);
		}

		@AfterEach
		public void tearDown() {
			sc = null;
		}

		
		@Test
		public static void setSetActions() throws Exception {
			Action a = new Action("Primera",0);
			Action b = new Action("Segunda",0);
			Action c = new Action("Tercera",1);
			HashSet<Action> al = new HashSet<Action>();
			al.add(a);
			al.add(b);
			actions.add(a);
			actions.add(b);
			actions.add(c);
			sc.actionGroup();
			assertEquals(al,sc.getActGroup());
		}

		@Test
		public void getActions() {
			Action a = new Action("Primera",0);
			sc.getActions().add(a);
			assertTrue(sc.getActions().contains(a));
		}
		
		@Test
		void whenANullActionSetIsSetAnExceptionIsThrown() throws Exception {
			Exception e = assertThrows(Exception.class, () -> sc.setActions(null));
			assertTrue(e.getMessage().contains("Action Set can't be null"));
		}
		
		
		
}
