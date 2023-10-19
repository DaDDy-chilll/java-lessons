import java.util.LinkedList;

public class Stock {
     LinkedList<Tree> tree = new LinkedList<>();
     public Stock(){}
    public String getAllStockForOwner(int i){
             return  this.tree.get(i).getTreeForOwner();
    }
    public String getAllStockForCutomer(int i){return this.tree.get(i).getTreeForCustomer();}
    public Tree getTree(int i){return tree.get(i);}
    public Tree getLastTree(){return tree.getLast();}
    public int getStockQuantity(int i){return tree.get(i).getQuantity();}
    public int getSize(){return this.tree.size();}
    public void addStock(int id,String name, double buyPrice, double sellPrice, int quantity,String season){
        this.tree.add(new Tree(id,name,buyPrice,sellPrice,quantity,season));
    }
    public String getAllName(int i){return tree.get(i).getName();}
    public void changeStock(String name,int quantity){
        for (int i = 0; i < getSize(); i++) {
            if(name.equals(getAllName(i))) tree.get(i).changeQuantity(quantity);
        }
    }
}
