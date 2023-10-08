import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

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
    final int BRICK_WIDTH = (APPLICATION_WIDTH - (BRICKS_PER_ROW - 1) * BRICK_GAP) / BRICKS_PER_ROW; // a Brick width
    final int BRICK_HEIGHT = 8; // a brick height
    final int BRICK_Y_OFFSET = 70;//Brick position
    final int TURNS = 3; // how many play round

    private GRect paddle;
    private GOval ball;

    public void run(){
        addMouseListeners();
        createBricks();
        setPaddle();
    }

    private void setPaddle () {
        double x = (getWidth() / 2 )- (PDL_WIDTH /2);
        double y = (getHeight() / 2 ) -(PDL_Y_OFFSET - PDL_HEIGHT );
        paddle = new GRect(x,y,PDL_WIDTH,PDL_HEIGHT);
        paddle.setFilled(true);
        add(paddle);
    }

    public void mouseMoved(MouseEvent e) {
        double eX = e.getX();

        int dx = 1;
        while ((paddle.getX() + PDL_WIDTH / 2) >= eX) {
//            if (getWidth() - paddle.getWidth() > eX) return; // 29<>30  722
            paddle.move(-dx, 0);
        }
        while ((paddle.getX() + PDL_WIDTH / 2) <= eX) {
            paddle.move(dx, 0);
        }
    }

    //Bricks
    private void createBricks(){
        double x = 0 ;
        double y = BRICK_Y_OFFSET;
        for (int row = 0; row < BRICK_ROWS; row++) {
            x=BRICK_GAP;

            for (int col = 0; col < BRICKS_PER_ROW; col++) {
                GRect brick = getBrick(x,y,row);
                add(brick);
                x+=BRICK_WIDTH+BRICK_GAP;
            }

            x=0;
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


}
