import acm.graphics.GRect;
import java.awt.Color;

public class Paddle extends GRect {

    public Paddle(double x, double y , int width, int height) {
        super(x, y, width, height);
        setFilled(true);
        setColor(Color.BLACK);
    }

}
