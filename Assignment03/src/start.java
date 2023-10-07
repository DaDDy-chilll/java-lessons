import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

public class start extends GraphicsProgram {
    //application width and height
    private static final int APPLICATION_WIDTH = 400;
    private static final int APPLICATION_HEIGHT = 600;

    //paddle
    final int PDL_WIDTH = 60; // paddle width
    final int PDL_HEIGHT = 10;// paddle height
    final int PDL_Y_OFFSET = 30; //paddle position
    //Ball
    private final int BALL_RADIUS = 10; //Ball width

    //Brick
    final int BRICKS_PER_ROW = 10; // one row 10 columns
    final int BRICK_ROWS = 10; // 10 rows
    final int BRICK_GAP = 4; // space between bricks
    final int BRICK_WIDTH =  (APPLICATION_WIDTH - (BRICKS_PER_ROW - 1) * BRICK_GAP) / BRICKS_PER_ROW - 2; // a Brick width
//    private static final int BRICK_SEP_X = 10;
    final int BRICK_HEIGHT = 8; // a brick height
    final int BRICK_Y_OFFSET = 30;//Brick position
    final int TURNS = 3; // how many play round

    private GRect paddle;
    private GOval ball;

    private double vx;
    private double vy;

    public void run(){
        setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
        addMouseListeners();
        createBricks();
        setPaddle();
        setupBall();
        moveBall();


    }

    private void setupBall() {
        ball = new GOval(200, 300, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        add(ball);

    }

    public void mouseClicked(MouseEvent e){
        initVelocity();
    }
    void initVelocity() {

        RandomGenerator rgen = RandomGenerator.getInstance();
        vy = 3;
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) vx = -vx;
        print("Clicked");

    }



    void moveBall() {
        int delay = 15;
        while (true) {
            checkCollision();
            ball.move(vx, vy);
//            if ((ball.getY() + BALL_RADIUS * 2) < getHeight() || ball.getY() <= 0) {
//                vy = -vy;
//            }

            if ((ball.getX() + BALL_RADIUS * 2) >= getWidth() || ball.getX() <= 0) {
                vx = -vx;
            }

            pause(delay);
        }
    }



    private void setPaddle () {
        double x = getWidth() / 2 - PDL_WIDTH / 2;
        double y =  getHeight() - PDL_Y_OFFSET - PDL_HEIGHT;
        paddle = new GRect(x,y,PDL_WIDTH,PDL_HEIGHT);
        paddle.setFilled(true);
        add(paddle);
    }

    public void mouseMoved(MouseEvent e) {
        double eX = e.getX();
        int dx = 1;
//        print("paddle" + paddle.getX()+ " ");
//        print("ex" + eX + " ");
        while ((paddle.getX() + PDL_WIDTH / 2) >= eX && paddle.getX() > 0  ) {
            paddle.move(-dx, 0);

        }
        while ((paddle.getX() + PDL_WIDTH / 2) <= eX && paddle.getX() + paddle.getWidth() != getWidth() ) {

            paddle.move(dx, 0);

        }
    }

    //Bricks
    private void createBricks(){
        double y = BRICK_Y_OFFSET;
        for (int row = 0; row < BRICK_ROWS; row++) {
            for (int col = 0; col < BRICKS_PER_ROW; col++) {
                double x = col * (BRICK_WIDTH + BRICK_GAP) + BRICK_GAP;
                GRect brick = getBrick(x,y,row);
                add(brick);
                x+=BRICK_WIDTH;
            }
            y+=BRICK_HEIGHT+BRICK_GAP;

        }
    }
    private GRect getBrick (double x, double y, int row ) {
        GRect brick = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
        brick.setFilled(true);
        if(row <= 1){
            brick.setFillColor(Color.RED);
        } else if (row <= 3) {
            brick.setFillColor(Color.ORANGE);

        } else if (row <= 5) {
            brick.setFillColor(Color.YELLOW);

        } else if (row <= 7) {
            brick.setFillColor(Color.GREEN);

        } else  {
            brick.setFillColor(Color.CYAN);

        }

        return brick;
    }

    private void checkCollision() {
        GObject collider = getCollidingObject();
        if (collider == paddle) {
            vy = -vy;
        } else if (collider != null && collider != paddle) {
            remove(collider);
            vy = -vy;
//            brickCount--;
        } else if ((ball.getY() + BALL_RADIUS * 2) > getHeight()) {
            removeAll();
        }
    }

    private GObject getCollidingObject() {
        if (getElementAt(ball.getX(), ball.getY()) != null) {
            return getElementAt(ball.getX(), ball.getY());
        } else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY()) != null) {
            return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
        } else if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2) != null) {
            return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
        } else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2) != null) {
            return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2);
        } else {
            return null;
        }
    }

}
