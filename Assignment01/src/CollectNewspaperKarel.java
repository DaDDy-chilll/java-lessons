import stanford.karel.Karel;

public class CollectNewspaperKarel extends Karel {

    public void run() {
      readNewsPaper();
    }

    void readNewsPaper() {
        goToWall();
        goToDoor();
        goToNews();
        goToStartPlace();
    }
    void goToStartPlace() {
        turnToBack();
        for (int i = 0; i < 2; i++) {
            goToWall();
        }

    }
    void turnToBack() {
        while(notFacingWest()){
            turnLeft();
        }
    }
    void  goToNews() {
        while (noBeepersPresent()){
            move();
        }
        pickBeeper();
    }
    void goToDoor() {
        while (leftIsBlocked()){
            move();
        }
        turnLeft();
    }
    void  goToWall () {
        while (frontIsClear()){
            move();
        }
        turnRight();
    }
    void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

}
