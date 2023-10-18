import java.util.ArrayList;
import java.util.LinkedList;

public class TransactionDB {
    ArrayList<BuyTransaction> allBuyTransactions = new ArrayList<>();

    LinkedList<Tree> stockTransactions = new LinkedList<>();

    public TransactionDB(){};

    public void setBuyTransactions(BuyTransaction buyTransaction){
        allBuyTransactions.add(buyTransaction);
    }

    public void setStockTransactions(Tree tree){
        stockTransactions.add(tree);
    }

    public void removeAllStockTransactions(){
    stockTransactions.removeAll(stockTransactions);
    }

    public int getStockTransactinsSize(){return stockTransactions.size();}

    public double getSingleStockTransactionsBuyPrice(int i){return stockTransactions.get(i).getBuyPrice();}

    public String getStockTransactions(int i){
        return stockTransactions.get(i).getTree();
    }
    public String getAllBuyTransactions(int i){
        return allBuyTransactions.get(i).getTransactions();
    }

    public int getBuyTransactionSize(){
        return allBuyTransactions.size();
    }


    public LinkedList<BuyTransaction> getAllDebit() {
          ArrayList<BuyTransaction> debitTransaction = new ArrayList<>();
        for (int i = 0; i < getBuyTransactionSize(); i++) {
            BuyTransaction singleDebit = allBuyTransactions.get(i);
            if (getDebit(i)) {
                debitTransaction.add(singleDebit);
            }
        }
    }

    public boolean getDebit(int i){return getAllBuyTransactions(i).contains("debit");}


}
