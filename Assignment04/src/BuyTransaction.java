import java.util.ArrayList;

public class BuyTransaction {
    private final int id;
    private final double amount;
    private int delay ;
    private final String type;
    private String payOrGet;

    public BuyTransaction(int id, double amount, String type, String payOrGet){this(id,amount,type,4,payOrGet);}
    public BuyTransaction(int id, double amount, String type, int delay, String payOrGet){
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.delay = delay;
        this.payOrGet = payOrGet;
    }
    public String getTransactions(){
        return id + "\t" +amount + "\t" + type + "\t" + delay +"\t" + payOrGet;
    }
    public String getType(){return this.type;}
    public String getPayOrGet(){return this.payOrGet;}
    public void setPayOrGet(){this.payOrGet = "paid";}
    public double getAmount(){return this.amount;}
    public int getDelay(){return this.delay;}
    public void setDelay(){this.delay--;}
}
