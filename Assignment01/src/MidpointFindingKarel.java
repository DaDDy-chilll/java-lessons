import stanford.karel.Karel;

public class MidpointFindingKarel extends Karel {

    public void run() {

           findMid();


    }

    void findMid(){
        putBeeperEndOftheSide();
        turnAround();
        goToBeeper();
        putBeeperDown();
        clearRightBeeper();
        clearLeftBeeper();
        if(rightIsClear()){
        cameToCenter();
        }
    }
    void cameToCenter(){

            turnAround();

        goToBeeper();
        move();
        print(" program end");

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
    void putBeeperEndOftheSide(){
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

