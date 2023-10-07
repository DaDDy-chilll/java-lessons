import acm.graphics.*;
import java.awt.*;

public class BrickWall {
    private GCompound brickWall;
    private int brickCount;

    public BrickWall() {
        brickWall = new GCompound();
        brickCount = 0;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                GRect brick = new GRect(col * 80, row * 20, 80, 20);
                brick.setFilled(true);
                brick.setColor(getBrickColor(row));
                brickWall.add(brick);
                brickCount++;
            }
        }
    }

    public GObject getGObject() {
        return brickWall;
    }

    public GObject getCollidingObject(GObject obj) {
        return brickWall.getElementAt(obj.getX(), obj.getY());
    }

    public void removeBrick(GObject brick) {
        brickWall.remove(brick);
        brickCount--;

        if (brickCount == 0) {
            brickWall.removeAll();
        }
    }

    public boolean isCleared() {
        return brickCount == 0;
    }

    private Color getBrickColor(int row) {
        switch (row) {
            case 0:
            case 1:
                return Color.RED;
            case 2:
            case 3:
                return Color.ORANGE;
            default:
                return Color.YELLOW;
        }
    }
}
