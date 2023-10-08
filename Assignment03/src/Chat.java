import acm.graphics.GLabel;
import acm.program.*;
import acm.util.*;

import java.awt.event.MouseEvent;

public class Chat extends GraphicsProgram {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public void run() {
        setSize(WIDTH, HEIGHT);

        Ball ball = new Ball();
        Paddle paddle = new Paddle();
        BrickWall brickWall = new BrickWall();

        add(ball.getGObject());
        add(paddle.getGObject());
        add(brickWall.getGObject());

        addMouseListeners();

        while (!brickWall.isCleared()) {
            ball.move();
            ball.checkCollision(paddle, brickWall);
            pause(10);
        }

        removeAll();
        addGameOverLabel();
    }

    private void addGameOverLabel() {
        GLabel gameOverLabel = new GLabel("Game Over", WIDTH / 2, HEIGHT / 2);
        gameOverLabel.setFont("Arial-Bold-48");
        add(gameOverLabel);
    }

    public void mouseMoved(MouseEvent e) {
        Paddle paddle = new Paddle();
        int mouseX = e.getX();
        paddle.move(mouseX);
    }

    public static void main(String[] args) {
        new Breakout().start();
    }
}
