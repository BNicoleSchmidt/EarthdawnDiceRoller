package model;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RollerTest {

	@Mock
	private IRollerListener listener;

	@Mock
	private Randomizer rand;

	@Mock
	private Dice dice;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testWhenRollIsCalledListenerIsNotified() {
		Roller roller = new Roller(rand, dice);
		roller.setListener(listener);
		ArrayList<Die> list = new ArrayList<Die>();
		Die die = new Die(6);
		list.add(die);
		when(dice.getDice()).thenReturn(list);
		when(rand.randInt(6)).thenReturn(4);
		roller.roll();
		verify(dice).getDice();
		verify(rand).randInt(6);
		verify(listener).resultRolled("4 = 4");
	}
}
