import stanford.karel.Karel;

public class ExFaceNorth extends Karel {
        public void run() {
                if (notFacingNorth()){
                        while (notFacingNorth()){
                                turnLeft();
                                if (facingNorth()){
                                        move();
                                }
                        }
                }else {
                        move();
                }
        }

}
