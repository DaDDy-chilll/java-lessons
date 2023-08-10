import stanford.karel.Karel;

public class CheckerboardKarel extends Karel {

    public void run() {
        checker();
    }
    void checker(){
        if (frontIsBlocked()){
            goForwardForBlock();
        }else {
            goForwardForUnblock();
        }
    }
    void goForwardForBlock(){
        turnLeft();
        goForwardForUnblock();
//        turnLeft();
    }
    void goForwardForUnblock(){
        while (frontIsClear()) {
            putBeeper();
            moveTwoTimes();
        }
        if (facingNorth()){
          turnRight();
        }

    }

    void moveTwoTimes() {
        move();
        if(frontIsClear()){
            move();
            if(rightIsBlocked()){
                putBeeper();

            }
        }else {
            if (leftIsClear()){
                goToTop();
            }
        }

    }
    void goToTop(){
        if(facingEast()){
            topForEast();
        }else {
            toForWest();
        }
    }

    void topForEast(){
        turnLeft();
        if (frontIsClear()){
            move();
            turnLeft();

        }else {
//            turnLeft();
        }
    }
    void toForWest(){
        turnRight();
        if (frontIsClear()){
            move();
            turnRight();
        }

    }
    void turnRight(){
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

}
