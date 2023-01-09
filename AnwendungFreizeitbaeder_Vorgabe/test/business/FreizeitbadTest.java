package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.freizeitbaeder.Freizeitbad;
import ownUtil.PlausiException;

class FreizeitbadTest {

	Freizeitbad frzbad;
	
	@BeforeEach
	public void setUp() throws PlausiException {
		frzbad = new Freizeitbad("Stadtbad", "7.00", "17.00", "25", "24");
	}
	
	@AfterEach
	public void breakDown() {
		frzbad = null;
	}
	
	@Test
	void test() {
		assertTrue(() -> this.frzbad.getBeckenlaenge() == 25);
	}

}
