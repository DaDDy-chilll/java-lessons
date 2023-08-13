import stanford.karel.Karel;

public class CheckerboardKarel extends Karel {
    public void run(){
        startCheckerBoard();
    }
    void startCheckerBoard(){
        while (frontIsClear()){
            goToFrontForEven();
        }
        if (frontIsBlocked()){
            continueOrEnd();
        }
        changePosition();
    }

    void continueOrEnd(){
        if (leftIsClear()){
            turnLeft();
            if (leftIsBlocked()){
                goToFrontForEven();
            }else {
                changePosition();
                goToFrontForOdd();
            }
        }
    }

    void goToFrontForEven(){
        while (frontIsClear()){
            isPutBeeper();
            move();
            if (frontIsClear()){
                move();
                isPutBeeper();
            }else {
              nextLane();

            }

        }
    }

    void goToFrontForOdd(){
        while (leftIsClear()){
                nextLane();
            while (frontIsClear()){
                move();
                goToFrontForEven();

            }
            if (rightIsBlocked()){
                turnRight();
            }
        }


    }
    void nextLane(){
        if (facingWest()){
            if (rightIsClear()){
                goToTop();
            }
        }
        if (facingEast()){
            if (leftIsClear()){
                goToTop();
            }
        }
    }

    void goToTop() {
         if (frontIsBlocked()){
             if (facingWest()){
                 turnRight();
                 move();
                 turnRight();
             }
         }
         if (frontIsBlocked()){
             if(facingEast()) {
                 turnLeft();
                 move();
                 turnLeft();
             }
         }

    }


    void isPutBeeper(){
        if (noBeepersPresent()){
            putBeeper();
        }

    }

    void changePosition(){
        while (notFacingEast()){
            turnLeft();
        }
    }





    void turnRight(){
        for (int i = 0; i < 3; i++) {
            turnLeft();

        }
    }

}
