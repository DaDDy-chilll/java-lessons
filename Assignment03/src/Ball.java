import acm.graphics.GOval;
import acm.util.RandomGenerator;

public class Ball extends GOval {
    private final static int BALL_RADIUS = 10; //Ball width

    public Ball(double x, double y){
        super(x,y,BALL_RADIUS * 2, BALL_RADIUS * 2);
        setFilled(true);
    }

    public boolean hitsTopWall() {
        return getY() <= 0;
    }

    public boolean isOutOfBounds(int screenWidth) {
        return(getX() + BALL_RADIUS * 2) >= screenWidth || getX() <= 0;
    }

}
