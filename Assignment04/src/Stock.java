import java.util.LinkedList;

public class Stock {
     LinkedList<Tree> tree = new LinkedList<>();

     public Stock(){

     }

    public String getAllStock(int i){
             return  this.tree.get(i).getTree();
    }

    public Tree getTree(int i){
         return tree.get(i);
    }

    public int getStockQuantity(int i){return tree.get(i).getQuantity();}

    public int getSize(){
         return this.tree.size();
    }

    public void addStock(String name, double buyPrice, double sellPrice, int quantity){
        this.tree.add(new Tree(name,buyPrice,sellPrice,quantity));
    }

    public String getAllName(int i){return tree.get(i).getName();}
//    public boolean checkTree(int i,String name){
//         if(getAllName(i).equals(name)) ;
//    }
    public void changeStock(String name,int quantity){
        for (int i = 0; i < getSize(); i++) {
            if(name.equals(getAllName(i))){
                tree.get(i).changeQuantity(quantity);
            }
        }

    }
    public double getPrice(int i){
         return this.tree.get(i).getBuyPrice();
    }
}
