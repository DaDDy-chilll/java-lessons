import acm.program.ConsoleProgram;

import java.util.ArrayList;


public class Nursery extends ConsoleProgram {
    private double totalPrice;
    private final static String CREDIT = "c";
    private final static String CUSTOMER = "c";
    private final static String DEBIT = "d";
    private final static String BUY = "b";
    private final static String STOP = "e";
    private final static String OWNER = "o";
    private final static String TRANSACTION = "t";
    private final static String BALANCE = BUY;
    private final static String DISPLAY = DEBIT;
    private final static String DETAIL = DEBIT;
    private final static String NEW = DEBIT;
    Stock stock = new Stock();
    TransactionDB transactionDB = new TransactionDB();
    UniqueID id = new UniqueID();
    Balance balance = new Balance();
    String addOrExit = "";


    public void run(){
        testData();
        println("Welcome to My Plant Nursery!");
        startNursery();
    }

    public void startNursery() {
        while (true) {
            println();
            println("If you want to change new day " + "\"" + NEW + "\".");
            println("If you are a customer, please type " + "\"" + CUSTOMER + "\".");
            println("If you are a owner, please type " + "\"" + OWNER + "\".");
            println();
            String type = readLine("> ");
            if (CUSTOMER.equals(type)) customer();
            else if (OWNER.equals(type)) {
                println();
                owner();
            } else if (NEW.equals(type)) {
                newDay();
                println("new day change success.");
            } else println("Your input is invalid!");
        }
    }

    // Customer Section
    public void customer(){
        while (true){
            String mainMenu = readLine("Show all trees "+"\""+ DISPLAY + "\" or "+"Exist " +"\""+ STOP+ "\": ");
            if(DISPLAY.equals(mainMenu)){
                println();
                println("id \t" +"name \t" + "Stock \t"  + "Sell Price" );
                for (int i = 0; i < stock.getSize(); i++) println(stock.getAllStockForCutomer(i));
                println();
                while (true){
                    String subMenu = readLine("Show Tree detail as "+"\""+ DETAIL + "\" or "+"Buy Tree as " +"\""+ BUY+ "\" or "+"Exist " +"\""+ STOP+ "\": ");
                    if(DETAIL.equals(subMenu)) getTreeDetail();
                    else if (BUY.equals(subMenu)) buyTree(CUSTOMER);
                    else if (STOP.equals(subMenu)) break;
                    else println("Your Input is Invalid.");
                }
            } else if (STOP.equals(mainMenu)) break;
            else println("Your input is invalid.");
        }
    }

    public void getTreeDetail(){
        int id = readInt("Input You want to see tree id: ");
        println();
        println("id \t" +"name \t" + "Stock \t"  + "Sell Price" + "Season" );
        println( stock.getTree(id).getTreeDetail());
        println();
    }

    //Owner Section
    public void owner(){
        while (true){
            println("Display Stock as "+"\""+ DISPLAY+ "\".");
            println("Main Balance as " + "\""+ BALANCE+ "\".");
            println("Show All Transactions as "+ "\""+ TRANSACTION+ "\".");
            println("Want to exist as "+ "\""+ STOP+ "\".");
            println();
            String mainMenu = readLine( "\""+ DISPLAY+ "\", "+ "\""+ BALANCE+ "\", "+ "\""+ TRANSACTION+ "\", "+"\""+ STOP+ "\" "+": ");
            println();

            if(DISPLAY.equals(mainMenu)){
                println("This tress is available in our stock.");
                println();
                if(stock.getSize() > 0){
                    println("id \t" +"name \t" + "Stock \t" + "Buy Price \t " + "Sell Price" );
                    for (int i = 0; i < stock.getSize(); i++) println(stock.getAllStockForOwner(i));
                    println();
                }else {
                    println("Stock is empty!");
                    println();
                }
                while(true){
                    String subMenu = readLine( "You want to buy tree as "+ "\"" + BUY+ " or Exist " + "\""+ STOP+ "\" "+": ");
                    println();
                    if(BUY.equals(subMenu)) buyTree(OWNER);
                    else if (STOP.equals(subMenu)) break;
                    else println("Your Input is Invalid!");
                }
            } else if (BALANCE.equals(mainMenu)) {
                println("Your Main Balance " + balance.getBalance());
                println();
            } else if (TRANSACTION.equals(mainMenu)) {
                println("id\t"+"amount\t"+"pay type\t"+"delay\t" + "pay or get");
                for (int i = 0; i < transactionDB.getBuyTransactionSize(); i++) println(transactionDB.getAllBuyTransactions(i));
                println();
                getAllDebit();
            } else if (STOP.equals(mainMenu)) break;
            else println("Your input is invalid");
        }
    }
    public void getAllDebit(){
        while(true){
            String submenu = readLine("Show all debits as " +"\""+ DEBIT + "\"" + " or Exit "+ "\""+ STOP  + "\""+ ": " );
            println();
            if(DEBIT.equals(submenu)){
                ArrayList<BuyTransaction> allDebit = transactionDB.getAllDebit();
                println("id\t"+"amount\t"+"pay type\t"+"delay\t" + "pay or get");
                for (BuyTransaction buyTransaction : allDebit) println(buyTransaction.getTransactions());
                println();
            }else if(STOP.equals(submenu)) break;
            else println("Your Input is Invalid!");
        }
    }
    public void buyTree(String type){
        while (true){
            String name = readLine("Name: ");
            if(checkTreeName(name) && CUSTOMER.equals(type)) {
                println("Sorry,Your request Tree have not available in our stock.");
                println();
                continue;
            }

            int quantity = readInt("quantity: ");
            if (checkStockTree(name,quantity)&& CUSTOMER.equals(type)){
                println("Sorry,Your request stock is higher than our available stock.");
                println();
                continue;
            }

            double buyPrice ;
            double sellPrice ;
            if(OWNER.equals(type)){
                buyPrice = readDouble("buyPrice: ");
                sellPrice = readDouble("sellPrice: ");
                String season = readLine("Type of Season: ");
                buyTreeAsOwner(name,buyPrice,sellPrice,quantity,season);
            } else if (CUSTOMER.equals(type)) buyTreeAsCustomer(name,quantity);

            while (true){
                println();
                addOrExit = readLine("Want to more buy "+ "\""+ BUY+ "\""+ " or Exit "+ "\""+ STOP  + "\""+ ": ");
                println();
                if(BUY.equals(addOrExit)) break;
                else if (STOP.equals(addOrExit)) {
                    if(transactionDB.getStockTransactionsSize() > 0){
                        if(OWNER.equals(type)) print("id \t" + "name \t" + "Stock \t" + "Buy Price \t " + "Sell Price\t" + "Season\n" );
                        else if (CUSTOMER.equals(type)) print("id \t" + "name \t" + "Stock \t"  + "Sell Price\n" );
                        for (int i = 0; i < transactionDB.getStockTransactionsSize(); i++) {
                            if (OWNER.equals(type)){
                                totalPrice += transactionDB.getSingleStockTransactionsBuyPrice(i);
                                println(transactionDB.getStockTransactionsForOwer(i));
                            }else if (CUSTOMER.equals(type)){
                                totalPrice += transactionDB.getSingleStockTransactionsSellPrice(i);
                                println(transactionDB.getStockTransactionsForCustomer(i));
                            }
                        }
                        println("Total Buy Price is: " + totalPrice);
                        println();
                        payment(type);
                    }
                    totalPrice=0;
                    break;
                }else{
                    println("Your Input is Valid.Please Try again!");
                    println();
                }
            }
            if(STOP.equals(addOrExit)) break;
        }
    }
    public boolean checkTreeName(String name){
        boolean isNotAvailable = false;
        for (int i = 0; i < stock.getSize(); i++) {
            if (stock.getAllName(i).contains(name)) {
                isNotAvailable=false;
                break;
            }else isNotAvailable=true;
        }
        return isNotAvailable;
    }
    public boolean checkStockTree(String name,int quantity){
        boolean isNotAvailable = false;
        for (int i = 0; i < stock.getSize(); i++) {
            if (stock.getAllName(i).contains(name)) {
                isNotAvailable = stock.getStockQuantity(i) < quantity;
                break;
            }
        }
        return isNotAvailable;
    }
    public void buyTreeAsCustomer(String name,int quantity){
        double sellPrice;
        String season;
        stock.changeStock(name,quantity);
        for (int i = 0; i < stock.getSize(); i++) {
            if (!stock.getAllName(i).contains(name)) continue;
            sellPrice = stock.getTree(i).getSellPrice();
            season = stock.getTree(i).getSeason();
            int treeId;
            if (!(transactionDB.getStockTransactionsSize() > 0)) id.setId(0);
            else {
                treeId = transactionDB.getStockTransactionsSize();
                id.setId(treeId);
            }
            transactionDB.setStockTransactions(new Tree(id.createID(),name,sellPrice,quantity,season));
        }
    }
    public void buyTreeAsOwner(String name,double buyPrice, double sellPrice, int quantity,String season){
        int treeId;
        treeId = stock.getLastTree().getId();
        id.setId(treeId+1);
        stock.addStock(id.createID(),name,buyPrice,sellPrice,quantity,season);
        if (!(transactionDB.getStockTransactionsSize() > 0)) id.setId(0);
        else {
            treeId = transactionDB.getStockTransactionsSize();
            id.setId(treeId);
        }
        transactionDB.setStockTransactions(new Tree(id.createID(),name,buyPrice,sellPrice,quantity,season));
    }
    public void payment(String type){
        while (true){
            String payment = readLine("Want to pay as credit "+ "\""+ CREDIT + "\""+ " or  debit "+ "\""+ DEBIT + "\"" +": ");
            int treeId;
            if (!(transactionDB.getBuyTransactionSize() > 0)) id.setId(0);
            else {
                treeId = transactionDB.getBuyTransactionSize();
                id.setId(treeId);
            }
            if(CREDIT.equals(payment)){
                if(OWNER.equals(type)){
                    transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),totalPrice,"credit",0,"pay"));
                    balance.decreaseBalance(totalPrice);
                } else if (CUSTOMER.equals(type)) {
                    transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),totalPrice,"credit",0,"get"));
                    balance.increaseBalance(totalPrice);
                }
                transactionDB.removeAllStockTransactions();
                println("Successfully Buy.");
                println();
                break;
            } else if (DEBIT.equals(payment)) {
                if(OWNER.equals(type)) {
                    transactionDB.setBuyTransactions(new BuyTransaction(id.createID(), totalPrice, "debit", "pay"));
                    transactionDB.removeAllStockTransactions();
                    println("Successfully Buy. Don't forget to pay to the suppliers");
                }else if (CUSTOMER.equals(type)) {
                    transactionDB.setBuyTransactions(new BuyTransaction(id.createID(), totalPrice, "debit", "get"));
                    transactionDB.removeAllStockTransactions();
                    println("Successfully Buy. Don't forget to pay next 4 days");
                }
                println();
                break;
            }else{
                println("Your Input is Valid.Please Try again!");
            }
        }
    }
    public void newDay(){
        ArrayList<BuyTransaction> allDebit = transactionDB.getAllDebit();
        for (BuyTransaction buyTransaction : allDebit) {
            if(buyTransaction.getDelay() != 0) buyTransaction.setDelay();
            if ("pay".equals(buyTransaction.getPayOrGet()) && buyTransaction.getDelay() == 0) {
                double amount = buyTransaction.getAmount();
                balance.decreaseBalance(amount);
                buyTransaction.setPayOrGet();
            } else if ("get".equals(buyTransaction.getPayOrGet()) && buyTransaction.getDelay() == 0) {
                double amount = buyTransaction.getAmount();
                balance.increaseBalance(amount);
                buyTransaction.setPayOrGet();
            }

        }
    }

    public void testData(){
        stock.addStock(id.createID(),"apple",22.3,23.2,10,"winter");
        stock.addStock(id.createID(),"orange",20.3,33.2,10,"Summer");
        stock.addStock(id.createID(),"kiwi",23.3,43.2,10,"Autumn");
        stock.addStock(id.createID(),"watermelon",42.3,43.2,10,"Spring");
        id.setId(0);
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),100,"debit","get"));
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),100,"debit","get"));
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),100,"debit","get"));
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),100,"debit","pay"));
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),100,"debit","pay"));
    }
}

