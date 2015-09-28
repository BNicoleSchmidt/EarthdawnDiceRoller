package app;

import model.Roller;
import view.IViewListener;
import view.Ui;

public class Presenter {
	private Ui ui;
	private Roller roller;

	public Presenter(Ui ui, Roller roller) {
		this.ui = ui;
		this.roller = roller;
		ui.setListener(new IViewListener() {

			@Override
			public void rollClicked() {
				int num = roller.roll(6);
				ui.setText(String.valueOf(num));
			}
		});
	}

}
