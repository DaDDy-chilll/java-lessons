import stanford.karel.Karel;

public class CleanAllStreet extends Karel {
    public void run(){
        cleanAllStreet();
    }
    void cleanAllStreet(){

        // n အတွက်
        cleanAStreet();
        turnAround();
        comeBack();
        turnAround();

        //  n - 1 အတွက်
        if(leftIsClear()){
            moveToNextStree();
            cleanAllStreet();
        }
    }
    void cleanAStreet(){
        if(beepersPresent()){
            pickBeeper();
        }

        //solve n - 1
        if(frontIsClear()){
            move();
            cleanAStreet();
        }
    }

    void moveToNextStree(){
        turnLeft();
        move();
        turnRight();
    }
    void comeBack(){
        if(frontIsClear()){
            move();
            comeBack();
        }
    }

    void turnAround(){
        turnLeft();
        turnLeft();
    }
    void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
