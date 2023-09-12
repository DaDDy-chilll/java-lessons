import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Checkerboard extends GraphicsProgram {
    final int NUM_ROWS = 8;
    final int NUM_COLS = 8;
    final int SQUARE_SIZE = 60;
    final int CHECKER_SIZE = 40;
    public void run(){
        int boardWidth = NUM_COLS * SQUARE_SIZE;
        int boardHeight = NUM_ROWS * SQUARE_SIZE;
        int screenWidth = getWidth();
        int screenHeight = getHeight();
        int xOffset = (screenWidth - boardWidth) / 2;
        int yOffset = (screenHeight - boardHeight) / 2;

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                int x = col * SQUARE_SIZE + xOffset;
                int y = row * SQUARE_SIZE + yOffset;

                GRect square = new GRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
                square.setFilled((row + col) % 2 == 0);
                square.setColor(Color.GRAY);
                add(square);

                if ((row + col) % 2 == 0 && row < 3) {
                    int checkerX = x + (SQUARE_SIZE - CHECKER_SIZE) / 2;
                    int checkerY = y + (SQUARE_SIZE - CHECKER_SIZE) / 2;
                    GOval checker = new GOval(checkerX, checkerY, CHECKER_SIZE, CHECKER_SIZE);
                    checker.setFilled(true);
                    checker.setColor(Color.RED);
                    add(checker);
                }

                if ((row + col) % 2 == 0 && row > 4) {
                    int checkerX = x + (SQUARE_SIZE - CHECKER_SIZE) / 2;
                    int checkerY = y + (SQUARE_SIZE - CHECKER_SIZE) / 2;
                    GOval checker = new GOval(checkerX,checkerY, CHECKER_SIZE, CHECKER_SIZE);
                    checker.setFilled(true);
                    checker.setColor(Color.BLACK);
                    add(checker);
                }
            }
        }

    }
}
