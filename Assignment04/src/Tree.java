public class Tree {
    private int id;
    private String name;
    private double buyPrice;
    private double sellPrice;
    private int quantity;

    public  Tree(int id,String name, double buyPrice, int quantity){
    this(id,name,buyPrice,0,quantity);
    }

    public  Tree(int id,String name,double buyPrice, double sellPrice, int quantity){
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }



    public String getTreeForOwner(){
        return id+ "\t" +  name +"\t"  + quantity +"\t"  + buyPrice  +"\t "  + sellPrice;
    }
    public String getTreeForCustomer(){
        return id+ "\t" +  name +"\t"  + quantity +"\t"  + sellPrice ;
    }




    public double getBuyPrice(){
        return this.buyPrice;
    }

    public double getSellPrice(){
        return this.sellPrice;
    }

    public String getName(){return this.name;}

    public int getId(){return this.id;}

    public int getQuantity(){return this.quantity;}
    public void changeQuantity(int quantity){ this.quantity -= quantity;}

}
