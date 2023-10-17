import java.util.ArrayList;

public class Transaction {
    private int id;
    private double amount;
    private int delay ;
    private String type;
    private String payOrGet;

    public Transaction(int id,double amount,String type, String payOrGet){this(id,amount,type,4,payOrGet);}
    public Transaction(int id,double amount,String type,int delay,String payOrGet){
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

}
