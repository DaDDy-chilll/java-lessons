import stanford.karel.Karel;

public class MidpointFindingKarel extends Karel {
    public void run() {
        findMid();
    }
    void findMid(){
        putBeeperEachSide();
       if (beepersPresent()){
           goToBeeper();
           putBeeperDown();
           clearRightBeeper();
           clearLeftBeeper();
           cameToCenter();
       }
        if (facingWest()){
            turnAround();
        }
    }

    void cameToCenter(){
        turnAround();
        goToBeeper();
        move();
    }

    void  clearRightBeeper(){
        while (frontIsClear()){
            move();
            if(beepersPresent()) {
                pickBeeper();
            }
        }
    }

    void clearLeftBeeper(){
        turnAround();
        goToBeeper();
        move();
        while (frontIsClear()){
            move();
            pickBeeper();
        }
    }

    void putBeeperDown(){
        while (noBeepersPresent()){
            putBeeper();
            turnAround();
            goToBeeper();
        }
    }

    void goToBeeper(){
        move();
        while (noBeepersPresent()){
            move();
        }
        goBackWard();
    }

    void putBeeperEachSide(){
        putBeeper();
        move();
        while(frontIsClear()){
            move();
            if (frontIsBlocked()){
                putBeeper();
            }
        }
        turnAround();
    }

    void goBackWard(){
        turnAround();
        move();
        turnAround();
    }

    void turnAround(){
        turnLeft();
        turnLeft();
    }
}

