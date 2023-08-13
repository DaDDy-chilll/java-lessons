import stanford.karel.Karel;

public class MidpointFindingKarel extends Karel {

    public void run() {
        findMid();
    }

    void findMid(){
        putBeeperEachSide();
        turnAround();
        goToBeeper();
        putBeeperDown();
        clearRightBeeper();
        clearLeftBeeper();
//        if(rightIsClear()){
        cameToCenter();
//        }
        if (rightIsClear()){
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
        while(frontIsClear()){
            move();
        }
        putBeeper();
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

