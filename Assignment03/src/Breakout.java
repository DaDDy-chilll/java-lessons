import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Breakout extends GraphicsProgram {

        public static final int APPLICATION_WIDTH = 400;
        public static final int APPLICATION_HEIGHT = 600;

        final int PDL_WIDTH = 60;       // paddle width
        final int PDL_HEIGHT = 10;      // paddle height
        final int PDL_Y_OFFSET = 30;    // distance between bottom wall and bottom of baddle

        private final int BALL_RADIUS = 10;     // size of ball will be (2 * BALL_RADIUS), you can change this value according to your taste

        final int BRICKS_PER_ROW = 10;
        final int BRICK_ROWS = 10;
        final int BRICK_GAP = 4;        // horizontal and vertical gap between bricks rows and brick columns
        final int BRICK_WIDTH =
                        (APPLICATION_WIDTH - (BRICKS_PER_ROW - 1) * BRICK_GAP) / BRICKS_PER_ROW;
        final int BRICK_HEIGHT = 8;
        final int BRICK_Y_OFFSET = 70;  // distance from y = 0 (above wall) to top of the first row of bricks

        final int TURNS = 3;            // Number of turns for one game

        private GOval ball = null;
        private GRect paddle = null;
        private int remainingBricks;    // to store remaining brick count

        private double vx = 0;          // horizontal velocity
        private double vy = 0;          // vertical velocity

        public void run() {

        }
}
