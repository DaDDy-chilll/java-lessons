public class Balance {
    private double BALANCE = 100_000;

    public Balance(){
    }

    public double getBalance() {return this.BALANCE;}

    public void increaseBalance(double amount){
        this.BALANCE += amount;
    }

    public void decreaseBalance(double amount){
        this.BALANCE -= amount;
    }


}
