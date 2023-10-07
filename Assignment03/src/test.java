import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class test extends GraphicsProgram {
    // Constants
    private static final int WIDTH = 800;     // Width of the canvas
    private static final int HEIGHT = 600;    // Height of the canvas
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 10;
    private static final int BRICK_WIDTH = 60;
    private static final int BRICK_HEIGHT = 20;
    private static final int NBRICKS_PER_ROW = 10;
    private static final int NBRICK_ROWS = 10;
    private static final int BALL_RADIUS = 10;
    private static final int BRICK_SEP = 4;
    private static final int PADDLE_Y_OFFSET = 30;
    private static final int BALL_Y_OFFSET = 50;
    private static final int NTURNS = 3;

    private GRect paddle;
    private GOval ball;
    private double vx, vy;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private int brickCount = NBRICKS_PER_ROW * NBRICK_ROWS;
    private int turns = NTURNS;

    public void run() {
        setupGame();
        while (turns > 0 && brickCount > 0) {
            moveBall();
            checkCollision();
            pause(10);
        }
        gameOver();
    }

    private void setupGame() {
        setSize(WIDTH, HEIGHT);
        createBricks();
        createPaddle();
        createBall();
        addMouseListeners();
    }

    private void createBricks() {
        for (int i = 0; i < NBRICK_ROWS; i++) {
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                int x = j * (BRICK_WIDTH + BRICK_SEP);
                int y = i * (BRICK_HEIGHT + BRICK_SEP) + BRICK_SEP;
                GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                switch (i) {
                    case 0:
                    case 1:
                        brick.setColor(Color.RED);
                        break;
                    case 2:
                    case 3:
                        brick.setColor(Color.ORANGE);
                        break;
                    case 4:
                    case 5:
                        brick.setColor(Color.YELLOW);
                        break;
                    case 6:
                    case 7:
                        brick.setColor(Color.GREEN);
                        break;
                    case 8:
                    case 9:
                        brick.setColor(Color.CYAN);
                        break;
                }
                add(brick);
            }
        }
    }

    private void createPaddle() {
        paddle = new GRect((WIDTH - PADDLE_WIDTH) / 2, HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle);
    }

    private void createBall() {
        ball = new GOval((WIDTH - BALL_RADIUS * 2) / 2, (HEIGHT - BALL_RADIUS * 2) / 2, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        add(ball);
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) vx = -vx;
        vy = 3.0;
    }

    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        if (mouseX < 0) {
            mouseX = 0;
        } else if (mouseX > WIDTH - PADDLE_WIDTH) {
            mouseX = WIDTH - PADDLE_WIDTH;
        }
        paddle.setLocation(mouseX, HEIGHT - PADDLE_Y_OFFSET);
    }

    private void moveBall() {
        ball.move(vx, vy);
        if (ball.getX() < 0 || ball.getX() > WIDTH - BALL_RADIUS * 2) {
            vx = -vx;
        }
        if (ball.getY() < 0) {
            vy = -vy;
        }
        if (ball.getY() > HEIGHT - BALL_RADIUS * 2) {
            turns--;
            if (turns > 0) {
                remove(ball);
                createBall();
            }
        }
    }

    private void checkCollision() {
        GObject collider = getCollidingObject();
        if (collider == paddle) {
            vy = -vy;
        } else if (collider != null && collider != paddle) {
            remove(collider);
            vy = -vy;
            brickCount--;
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

    private void gameOver() {
        removeAll();
        GLabel gameOverLabel = new GLabel("Game Over", WIDTH / 2, HEIGHT / 2);
        gameOverLabel.setFont("Arial-Bold-48");
        add(gameOverLabel);
    }

    public static void main(String[] args) {
        new Breakout().start();
    }
}
