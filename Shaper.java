
/**
 * Shaper 
 * 
 * Holds and switches shapes' forms and colours.
 */
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Shaper
{
    // mainGroup holds the shape that is displayed.
    private Group mainGroup;
    private Color colour;
    private Line[] rectangle = new Line[4];
    private Line[] triangle = new Line[3];
    private Line[] hexagon = new Line[6];

    public Shaper() {
	// initialise mainGroup and colour
	mainGroup = new Group();
	colour = Color.RED;
	createShapes();
	resetAllShapesColour();
	setHexagon();
    }

    public void setTriangle() {
	removeShapes();
	mainGroup.getChildren().addAll(triangle);
    }

    public void setRectangle() {
	removeShapes();
	mainGroup.getChildren().addAll(rectangle);
    }

    public void setHexagon() {
	// For coordinates see: https://www.mathopenref.com/coordpolycalc.html
	removeShapes();
	mainGroup.getChildren().addAll(hexagon);
    }

    public Group getMainGroup() {
	return mainGroup;
    }

    public void setLinesColour(String newColour) {
	if (newColour.equalsIgnoreCase("red")) {
	    colour = Color.RED;
	} else if (newColour.equalsIgnoreCase("green")) {
	    colour = Color.GREEN;

	} else if (newColour.equalsIgnoreCase("grey")
		|| newColour.equalsIgnoreCase("gray")) {
	    colour = Color.GREY;
	}
	resetAllShapesColour();
    }

    private void createShapes() {

	rectangle[0] = new Line(100, 70, 100, 250);
	rectangle[1] = new Line(100, 250, 400, 250);
	rectangle[2] = new Line(400, 250, 400, 70);
	rectangle[3] = new Line(100, 70, 400, 70);

	triangle[0] = new Line(100, 70, 100, 250);
	triangle[1] = new Line(100, 250, 400, 250);
	triangle[2] = new Line(400, 250, 100, 70);

	hexagon[0] = new Line(295, 82, 205, 82);
	hexagon[1] = new Line(205, 82, 160, 160);
	hexagon[2] = new Line(160, 160, 205, 238);
	hexagon[3] = new Line(205, 238, 295, 238);
	hexagon[4] = new Line(295, 238, 340, 160);
	hexagon[5] = new Line(340, 160, 295, 82);

    }

    private void removeShapes() {
	mainGroup.getChildren().clear();
    }

    private void resetShapeColour(Line[] shape) {
	for (int i = 0; i < shape.length; i++) {
	    shape[i].setStroke(colour);
	}
    }

    private void resetAllShapesColour() {
	resetShapeColour(rectangle);
	resetShapeColour(triangle);
	resetShapeColour(hexagon);
    }

}