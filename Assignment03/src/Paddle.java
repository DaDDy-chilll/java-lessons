import acm.graphics.*;

public class Paddle {
    private GRect paddle;
    private double x, y;

    public Paddle() {
        paddle = new GRect(350, 550, 100, 10);
        paddle.setFilled(true);
        x = 350;
        y = 550;
    }

    public void move(int mouseX) {
        x = mouseX - 50;

        if (x < 0) {
            x = 0;
        } else if (x > Breakout.WIDTH - 100) {
            x = Breakout.WIDTH - 100;
        }

        paddle.setLocation(x, y);
    }

    public GObject getGObject() {
        return paddle;
    }
}
