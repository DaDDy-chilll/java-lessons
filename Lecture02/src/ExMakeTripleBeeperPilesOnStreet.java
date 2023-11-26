import stanford.karel.Karel;

public class ExMakeTripleBeeperPilesOnStreet extends Karel {

        public void run() {
               while (frontIsClear()){
                       for (int i = 0; i < 3; i++) {
                               putBeeper();
                       }
                       move();
               }
                for (int i = 0; i < 3; i++) {
                        putBeeper();
                }
        }
}
