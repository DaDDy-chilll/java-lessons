import stanford.karel.Karel;

public class StoneMasonKarel extends Karel {

    public void run() {
     stoneMason();
    }

    void stoneMason(){
        while (frontIsClear()){
            fillStone();
            moveFourTime();
        }
        fillStone();
    }
    void fillStone(){
        goToTop();
        goToBottom();
    }
    void goToTop() {
        turnLeft();
        goForward();
    }
    void goToBottom(){
        turnLeft();
        turnLeft();
        goForward();
        turnLeft();
    }
    void goForward(){
        isPutBeeper();
        while (frontIsClear()){
            isPutBeeper();
            move();

        }
    }
    void isPutBeeper() {
        if(noBeepersPresent()){
            putBeeper();
        }
    }

    void moveFourTime() {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

}
