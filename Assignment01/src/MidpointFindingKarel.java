import stanford.karel.Karel;

public class MidpointFindingKarel extends Karel {

    public void run() {
        putBeeper();
        goForward();
        putBeeper();
        turnAround();
        goToBeeper();
        turnAround();
    }

    void goToBeeper(){
        move();
        while (noBeepersPresent()){
            move();
        }
    }
    void goForward(){
        while(frontIsClear()){
            move();
        }
    }

    void turnAround(){
        turnLeft();
        turnLeft();
    }

}

