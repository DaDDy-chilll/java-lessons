import stanford.karel.Karel;

public class ExPickFruits extends Karel {
        public void run() {
                while (frontIsClear()){
                        move();
                }
                if(frontIsBlocked()){
                        turnLeft();
                        while (frontIsClear()){
                                move();
                                if (beepersPresent()){
                                        pickBeeper();
                                }
                                if (rightIsClear()){
                                        for (int i = 0; i < 3; i++) {
                                                        turnLeft();
                                                }

                                        }

                                }
                        turnLeft();
                        }



        }
}
