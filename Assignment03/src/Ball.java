import acm.graphics.*;

public class Ball {
    private GOval ball;
    private double x, y;
    private double vx, vy;

    public Ball() {
        ball = new GOval(400, 300, 20, 20);
        ball.setFilled(true);
        x = 400;
        y = 300;
        vx = 3;
        vy = 3;
    }

    public void move() {
        ball.move(vx, vy);

        if (ball.getX() < 0 || ball.getX() > Breakout.WIDTH - 20) {
            vx = -vx;
        }

        if (ball.getY() < 0) {
            vy = -vy;
        }
    }

    public void checkCollision(Paddle paddle, BrickWall brickWall) {
        GObject collider = brickWall.getCollidingObject(ball);

        if (collider == paddle.getGObject()) {
            vy = -vy;
        } else if (collider != null) {
            brickWall.removeBrick(collider);
            vy = -vy;
        }
    }

    public GObject getGObject() {
        return ball;
    }
}
