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
	shapeButton.setOnAction(e -> {
        String textFieldValue = shapeTextField.getText().toLowerCase();
	    if (textFieldValue.isEmpty()) {
		display.setText(
			"Shape value must not be empty. \nPlease enter a valid value \n(triangle, rectancle, hexagon)");
	    } else if (!(textFieldValue.equals("rectangle")
		    || textFieldValue.equals("triangle")
		    || textFieldValue.equals("hexagon"))) {
		display.setText(
			"You have entered an invalid value. \nPlease enter a valid value\n(triangle, rectancle, hexagon)");
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
	HBox shapeInputs = new HBox(shapeTextField, shapeButton);
	shapeInputs.setAlignment(Pos.CENTER);
	VBox inputComponents = new VBox(10);
	inputComponents.setAlignment(Pos.CENTER);
	inputComponents.getChildren().addAll(shapeLabel, shapeLabel2, shapeInputs);
	return inputComponents;

    }

    private VBox colorBox() {
	Label colorLabel = new Label("Please enter a valid color");
	Label colorLabel2 = new Label("(green, red, grey)");
	colorLabel.setTextFill(Color.RED);
	colorLabel.setFont(Font.font("Arial", 16));
	colorLabel2.setTextFill(Color.RED);
	colorLabel2.setFont(Font.font("Arial", 16));

	TextField colorTextField = new TextField();
	colorTextField.setMaxWidth(100);

	Button colorButton = new Button();
	colorButton.setText("Render color");
	colorButton.setOnAction(e -> {
	    String textFieldValue = colorTextField.getText().toLowerCase();
	    if (textFieldValue.isEmpty()) {
		display.setText(
			"color value must not be empty. \nPlease enter a valid value \n(green, red, grey)");
	    } else if (!(textFieldValue.equals("red")
		    || textFieldValue.equals("green")
		    || textFieldValue.equals("grey"))) {

		display.setText(
			"You have entered an invalid value. \nPlease enter a valid value\n(green, red, grey)");
	    } else {
            shaper.setLinesColor(textFieldValue);
		display.setText("Here's your color");
	    }
	});
	HBox colorInputs = new HBox(colorTextField, colorButton);
	colorInputs.setAlignment(Pos.CENTER);
	VBox inputComponents = new VBox(10);
	inputComponents.setAlignment(Pos.CENTER);
	inputComponents.getChildren().addAll(colorLabel, colorLabel2, colorInputs);
	return inputComponents;
    }

    @Override
    public void start(Stage stage) {
	// create and configure text fields for input
	TextField lengthField = new TextField();
	lengthField.setMaxWidth(50);
	TextField heightField = new TextField();
	heightField.setMaxWidth(50);
	shaper = new Shaper();
	shaper.setRectangle();
	// create and configure a vertical container to hold all the components
	VBox root = new VBox(25);
	root.setAlignment(Pos.CENTER);
	root.getChildren().addAll(shapeBox(), colorBox(), display,
		shaper.getMainGroup());
	// create a new scene and add it to the stage
	Scene scene = new Scene(root, 600, 600);
	stage.setScene(scene);
	stage.setTitle("Oblong GUI");
	stage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

}
