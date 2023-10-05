//import acm.graphics.*;
//import acm.program.*;
//import acm.util.*;
//
//public class test extends ConsoleProgram {
//    private static final int WIDTH = 400;
//    private static final int HEIGHT = 600;
//    private static final int PADDLE_WIDTH = 60;
//    private static final int PADDLE_HEIGHT = 10;
//    private static final int BALL_RADIUS = 10;
//    private static final int BRICK_WIDTH = 50;
//    private static final int BRICK_HEIGHT = 20;
//    private static final int NUM_BRICKS_PER_ROW = 10;
//    private static final int NUM_ROWS = 5;
//    private static final int DELAY = 10;
//
//    private GRect paddle;
//    private GOval ball;
//    private int dx = 2;
//    private int dy = 2;
//
//    public void run() {
//        addMouseListeners();
//
//        setupGame();
//        while (true) {
//            moveBall();
//            checkCollision();
//            pause(DELAY);
//        }
//
//    }
//
//    private void setupGame() {
//
//        setSize(WIDTH, HEIGHT);
//        createPaddle();
//        createBall();
//        createBricks();
//    }
//
//    private void createPaddle() {
//        paddle = new GRect((WIDTH - PADDLE_WIDTH) / 2, HEIGHT - PADDLE_HEIGHT - 20, PADDLE_WIDTH, PADDLE_HEIGHT);
//        paddle.setFilled(true);
//        add(paddle);
//    }
//
//    private void createBall() {
//        ball = new GOval((WIDTH - BALL_RADIUS) / 2, (HEIGHT - BALL_RADIUS) / 2, BALL_RADIUS, BALL_RADIUS);
//        ball.setFilled(true);
//        add(ball);
//    }
//
//    private void createBricks() {
//        for (int row = 0; row < NUM_ROWS; row++) {
//            for (int col = 0; col < NUM_BRICKS_PER_ROW; col++) {
//                double x = col * (BRICK_WIDTH + 5);
//                double y = row * (BRICK_HEIGHT + 5);
//                GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
//                brick.setFilled(true);
//                add(brick);
//            }
//        }
//    }
//
//    public void mouseMoved(MouseEvent e) {
//        double x = e.getX() - PADDLE_WIDTH / 2;
//        if (x < 0) {
//            x = 0;
//        } else if (x > WIDTH - PADDLE_WIDTH) {
//            x = WIDTH - PADDLE_WIDTH;
//        }
//        paddle.setLocation(x, HEIGHT - PADDLE_HEIGHT - 20);
//    }
//
//    private void moveBall() {
//        ball.move(dx, dy);
//    }
//
//    private void checkCollision() {
//        if (ball.getX() < 0 || ball.getX() + BALL_RADIUS > WIDTH) {
//            dx = -dx;
//        }
//        if (ball.getY() < 0 || ball.getY() + BALL_RADIUS > HEIGHT) {
//            dy = -dy;
//        }
//        GObject collider = getCollidingObject();
//        if (collider == paddle) {
//            dy = -dy;
//        } else if (collider != null) {
//            remove(collider);
//            dy = -dy;
//        }
//    }
//
//    private GObject getCollidingObject() {
//        if (getElementAt(ball.getX(), ball.getY()) != null) {
//            return getElementAt(ball.getX(), ball.getY());
//        } else if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY()) != null) {
//            return getElementAt(ball.getX() + BALL_RADIUS, ball.getY());
//        } else if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS) != null) {
//            return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS);
//        } else if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS) != null) {
//            return getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS);
//        } else {
//            return null;
//        }
//    }
//
//}
