package app;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.Roller;
import view.IViewListener;
import view.Ui;

public class PresenterTest {
	@Mock
	private Ui ui;
	@Mock
	private Roller roller;
	@Captor
	private ArgumentCaptor<IViewListener> viewListenerCaptor;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testWhenRollClickedRollerRolls() {
		new Presenter(ui, roller);
		verify(ui).setListener(viewListenerCaptor.capture());
		IViewListener viewListener = viewListenerCaptor.getValue();
		viewListener.rollClicked();
		verify(roller).roll();
	}

	@Test
	public void testWhenDiceClickedDiceAreAdded() {
		new Presenter(ui, roller);
		verify(ui).setListener(viewListenerCaptor.capture());
		IViewListener viewListener = viewListenerCaptor.getValue();
		viewListener.dieClicked(4);
		verify(roller).addDie(4);
	}

	@Test
	public void testWhenExplodeSelectedExplodeIsSetTrue() {
		new Presenter(ui, roller);
		verify(ui).setListener(viewListenerCaptor.capture());
		IViewListener viewListener = viewListenerCaptor.getValue();
		viewListener.explode();
		verify(roller).explode(true);
	}

	@Test
	public void testWhenExplodeUnselectedExplodeIsSetFalse() {
		new Presenter(ui, roller);
		verify(ui).setListener(viewListenerCaptor.capture());
		IViewListener viewListener = viewListenerCaptor.getValue();
		viewListener.noExplode();
		verify(roller).explode(false);
	}
}
