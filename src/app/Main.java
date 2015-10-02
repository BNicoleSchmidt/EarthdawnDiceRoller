package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Dice;
import model.Randomizer;
import model.Roller;
import view.Ui;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Ui ui = new Ui(primaryStage);
		Randomizer rand = new Randomizer();
		Dice dice = new Dice();
		Roller roller = new Roller(rand, dice);
		new Presenter(ui, roller);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
