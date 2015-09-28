package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Roller;
import view.Ui;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Ui ui = new Ui(primaryStage);
		Roller roller = new Roller();
		new Presenter(ui, roller);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
