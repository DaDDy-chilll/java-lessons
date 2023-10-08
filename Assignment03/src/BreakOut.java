import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BreakOut extends GraphicsProgram {
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
    final int BRICKS_PER_ROW = 1; // one row 10 columns
    final int BRICK_ROWS = 1; // 10 rows
    final int BRICK_GAP = 4; // space between bricks
    final int BRICK_WIDTH =  (APPLICATION_WIDTH - (BRICKS_PER_ROW - 1) * BRICK_GAP) / BRICKS_PER_ROW - 2; // a Brick width
    final int BRICK_HEIGHT = 8; // a brick height
    final int BRICK_Y_OFFSET = 30;//Brick position
    private int TURNS = 3; // how many play round
    private Paddle paddle;
    private Ball ball;
    private Brick brick;

    private double vx;
    private double vy;
    private int brickCount = 0;


    public void run(){
        setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
        setupGame();
        waitForClick();
        initVelocity();

       while (TURNS > 0){
           moveBall();
           if(TURNS > 0){
               waitForClick();
               resetGame();
           }
           if(TURNS == 0){
               removeAll();
               gameWinOrLose("Game Over! Click to restart.");
               waitForClick();
               TURNS=3;
               resetGame();
           }
       }
    }

    private void resetGame(){
        brickCount=0;
        removeAll();
        setupGame();
    }

    private void setupGame(){
        createBricks();
        setPaddle();
        setupBall();
        addMouseListeners();
    }

    //Ball
    private void setupBall() {
        ball = new Ball(200,300);
        add(ball);
    }

    void initVelocity() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        vy = 3;
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) vx = -vx;

    }
    void moveBall() {
        int delay = 15;
        while (true) {
            ball.move(vx, vy);
            pause(delay);
            if(ball.isOutOfBounds(getWidth())){
                vx = -vx;
            }

            if(ball.hitsTopWall()){
                vy = -vy;
            }

            GObject collider = getCollidingObject();

            if(brickCount == 0){
                TURNS=3;
                removeAll();
                gameWinOrLose("Your victory! Click to play again.");
                break;
            }else if (collider == paddle) {
                vy = -vy;
            } else if (collider != null && collider != paddle) {
                remove(collider);
                vy = -vy;
                brickCount--;
            } else if ((ball.getY() + BALL_RADIUS * 2) > getHeight()) {
                TURNS--;
                removeAll();
                gameWinOrLose("You Lose! Click to play next turn.");
                break;
            }
        }
    }

    //Paddle
    private void setPaddle () {
        double x = getWidth() / 2 - PDL_WIDTH / 2;
        double y =  getHeight() - PDL_Y_OFFSET - PDL_HEIGHT;
        paddle = new Paddle(x,y,PDL_WIDTH,PDL_HEIGHT);
        add(paddle);
    }

    public void mouseMoved(MouseEvent e) {
        double eX = e.getX();
        int dx = 1;
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
                 brick = new Brick(x,y,row,BRICK_WIDTH,BRICK_HEIGHT);
                add(brick);
                x+=BRICK_WIDTH;
                brickCount++;
            }
            y+=BRICK_HEIGHT+BRICK_GAP;

        }
    }

    private  void gameWinOrLose(String text){
        GLabel gameLabel = new GLabel(text, (APPLICATION_WIDTH / 2), APPLICATION_HEIGHT / 2);
        gameLabel.setFont("Arial-Bold-20");
        gameLabel.setColor(Color.red);
        gameLabel.move(-gameLabel.getWidth() /2,-gameLabel.getHeight() /2);
        add(gameLabel);
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
