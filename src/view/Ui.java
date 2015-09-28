package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ui {
	private String text = "Test";
	private IViewListener listener;
	private Text textBox;

	public Ui(Stage primaryStage) {
		Button roll = new Button("Roll");
		roll.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				listener.rollClicked();
			}
		});
		HBox hbox = new HBox();
		hbox.getChildren().add(roll);
		textBox = new Text(text);
		hbox.getChildren().add(textBox);
		Scene scene = new Scene(hbox);
		primaryStage.setTitle("Dice");
		primaryStage.setScene(scene);
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

}
