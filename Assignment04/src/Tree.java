public class Tree {
    private String name;
    private double buyPrice;
    private double sellPrice;
    private int quantity;



    public  Tree(String name,double buyPrice, double sellPrice, int quantity){
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    public String getTree(){
        return  name +"\t"  + quantity +"\t"  + buyPrice  +"\t "  + sellPrice;
    }

    public double getBuyPrice(){
        return this.buyPrice;
    }

    public double getSellPrice(){
        return this.sellPrice;
    }

}
