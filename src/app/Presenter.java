package app;

import model.IRollerListener;
import model.Roller;
import view.IViewListener;
import view.Ui;

public class Presenter implements IRollerListener {
	private Ui ui;
	private Roller roller;
	private int currentDie;

	public Presenter(Ui ui, Roller roller) {
		this.ui = ui;
		this.roller = roller;
		roller.setListener(this);
		ui.setListener(new IViewListener() {

			@Override
			public void rollClicked() {
				roller.roll();
			}

			@Override
			public void dieClicked(int i) {
				roller.addDie(i);
			}
		});
	}

	@Override
	public void resultRolled(String result) {
		ui.setText(result);
		ui.setToRoll("");
	}

	@Override
	public void setToRoll(String string) {
		ui.setToRoll(string);
	}

}
