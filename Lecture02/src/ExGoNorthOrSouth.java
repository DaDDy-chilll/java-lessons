import stanford.karel.Karel;

public class ExGoNorthOrSouth extends Karel {

        public void run() {
                move();
                move();
                if (beepersPresent()){
                        while(notFacingNorth()){
                                turnLeft();
                        }
                }else {
                        while (notFacingSouth()){
                                turnLeft();
                        }
                }
                move();
                move();
                if (beepersPresent()){
                        pickBeeper();
                }


        }

}
