public class Tree {
    private final int id;
    private final String name;
    private final double buyPrice;
    private final double sellPrice;
    private final String season;
    private int quantity;

    public  Tree(int id,String name, double sellPrice, int quantity,String season){this(id,name,0,sellPrice,quantity,season);}
    public  Tree(int id,String name,double buyPrice, double sellPrice, int quantity,String season){
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.season = season;
    }
    public String getTreeForOwner(){return id+ "\t" +  name +"\t"  + quantity +"\t"  + buyPrice  +"\t "  + sellPrice;}
    public String getTreeForCustomer(){return id+ "\t" +  name +"\t"  + quantity +"\t"  + sellPrice ;}
    public String getTreeDetail() { return id+ "\t" +  name +"\t"  + quantity +"\t"  + sellPrice+"\t"  + season ;}
    public double getBuyPrice(){
        return this.buyPrice;
    }
    public double getSellPrice(){
        return this.sellPrice;
    }
    public String getName(){return this.name;}
    public String getSeason(){return this.season;}
    public int getId(){return this.id;}
    public int getQuantity(){return this.quantity;}
    public void changeQuantity(int quantity){ this.quantity -= quantity;}
}
