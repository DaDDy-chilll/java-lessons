import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Pyramid extends GraphicsProgram {
    final int BRICK_WIDTH = 30;
    final int BRICK_HEIGHT = 12;
    final int BRICKS_IN_BASE = 14;
    public  void run() {
        int screenWidth = getWidth();
        int screenHeight = getHeight();
        int pyramidWidth = BRICKS_IN_BASE * BRICK_WIDTH;

        for (int row = 0; row < BRICKS_IN_BASE; row++) {
            int bricksInRow = BRICKS_IN_BASE - row;
            int xOffset = (screenWidth - pyramidWidth) / 2 + row * (BRICK_WIDTH / 2);
            int yOffset = screenHeight - (row + 1) * BRICK_HEIGHT;

            for (int brick = 0; brick < bricksInRow; brick++) {
                int brickX = xOffset + brick * BRICK_WIDTH;
                GRect brickRect = new GRect(brickX, yOffset, BRICK_WIDTH, BRICK_HEIGHT);
                add(brickRect);
            }
        }
    }
}
