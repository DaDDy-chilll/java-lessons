import stanford.karel.Karel;

public class ExGoAroundTheWorld extends Karel {
        public void run() {
                while (frontIsClear()){
                        move();
                }
                while(frontIsBlocked()){
                        turnLeft();
                        while (frontIsClear()){
                                move();
                        }
                }
        }

}
