
/*
 * Class for the GUI of the Coin Sorter Program. 
 */
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoinSorterGUI extends Application {

	@Override
	public void start(Stage stage) {
		// Initializing the program parameters with the default values
		List<Integer> coinList = new ArrayList<Integer>(List.of(200, 100, 50, 20, 10));

		CoinSorter cs = new CoinSorter("Pound Sterling (£)", 0, 10000, coinList);

		// Creating a text object for a welcome message
		Text caption = new Text(80, 240, "Welcome to the Coin Sorter Program");
		caption.setFill(Color.DARKGREEN);
		caption.setFont(Font.font("Arial", 25));
		// Creating a text object for the instructions
		Text instructions = new Text(80, 240,
				"Please select an option. When prompted, type your desired input and then press ENTER.");
		instructions.setFill(Color.BLACK);
		instructions.setFont(Font.font("Arial", 15));

		// Creating two text fields where the used can input values
		TextField textField1 = new TextField();
		textField1.setMaxWidth(50);
		TextField textField2 = new TextField();
		textField2.setMaxWidth(50);
		// Initializing the labels of the text fields to show nothing at the beginning
		Label textField1label = new Label(" ");
		textField1label.setTextFill(Color.BLACK);
		textField1label.setFont(Font.font("Arial", 20));
		Label textField2Label = new Label(" ");
		textField2Label.setTextFill(Color.BLACK);
		textField2Label.setFont(Font.font("Arial", 20));

		// Creating a display area for the results
		TextArea display = new TextArea();
		display.setEditable(false);
		display.setMinSize(210, 50);
		display.setMaxSize(700, 50);

		// Creating a horizontal box for the text boxes
		HBox textBoxComponent = new HBox(10);
		textBoxComponent.setAlignment(Pos.CENTER);

		// Creating a horizontal box for the option buttons
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);

		// Creating a horizontal box for the sub-buttons at option 4
		HBox subButtons = new HBox(10);
		subButtons.setAlignment(Pos.CENTER);

		// Creating a vertical box as root
		VBox root = new VBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: #DACF8C;");

		// Option 1 button
		Button option1 = new Button();
		option1.setStyle("-fx-background-color: #1E501F; -fx-text-fill: #FFFFFF");
		option1.setText("Option 1: Coin Calculator");
		option1.setOnAction(e -> {
			// First, set both text fields as visible because we will need them
			textField1.setVisible(true);
			textField2.setVisible(true);
			// Delete the sub-buttons in case this option is called after option 4
			subButtons.getChildren().clear();
			// Set the text box labels
			textField1label.setText("How many pence would you like to exchange?");
			textField2Label.setText("What type of coin would you like to receive?");
			// Create an event handler when someone presses ENTER in the second text box
			textField2.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent ke) {
					if (ke.getCode().equals(KeyCode.ENTER)) {
						// Validate that both values are entered. If not, display a hint.
						if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
							display.setText("Amount of coins and desired coin type must be enterred.");
						}
						// Validate if the coins to exchange value is within the legal range. If not,
						// display a hint.
						else if ((Integer.parseInt(textField1.getText()) > cs.getMaxCoinIn())
								|| (Integer.parseInt(textField1.getText()) < cs.getMinCoinIn())) {
							display.setText("The exchangable value has to be between " + cs.getMaxCoinIn() + " and "
									+ cs.getMinCoinIn());
						}
						// Validate if the coin type is in circulation. If not, display a hint.
						else if ((Integer.parseInt(textField2.getText()) != coinList.get(0))
								& Integer.parseInt(textField2.getText()) != coinList.get(1)
								& Integer.parseInt(textField2.getText()) != coinList.get(2)
								& Integer.parseInt(textField2.getText()) != coinList.get(3)
								& Integer.parseInt(textField2.getText()) != coinList.get(4))

						{
							display.setText("The coin type has to be one of these: 200, 100, 50, 20 or 10");
							// If all validations pass, call the coinCalculator method and display the
							// results
						} else {
							String resultOption1 = cs.coinCalculator(Integer.parseInt(textField1.getText()),
									Integer.parseInt(textField2.getText()));
							display.setText(resultOption1);

						}

					}
				}
			});

		}

		);
		// Option 2 Button
		Button option2 = new Button();
		option2.setStyle("-fx-background-color: #1E501F; -fx-text-fill: #FFFFFF");
		option2.setText("Option 2: Multiple Coin Calculator");
		option2.setOnAction(e -> {
			// First, set both text fields as visible because we will need them
			textField1.setVisible(true);
			textField2.setVisible(true);
			// Delete the sub-buttons in case this option is called after option 4
			subButtons.getChildren().clear();
			// Set the text box labels
			textField1label.setText("How many pence would you like to exchange?");
			textField2Label.setText("What type of coin would you like to exclude?");
			// Create an event handler when someone presses ENTER in the second text box
			textField2.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent ke) {
					if (ke.getCode().equals(KeyCode.ENTER)) {
						// Validate that both values are entered. If not, display a hint.
						if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
							display.setText("Amount of coins and desired coin type must be enterred.");
						}
						// Validate if the coins to exchange value is within the legal range. If not,
						// display a hint.
						else if ((Integer.parseInt(textField1.getText()) > cs.getMaxCoinIn())
								|| (Integer.parseInt(textField1.getText()) < cs.getMinCoinIn())) {
							display.setText("The exchangable value has to be between " + cs.getMaxCoinIn() + " and "
									+ cs.getMinCoinIn());
						}

						// Validate if the coin type is in circulation. If not, display a hint.
						else if ((Integer.parseInt(textField2.getText()) != coinList.get(0))
								& Integer.parseInt(textField2.getText()) != coinList.get(1)
								& Integer.parseInt(textField2.getText()) != coinList.get(2)
								& Integer.parseInt(textField2.getText()) != coinList.get(3)
								& Integer.parseInt(textField2.getText()) != coinList.get(4))

						{
							display.setText("The coin type has to be one of these: 200, 100, 50, 20 or 10");

							// If all validations pass, call the multiCoinCalculator method and display the
							// results
						} else {
							String resultOption2 = cs.multiCoinCalculator(Integer.parseInt(textField1.getText()),
									Integer.parseInt(textField2.getText()));

							display.setText(resultOption2);

						}

					}
				}
			});

		}

		);

		// Option 3 Button
		Button option3 = new Button();
		option3.setStyle("-fx-background-color: #1E501F; -fx-text-fill: #FFFFFF");
		option3.setText("Option 3 - Print Coin List");
		option3.setOnAction(e -> {
			// First, hide the text boxes because we don't need them
			textField1.setVisible(false);
			textField2.setVisible(false);
			// Delete the sub-buttons in case this option is called after option 4
			subButtons.getChildren().clear();
			// Set the text box labels to empty
			textField1label.setText(" ");
			textField2Label.setText(" ");
			// Finally, call the printCoinList method and display the results
			String printCoins = cs.printCoinList();
			display.setText(printCoins);

		});

		Button option4 = new Button();
		option4.setStyle("-fx-background-color: #1E501F; -fx-text-fill: #FFFFFF");
		option4.setText("Option 4 - Set Details");
		option4.setOnAction(e -> {
			// Only display one text box because we only need one
			textField1.setVisible(true);
			textField2.setVisible(false);
			// Delete the sub-buttons in case this option is called after option 4
			subButtons.getChildren().clear();
			// Set the text box labels to empty
			textField1label.setText(" ");
			textField2Label.setText(" ");
			// Create the first sub-button
			Button subButton = new Button();
			subButton.setStyle("-fx-background-color: #C08B19; -fx-text-fill: #FFFFFF");

			subButton.setText("1 - Set currency");
			// Create an event handler - when someone presses the first sub-option
			subButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					// Add a text box label for instruction
					textField1label.setText("New currency: ");
					// Create an event handler - when someone presses ENTER in the text box
					textField1.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent ke) {
							if (ke.getCode().equals(KeyCode.ENTER)) {
								// Get the input from the text box and call the setCurrency method with it
								String newCurrency = textField1.getText();
								cs.setCurrency(newCurrency);
								display.setText("Currency is now set to " + newCurrency);
							}
						}
					});

				}
			});
			Button subButton2 = new Button();
			subButton2.setStyle("-fx-background-color: #C08B19; -fx-text-fill: #FFFFFF");

			subButton2.setText("2 - Set minimum coin input value");
			// Create an event handler - when someone presses the second sub-option
			subButton2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e2) {
					// Add a text box label for instruction
					textField1label.setText("New minumum value: ");
					// Create an event handler - when someone presses ENTER in the text box
					textField1.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent ke) {
							if (ke.getCode().equals(KeyCode.ENTER)) {
								// Get the input from the text box and call the setMinCoin method with it
								int newMin = Integer.parseInt(textField1.getText());
								cs.setMinCoinIn(newMin);
								display.setText("The minimum value is now set to " + newMin);

							}
						}
					});

				}
			});

			Button subButton3 = new Button();
			subButton3.setStyle("-fx-background-color: #C08B19; -fx-text-fill: #FFFFFF");

			subButton3.setText("3 - Set maximum coin input value");
			// Create an event handler - when someone presses the third sub-option
			subButton3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e3) {
					// Add a text box label for instruction
					textField1label.setText("New maximum value: ");
					// Create an event handler - when someone presses ENTER in the text box
					textField1.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent ke) {
							if (ke.getCode().equals(KeyCode.ENTER)) {
								// Get the input from the text box and call the setMaxCoin method with it
								int newMax = Integer.parseInt(textField1.getText());
								cs.setMaxCoinIn(newMax);
								display.setText("The minimum value is now set to " + newMax);

							}
						}
					});

				}
			});
			// Add these sub-button objects to the subButtons box
			subButtons.getChildren().addAll(subButton, subButton2, subButton3);

		}

		);

		Button option5 = new Button();
		option5.setStyle("-fx-background-color: #1E501F; -fx-text-fill: #FFFFFF");
		option5.setText("Option 5 - Print Program Config");
		option5.setOnAction(e -> {
			// First, hide the text boxes because we don't need them
			textField1.setVisible(false);
			textField2.setVisible(false);
			// Delete the sub-buttons in case this option is called after option 4
			subButtons.getChildren().clear();
			// Set the text box labels to empty
			textField1label.setText(" ");
			textField2Label.setText(" ");
			// Call the displayProgramConfig method and display the results
			String programConfig = cs.displayProgramConfig();
			display.setText(programConfig);

		});

		// Add all text box-related objects to the text box
		textBoxComponent.getChildren().addAll(textField1label, textField1, textField2Label, textField2);
		// Add all the main buttons to the button box
		buttons.getChildren().addAll(option1, option2, option3, option4, option5);
		// Add all the components to the main root box
		root.getChildren().addAll(caption, instructions, buttons, subButtons, textBoxComponent, display);

		// Create a new scene
		Scene scene = new Scene(root, 1000, 1000, Color.DARKGREY);

		// Add the scene to the stage, then configure the stage and make it visible
		stage.setScene(scene);
		stage.setTitle("CoinSorter");
		stage.show();

	}

}
