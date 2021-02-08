
/**
 * Shaper 
 * 
 * Holds and switches shapes' forms and colours.
 */
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Shaper
{
    // mainGroup holds the shape that is displayed.
    private Group mainGroup;
    private Color colour;
    private Polygon rectangle = new Polygon();
    private Polygon triangle = new Polygon();
    private Polygon hexagon = new Polygon();

    public Shaper() {
	// initialise mainGroup and colour
	mainGroup = new Group();
	colour = Color.RED;
	createShapes();
	setHexagon();
    }

    public void setTriangle() {
	mainGroup.getChildren().clear();
	mainGroup.getChildren().add(triangle);
    }

    public void setRectangle() {
	mainGroup.getChildren().clear();
	mainGroup.getChildren().add(rectangle);
    }

    public void setHexagon() {
	mainGroup.getChildren().clear();
	mainGroup.getChildren().add(hexagon);
    }

    public Group getMainGroup() {
	return mainGroup;
    }

    public void setLinesColour(String newColour) {
	if (newColour.equalsIgnoreCase("red")) {
	    colour = Color.RED;
	} else if (newColour.equalsIgnoreCase("green")) {
	    colour = Color.GREEN;

	} else if (newColour.equalsIgnoreCase("grey")) {
	    colour = Color.GREY;
	}
	resetColour();
    }

    private void createShapes() {

	triangle.getPoints()
		.addAll(new Double[] { 100.0, 70.0, 100.0, 250.0, 400.0, 250.0 });

	rectangle.getPoints().addAll(new Double[] { 100.0, 70.0, 100.0, 250.0, 400.0,
		250.0, 400.0, 70.0 });

	// For hexagon coordinates see:
	// https://www.mathopenref.com/coordpolycalc.html
	// hexagon center at (160, 250), radius = 100
	hexagon.getPoints().addAll(new Double[] { 210.0, 163.0, 110.0, 163.0, 110.0,
		163.0, 60.0, 250.0, 60.0, 250.0, 110.0, 337.0, 110.0, 337.0, 210.0,
		337.0, 210.0, 337.0, 260.0, 250.0, 260.0, 250.0, 210.0, 163.0 });

	resetColour();

    }

    private void resetColour() {
	triangle.setFill(colour);
	rectangle.setFill(colour);
	hexagon.setFill(colour);

    }

}