import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import java.util.Calendar;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import javafx.animation.Animation;
import static javafx.application.Application.launch;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;

public class TimeButtonDemo extends Application {
	public static boolean is24hour = true;

	protected BorderPane getPane() {

		HBox paneForButtons = new HBox(50);
		ImageView imageView = new ImageView("usa.jpg");
		imageView.setFitHeight(30);
		imageView.setFitWidth(35);
		Button btLeft = new Button("12 hr", imageView);
		ImageView imageView1 = new ImageView("eu.jpg");
		imageView1.setFitHeight(30);
		imageView1.setFitWidth(35);
		Button btRight = new Button("24 hr", imageView1);
		paneForButtons.getChildren().addAll(btLeft, btRight);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: green");

		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);

		DigitalClock clock = new DigitalClock(); // clock to be added to pane
		BorderPane.setAlignment(clock, Pos.CENTER);
		pane.setCenter(clock);

		// handle button clicks with lambdas

		btLeft.setOnAction(e -> is24hour = false);
		btRight.setOnAction(e -> is24hour = true);

		// handle keyboard presses with lambdas

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				clock.setTextFill(Color.RED);
			} else if (e.getCode() == KeyCode.DOWN) {
				clock.setTextFill(Color.CYAN);
			} else if (e.getCode() == KeyCode.ENTER) {
				clock.setTextFill(Color.BLACK);
			}

		});
		return pane;
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("ClockApplication");
		DigitalClock dc = new DigitalClock();
		primaryStage.setScene(new Scene(getPane(), 250, 150));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class DigitalClock extends Label {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private Timeline animation;
	private Calendar time;

	public DigitalClock() {
		// get time and set text with lambda
		EventHandler<ActionEvent> eventHandler = e -> {
			Calendar time = Calendar.getInstance();
			String hourString = StringUtilities.pad(2, ' ', time.get((TimeButtonDemo.is24hour) ? Calendar.HOUR_OF_DAY : Calendar.HOUR) + ""); 
			// HOUR_OF_DAY =
																										// 24 HOUR = 12
			String minuteString = StringUtilities.pad(2, '0', time.get(Calendar.MINUTE) + "");
			String secondString = StringUtilities.pad(2, '0', time.get(Calendar.SECOND) + "");
			String ampmString = (TimeButtonDemo.is24hour) ? "" : (time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM");
			setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);

		};
		// change text font here
		this.setFont(Font.font("Aerial", 30));
		// set animation here
		animation = new Timeline(new KeyFrame(Duration.seconds(1), eventHandler));
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();

	}

	public void changeFormat24() {
		// write code here for changing to 24 hour clock
		TimeButtonDemo.is24hour = true;
	}

	public void changeFormat12() {
		// write code here for changing to 12 hour clock
		TimeButtonDemo.is24hour = false;
	}

}

class StringUtilities {
	/**
	 * Creates a string left padded to the specified width with the supplied padding
	 * character.
	 * 
	 * @param fieldWidth the length of the resultant padded string.
	 * @param padChar    a character to use for padding the string.
	 * @param s          the string to be padded.
	 * @return the padded string.
	 */
	public static String pad(int fieldWidth, char padChar, String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i < fieldWidth; i++) {
			sb.append(padChar);
		}
		sb.append(s);

		return sb.toString();
	}
}