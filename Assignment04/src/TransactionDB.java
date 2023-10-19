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
    public int getStockTransactionsSize(){return stockTransactions.size();}
    public double getSingleStockTransactionsBuyPrice(int i){return stockTransactions.get(i).getBuyPrice();}
    public double getSingleStockTransactionsSellPrice(int i){return stockTransactions.get(i).getSellPrice();}
    public String getStockTransactionsForOwer(int i){
        return stockTransactions.get(i).getTreeForOwner();
    }
    public String getStockTransactionsForCustomer(int i){
        return stockTransactions.get(i).getTreeForCustomer();
    }
    public String getAllBuyTransactions(int i){
        return allBuyTransactions.get(i).getTransactions();
    }
    public int getBuyTransactionSize(){
        return allBuyTransactions.size();
    }
    public ArrayList<BuyTransaction> getAllDebit() {
          ArrayList<BuyTransaction> debitTransaction = new ArrayList<>();
        for (int i = 0; i < getBuyTransactionSize(); i++) {
            String isDebit = allBuyTransactions.get(i).getType();
            if(!"debit".equals(isDebit)) continue;
            BuyTransaction singleDebit = allBuyTransactions.get(i);
            debitTransaction.add(singleDebit);
        }
        return debitTransaction;
    }
}
