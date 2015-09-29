package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ui {
	private String resultText = "Roll something!";
	private IViewListener listener;
	private Text textBox;
	private Text toBeRolled;

	public Ui(Stage primaryStage) {
		int[] dice = { 4, 6, 8, 10, 12, 20 };
		HBox diceBox = new HBox();
		for (int i = 0; i < 6; i++) {
			int face = dice[i];
			Button die = new Button("D" + face);
			die.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					listener.dieClicked(face);
				}
			});
			diceBox.getChildren().add(die);
		}
		CheckBox explode = new CheckBox("Explode?");
		explode.setSelected(true);
		explode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (explode.isSelected()) {
					listener.explode();
				} else {
					listener.noExplode();
				}
			}
		});
		diceBox.getChildren().add(explode);
		Button roll = new Button("Roll");
		roll.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				listener.rollClicked();
			}
		});
		HBox hbox = new HBox();
		hbox.getChildren().add(roll);
		textBox = new Text(resultText);
		hbox.getChildren().add(textBox);
		VBox vbox = new VBox();
		toBeRolled = new Text();
		vbox.getChildren().add(diceBox);
		vbox.getChildren().add(toBeRolled);
		vbox.getChildren().add(hbox);
		Scene scene = new Scene(vbox);
		primaryStage.setTitle("Dice");
		primaryStage.setScene(scene);
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show();
	}

	public void setText(String string) {
		new JFXThreadRunner().runLater(() -> {
			this.textBox.setText(string);
		});
	}

	public void setListener(IViewListener listener) {
		this.listener = listener;
	}

	public void setToRoll(String string) {
		this.toBeRolled.setText(string);
	}

}
