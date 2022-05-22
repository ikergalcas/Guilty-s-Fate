package tiempoEspera;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DelayTimeTest {

	private static final double EPSILON = 1e-6;
	private static final double getINITIAL_TIME = 0;
	private iDelay delay;

	/*
	 * Order of execution
	 * 
	 * 1 BeforeClass
	 * 
	 * 2 For each Test 2.1 Before 2.2 Test 2.3 After
	 * 
	 * 3 AfterClass
	 */

	@BeforeEach
	public void setUp() {
		delay = DelayTime.CreateDelay(getINITIAL_TIME);
	}

	@AfterEach
	public void tearDown() {
		delay = null;
	}

	// constructor tests

	@Test
	public void crearConTiempoInicialPositivo() {
		final double initial = 100;
		iDelay localDelay = DelayTime.CreateDelay(initial);
		assertEquals(initial, localDelay.getTime());
	}

	@Test
	public void crearConTiempoInicialCero() {
		iDelay localDelay = DelayTime.CreateDelay(0);
		assertEquals(0, localDelay.getTime());
	}

	@Test
	public void crearConTiempoInicialNegativo() {
		final double initial = -100;
		DelayTime localDelay = DelayTime.CreateDelay(initial);
		assertEquals(0, localDelay.getTime());
	}

	// functional add tests

	@Test
	public void incrementoPositivocoConTiempoInicialCero() {
		final double aumento = 100;
		delay.increase(aumento);
		assertEquals(aumento, delay.getTime());
	}

	@Test
	public void incrementoPositivocoConTiempoInicialPositivo() {
		final double initial = 10;
		final double aumento = 100;
		
		iDelay localDelay = DelayTime.CreateDelay(initial);
		System.out.println(localDelay.getTime());

		localDelay.increase(aumento);
		System.out.println(localDelay.getTime());
		
		assertEquals(initial + aumento, localDelay.getTime());
	}

	// exception management add tests

	// Testing throwing of exceptions (was JUnit 4 with expected)
	@Test
	public void incrementoNegativo() {
		Exception exception = assertThrows(NegativeTimeException.class, () -> 
		delay.increase(-100));
	}

	
	/*
	// Testing throwing of exceptions (was JUnit 4 with rules)
		@Test
		public void incrementoNegativoElevaExcepcionConMensajeAdecuado(){
			final double aumento = -175.22;

			Exception exception = assertThrows(NegativeTimeException.class, () -> delay.increase(aumento));

			String expectedMessage = "negative increase: " + aumento;
			String actualMessage = exception.getMessage();

			assertTrue(actualMessage.contains(expectedMessage));

		}
	*/
	
		// Testing throwing of exceptions (was JUnit 4 with Try-Fail-Catch)
		@Test
		public void incrementoNegativoElevaExcepcionNoModificagetTime() {

			Exception exception = assertThrows(NegativeTimeException.class, () -> 
				delay.increase(-100));

			assertEquals(0, delay.getTime());
		}

		// pruebas de decrease

		@Test
		public void decreaseMenorQueInicial() {
			final double initial = 100;
			final double amount = 10;

			DelayTime localDelay = DelayTime.CreateDelay(initial);
			localDelay.decrease(amount);
			assertEquals(initial - amount, localDelay.getTime());
		}

		@Test
		public void decreaseIgualQueInicial() {
			final double initial = 100;

			DelayTime localDelay = DelayTime.CreateDelay(initial);
			localDelay.decrease(initial);
			assertEquals(0,  localDelay.getTime());
		}
		/*
		@Test
		public void decreaseMayorQueInicial() {
			final double initial = 100;
			DelayTime localDelay = DelayTime.CreateDelay(initial);
			double amount = initial + 10;
			localDelay.decrease(amount);
			assertEquals(0, localAccount.getBalance());
		}
		*/
		@Test
		public void crearDosDelayDistintos() {
			final double initial = 100;
			DelayTime localDelay = DelayTime.CreateDelay(initial);
			assertNotSame(delay, localDelay);
		}

}

