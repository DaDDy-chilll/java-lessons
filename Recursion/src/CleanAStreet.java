import stanford.karel.Karel;

public class CleanAStreet extends Karel {
    public void run(){
        cleanAStreet();
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
}
