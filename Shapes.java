
/**
 * Shapes: An interface to change shapes and colours of the shapes.
 * @author (your name)
 * @version (1.0)
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Shapes extends Application
{
    TextArea display;
    Button shapeButton;
    Shaper shaper;

    @Override
    public void init() throws Exception {
	super.init();
	display = new TextArea();
	display.setEditable(false);
	display.setMinSize(210, 50);
	display.setMaxSize(300, 100);
    }

    @Override
    public void start(Stage stage) {
	// create and configure text fields for input
	TextField lengthField = new TextField();
	lengthField.setMaxWidth(50);

	TextField heightField = new TextField();
	heightField.setMaxWidth(50);

	// object that sets and displays shapes
	shaper = new Shaper();

	// create and configure a vertical container to hold all the components
	VBox root = new VBox(25);
	root.setAlignment(Pos.CENTER);
	root.getChildren().addAll(shapeBox(), colourBox(), display,
		shaper.getMainGroup());

	// create a new scene and add it to the stage
	Scene scene = new Scene(root, 600, 600);
	stage.setScene(scene);
	stage.setTitle("Shapes GUI");
	stage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

    private VBox shapeBox() {
	Label shapeLabel = new Label("Please enter a valid, desired shape");
	Label shapeLabel2 = new Label("(triangle, rectancle, hexagon)");
	shapeLabel.setTextFill(Color.RED);
	shapeLabel.setFont(Font.font("Arial", 16));
	shapeLabel2.setTextFill(Color.RED);
	shapeLabel2.setFont(Font.font("Arial", 16));

	TextField shapeTextField = new TextField();
	shapeTextField.setMaxWidth(100);

	Button shapeButton = new Button();
	shapeButton.setText("Render shape");

//	gets text input
	shapeButton.setOnAction(e -> {
	    String textFieldValue = shapeTextField.getText().toLowerCase();
	    if (textFieldValue.isEmpty()) {
		display.setText(
			"ERROR: Shape value must not be empty. \nPlease enter a valid value \n(triangle, rectancle, hexagon)");
	    } else if (!(textFieldValue.equals("rectangle")
		    || textFieldValue.equals("triangle")
		    || textFieldValue.equals("hexagon"))) {
		display.setText(
			"ERROR: You have entered an invalid value. \nPlease enter a valid value\n(triangle, rectancle, hexagon)");
	    } else {
		if (textFieldValue.equals("rectangle")) {
		    shaper.setRectangle();
		} else if (textFieldValue.equals("triangle")) {
		    shaper.setTriangle();
		} else if (textFieldValue.equals("hexagon")) {
		    shaper.setHexagon();
		}
		display.setText("Here's your shape!");
	    }
	});

//	horizontal box that holds inputs textField and button
	HBox shapeInputs = new HBox(shapeTextField, shapeButton);
	shapeInputs.setAlignment(Pos.CENTER);

//	vertical box to hold labels and inputs
	VBox inputComponents = new VBox(10);
	inputComponents.setAlignment(Pos.CENTER);
	inputComponents.getChildren().addAll(shapeLabel, shapeLabel2, shapeInputs);

	return inputComponents;

    }

    private VBox colourBox() {
	Label colourLabel = new Label("Please enter a valid colour");
	Label colourLabel2 = new Label("(green, red, grey)");
	colourLabel.setTextFill(Color.RED);
	colourLabel.setFont(Font.font("Arial", 16));
	colourLabel2.setTextFill(Color.RED);
	colourLabel2.setFont(Font.font("Arial", 16));

	TextField colourTextField = new TextField();
	colourTextField.setMaxWidth(100);

	Button colourButton = new Button();
	colourButton.setText("Render colour");

// gets text input
	colourButton.setOnAction(e -> {
	    String textFieldValue = colourTextField.getText().toLowerCase();
	    if (textFieldValue.isEmpty()) {
		display.setText(
			"ERROR: colour value must not be empty. \nPlease enter a valid value \n(green, red, grey)");
	    } else if (!(textFieldValue.equals("red")
		    || textFieldValue.equals("green")
		    || textFieldValue.equals("grey"))) {

		display.setText(
			"ERROR: You have entered an invalid value. \nPlease enter a valid value\n(green, red, grey)");
	    } else {
		shaper.setColour(textFieldValue);
		display.setText("Here's your colour");
	    }
	});

//	horizontal box that holds inputs textField and button
	HBox colourInputs = new HBox(colourTextField, colourButton);
	colourInputs.setAlignment(Pos.CENTER);

//	vertical box that holds labels and inputs
	VBox inputComponents = new VBox(10);
	inputComponents.setAlignment(Pos.CENTER);
	inputComponents.getChildren().addAll(colourLabel, colourLabel2,
		colourInputs);

	return inputComponents;
    }

}
