package model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RollerTest {

	@Test
	public void testWhenRollIsCalledANumberInRangeIsReturned() {
		Roller roller = new Roller();
		int retVal = roller.roll(6);
		assertTrue(retVal >= 1 && retVal <= 6);
	}
}
