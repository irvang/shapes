
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Shaper
{
    private Group mainGroup;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;
    private Line line5;
    private Line line6;
    private Color color;

    public Shaper() {
	// initialize mainGroup
	mainGroup = new Group();
	setHexagon();
	color = Color.RED;
    }

    public Group getMainGroup() {
	return mainGroup;
    }

    public void setTriangle() {
	mainGroup.getChildren().removeAll(line1, line2, line3, line4, line5, line6);
	line1 = new Line(100, 70, 100, 250);
	line2 = new Line(100, 250, 400, 250);
	line3 = new Line(400, 250, 100, 70);
	resetColor();
	mainGroup.getChildren().addAll(line1, line2, line3);
    }

    public void setRectangle() {
	mainGroup.getChildren().removeAll(line1, line2, line3, line4, line5, line6);
	line1 = new Line(100, 70, 100, 250);
	line2 = new Line(100, 250, 400, 250);
	line3 = new Line(400, 250, 400, 70);
	line4 = new Line(100, 70, 400, 70);
	resetColor();
	mainGroup.getChildren().addAll(line1, line2, line3, line4);
    }

    private void resetColor() {
	line1.setStroke(color);
	line2.setStroke(color);
	line3.setStroke(color);
	line4.setStroke(color);
	line5.setStroke(color);
	line6.setStroke(color);
    }

    public void setHexagon() {
	// https://www.mathopenref.com/coordpolycalc.html
	mainGroup.getChildren().removeAll(line1, line2, line3, line4, line5, line6);
	line1 = new Line(295, 82, 205, 82);
	line2 = new Line(205, 82, 160, 160);
	line3 = new Line(160, 160, 205, 238);
	line4 = new Line(205, 238, 295, 238);
	line5 = new Line(295, 238, 340, 160);
	line6 = new Line(340, 160, 295, 82);
	resetColor();
	mainGroup.getChildren().addAll(line1, line2, line3, line4, line5, line6);
    }

    public void setLinesColor(String newColor) {
	if (newColor.equalsIgnoreCase("red")) {
	    color = Color.RED;
	} else if (newColor.equalsIgnoreCase("green")) {
	    color = Color.GREEN;

	} else if (newColor.equalsIgnoreCase("grey")
		|| newColor.equalsIgnoreCase("gray")) {
	    color = Color.GREY;
	}
	resetColor();
    }

}