package model;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RollerTest {

	@Mock
	private IRollerListener listener;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testWhenRollIsCalledListenerIsNotified() {
		Roller roller = new Roller();
		roller.setListener(listener);
		roller.roll();
		verify(listener).resultRolled(any());
		// assertTrue(retVal >= 1 && retVal <= 6);
	}
}
