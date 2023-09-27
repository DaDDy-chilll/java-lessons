import stanford.karel.Karel;

public class FillBeeperRow extends Karel {
    public void run() {
        makeBeeperRow();
    }

    void makeBeeperRow(){

        // အငယ်ဆုံး n အတွက်
        putBeeper();

        // n-1 အပိုင်း
        if(frontIsClear()){
            move();
            makeBeeperRow();
        }
    }
}
