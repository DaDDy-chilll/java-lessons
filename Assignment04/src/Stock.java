import java.util.LinkedList;

public class Stock {
     LinkedList<Tree> tree = new LinkedList<>();

     public Stock(){

     }

    public String getAllStock(int i){
             return  this.tree.get(i).getTree();
    }

    public int getSize(){
         return this.tree.size();
    }

    public void addStock(String name, double buyPrice, double sellPrice, int quantity){
        this.tree.add(new Tree(name,buyPrice,sellPrice,quantity));
    }

    public double getPrice(int i){
         return this.tree.get(i).getBuyPrice();
    }
}
