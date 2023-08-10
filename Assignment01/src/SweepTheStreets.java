import stanford.karel.Karel;

public class SweepTheStreets extends Karel {

    public void run() {
        sweepAllStreets();
    }
    void sweepAllStreets () {
            while (leftIsClear()){
                cleanAllBeeper();
            }
            goForward();
            turnToBack();
            goForward();
            turnLeft();
            turnLeft();
    }
    void cleanAllBeeper() {
                goForward();
                turnToBack();
                goForward();
                goToTop();
    }

    void goForward () {
        while(frontIsClear()){
            isPickBeeper();
            move();

        }
    }
    void isPickBeeper(){
        if(beepersPresent()){
            pickBeeper();
        }
    }
    void turnToBack() {
        while (notFacingWest()){
            turnLeft();
        }
    }
    void goToTop(){
        while(notFacingNorth()){
            turnLeft();
        }
        move();
        isPickBeeper();
        turnToRight();
    }

    void turnToRight()  {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
