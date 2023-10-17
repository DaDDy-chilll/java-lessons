import java.util.ArrayList;

public class TransactionDB {
    ArrayList<Transaction> allTransactions = new ArrayList<>();


    public TransactionDB(){};

    public void setAllTransactions(Transaction transaction){
        allTransactions.add(transaction);
    }

    public String getAllTransactions(int i){
        return allTransactions.get(i).getTransactions();
    }

    public int getsize(){
        return allTransactions.size();
    }


    public String getAllDebit(int i) {
         return allTransactions.get(i).getType();
    }


}
