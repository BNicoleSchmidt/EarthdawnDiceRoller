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
		verify(roller).roll(6);
	}
}
