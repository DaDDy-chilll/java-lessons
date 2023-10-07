import acm.graphics.GRect;

import java.awt.*;

public class Brick extends GRect {
    public Brick(double x,double y, int row,double width, double height){
        super(x,y,width,height);
        setFilled(true);
        setColorByRow(row);
    }

    private void setColorByRow(int row){
        if(row <= 1){
            setFillColor(Color.RED);
        } else if (row <= 3) {
            setFillColor(Color.ORANGE);

        } else if (row <= 5) {
            setFillColor(Color.YELLOW);

        } else if (row <= 7) {
            setFillColor(Color.GREEN);

        } else  {
            setFillColor(Color.CYAN);
        }

    }
}
