import stanford.karel.Karel;

public class CheckerboardKarel extends Karel {

    public void run() {
        checker();
    }
    void checker(){
        if (frontIsClear()){
            goForwardForUnblock();
        }

            goForwardForBlock();
        while (frontIsBlocked()){
           if (leftIsClear()){
               goForwardForBlock();
           }

        }


    }
    void goForwardForBlock(){

        turnLeft();
        if (frontIsClear()){
            if (leftIsClear()){
                move();
                turnLeft();
                move();
            }
        }

           goForwardForUnblock();

//        turnLeft();
    }
    void goForwardForUnblock(){
        while (frontIsClear()) {
            isPutBeeper();

                moveTwoTimes();

        }

        if (facingNorth()){
            turnRight();
        }



    }

    void isPutBeeper(){
        if (frontIsBlocked()){
            if (rightIsBlocked()){
                putBeeper();
            }
        }
            if (noBeepersPresent()){
                putBeeper();
            }

    }

    void moveTwoTimes() {
        move();
        if(frontIsClear()){
            move();
            print("put ");
            isPutBeeper();
        }else {
            if (leftIsClear()){
                goToTop();
            }
        }
    }
    void goToTop(){
        if (facingNorth()){
            if (frontIsBlocked()){
                turnLeft();
                move();
            }
        }else {
            if(facingEast()){
                topForEast();
            }else {
                toForWest();
            }
        }
    }

    void topForEast(){
        turnLeft();
        if (frontIsClear()){
            move();
            turnLeft();

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
