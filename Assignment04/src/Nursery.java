import acm.program.ConsoleProgram;

import java.util.ArrayList;


public class Nursery extends ConsoleProgram {
    private double totalPrice;
    private final static String STOP = "e";
    private final static String CREDIT = "c";
    private final static String DEBIT = "d";
    private final static String BUY = "b";
    private final static String DISPLAY = "display";
    private final static String TRANSACTION = "t";
    private final static String BALANCE = BUY;
    private final static String OWNER = "o";
    private final static String CUSTOMER = "c";

   Stock stock = new Stock();
   TransactionDB transactionDB = new TransactionDB();
   UniqueID id = new UniqueID();
   Balance balance = new Balance();
    String addOrExit = "";


    public void run(){
        test();
        println("Welcome to My Plant Nursery!");
       while (true){
           println("If you are a customer, please type "+"\""+ CUSTOMER+ "\".");
           println("If you are a owner, please type "+"\""+ OWNER+ "\".");
           println();
           String type = readLine("> ");
           if(CUSTOMER.equals(type)){
               customer();
           } else if (OWNER.equals(type)) {
               println();
               owner();
           }else {
                println("Your input is invalid!");
           }
       }


    }

    public void customer(){
        while (true){
            String mainMenu = readLine("Want to buy tree "+"\""+ BUY+ "\" or "+"Exist " +"\""+ STOP+ "\".");
            if(BUY.equals(mainMenu)){
                println();
                for (int i = 0; i < stock.getSize(); i++) {
                    println(stock.getAllStock(i));
                }
                println();
                buyTree(CUSTOMER);
            } else if (STOP.equals(mainMenu)) {
                break;
            }else {
                println("Your input is invalid.");
            }
        }
    }
    public void owner(){
        while (true){
            println("Display Stock as "+"\""+ DISPLAY+ "\".");
            println("Main Balance as " + "\""+ BALANCE+ "\".");
            println("Show All Transactions as "+ "\""+ TRANSACTION+ "\".");
            println("Want to exist as "+ "\""+ STOP+ "\".");
            String mainMenu = readLine( "\""+ DISPLAY+ "\", "+ "\""+ BALANCE+ "\", "+ "\""+ TRANSACTION+ "\", "+"\""+ STOP+ "\" "+": ");
            println();

            if(DISPLAY.equals(mainMenu)){
                println("This tress is available in our stock.");
                println();
                if(stock.getSize() > 0){
                    println("name \t" + "Stock \t" + "Buy Price \t " + "Sell Price" );
                    for (int i = 0; i < stock.getSize(); i++) {
                        println(stock.getAllStock(i));
                    }
                    println();
                }else {
                    println("Stock is empty!");
                    println();
                }

                while(true){
                    String subMenu = readLine( "You want to buy tree as "+ "\"" + BUY+ " or Exist " + "\""+ STOP+ "\" "+": ");
                    println();

                    if(BUY.equals(subMenu)){
                        buyTree(OWNER);
                    } else if (STOP.equals(subMenu)) {
                        break;
                    }else {
                        println("Your Input is Invalid!");
                    }
                }

            } else if (BALANCE.equals(mainMenu)) {
                println("Your Main Balance " + balance.getBalance());
                println();
            } else if (TRANSACTION.equals(mainMenu)) {
                println("id\t"+"amount\t"+"pay type\t"+"delay\t" + "pay or get");

                for (int i = 0; i < transactionDB.getBuyTransactionSize(); i++) {
                    println(transactionDB.getAllBuyTransactions(i));
                }
                println();
                getAllDebit();
            } else if (STOP.equals(mainMenu)) {
                break;
            }else {
                println("Your input is invalid");
            }
        }
    }

    public void buyTree(String type){
        while (true){
            String name = readLine("Name: ");
            if(checkTreeName(name) && CUSTOMER.equals(type)) {
                println("Sorry,Your request Tree have not available in our stock.");
                continue;
            };
            int quantity = readInt("quantity: ");

            if (checkStockTree(name,quantity)&& CUSTOMER.equals(type)){
                println("Sorry,Your request stock is higher than our available stock.");
                continue;
            }
            double buyPrice = 0;
            double sellPrice = 0;
            if(OWNER.equals(type)){
                 buyPrice = readDouble("buyPrice: "); //ower
                 sellPrice = readDouble("sellPrice: ");
                 buyTreeAsOwner(name,buyPrice,sellPrice,quantity);
            } else if (CUSTOMER.equals(type)) {
//                System.out.println("customer");
                buyTreeAsCustomer(name,quantity);
            }

//            stock.addStock(name,buyPrice,sellPrice,quantity);//ower
//            transactionDB.setStockTransactions(new Tree(name,buyPrice,sellPrice,quantity));//ower
            while (true){
                 addOrExit = readLine("Want to more buy "+ "\""+ BUY+ "\""+ " or Exit "+ "\""+ STOP  + "\""+ ": ");
                println();
                if(BUY.equals(addOrExit)){
                    break;
                }else if (STOP.equals(addOrExit)) {
//                    System.out.println("getStockTransactinsSize" + transactionDB.getStockTransactinsSize());
                   if(transactionDB.getStockTransactinsSize() > 0){
                       print("name \t" + "Stock \t" + "Buy Price \t " + "Sell Price\n" );
                       for (int i = 0; i < transactionDB.getStockTransactinsSize(); i++) {
                           totalPrice += transactionDB.getSingleStockTransactionsBuyPrice(i);
                           println(transactionDB.getStockTransactions(i));
                       }
                       println("Total Buy Price is: " + totalPrice);
                       println();
                       if(OWNER.equals(type)){
                       payment(OWNER);
                       } else if (CUSTOMER.equals(type)) {
                           payment(CUSTOMER);
                       }

                   }
                    totalPrice=0;
                    break;
                }else{
                    println("Your Input is Valid.Please Try again!");
                    println();
                }
            }
            if(STOP.equals(addOrExit)){

                break;
            };
        }
    }

    public boolean checkTreeName(String name){
        boolean isNotAavailable = false;

            for (int i = 0; i < stock.getSize(); i++) {
                if (stock.getAllName(i).contains(name)) {
                    isNotAavailable=false;
                    break;
                }else {
                    isNotAavailable=true;
                }
            }

        return isNotAavailable;
    }

    public boolean checkStockTree(String name,int quantity){
        boolean isNotAavailable = false;

        for (int i = 0; i < stock.getSize(); i++) {
            if (stock.getAllName(i).contains(name)) {
                isNotAavailable = stock.getStockQuantity(i) >= quantity ? false : true;
//                if(stock.getStockQuantity(i) > quantity){
//                    isNotAavailable=false;
//                    break;
//                }else {
//                    isNotAavailable=true;
//                    break;
//                }
                break;
            }
        }

        return isNotAavailable;
    }

    public void buyTreeAsCustomer(String name,int quantity){
        double buyPrice;
        double sellPrice;
        stock.changeStock(name,quantity);
        for (int i = 0; i < stock.getSize(); i++) {
//            System.out.println(name.equals(stock.getAllName(i)));
            System.out.println(stock.getAllName(i).contains(name));

            if (!stock.getAllName(i).contains(name)) continue;
            buyPrice = stock.getTree(i).getBuyPrice();
            transactionDB.setStockTransactions(new Tree(name,buyPrice,quantity));

        }
    }
    public void buyTreeAsOwner(String name,double buyPrice, double sellPrice, int quantity){
        stock.addStock(name,buyPrice,sellPrice,quantity);//ower
        transactionDB.setStockTransactions(new Tree(name,buyPrice,sellPrice,quantity));//ower
//        while (true){
//             addOrExit = readLine("Want to more buy "+ "\""+ BUY+ "\""+ " or Exit "+ "\""+ STOP  + "\""+ ": ");
//            println();
//            if(BUY.equals(addOrExit)){
//                break;
//            }else if (STOP.equals(addOrExit)) {
//                if(transactionDB.getStockTransactinsSize() > 0){
//                    print("name \t" + "Stock \t" + "Buy Price \t " + "Sell Price\n" );
//                    for (int i = 0; i < transactionDB.getStockTransactinsSize(); i++) {
//                        totalPrice += transactionDB.getSingleStockTransactionsBuyPrice(i);
//                        println(transactionDB.getStockTransactions(i));
//                    }
//                    println("Total Buy Price is: " + totalPrice);
//                    println();
//                    payment();
//                }
//                totalPrice=0;
//                break;
//            }else{
//                println("Your Input is Valid.Please Try again!");
//                println();
//            }
//        }
    }

    public void payment(String type){
        while (true){
            String payment = readLine("Want to pay as credit "+ "\""+ CREDIT + "\""+ " or  debit "+ "\""+ DEBIT + "\"" +" ");
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

    public void getAllDebit(){
        while(true){
            String submenu = readLine("Show all debits as " +"\""+ DEBIT + "\"" + " or Exit "+ "\""+ STOP  + "\""+ ": " );
            println();
            if(DEBIT.equals(submenu)){
                ArrayList<BuyTransaction> allDebit = transactionDB.getAllDebit();
                println("id\t"+"amount\t"+"pay type\t"+"delay\t" + "pay or get");
                for (int i = 0; i < allDebit.size(); i++) {
                    println(allDebit.get(i).getTransactions());
                }
                println();
            }else if(STOP.equals(submenu)){
                break;
            }else{
                println("Your Input is Invalid!");
            };

        }

    }


    //this is for testing
    public void test(){
        stock.addStock("apple",22.3,23.2,10);
        stock.addStock("orange",20.3,33.2,10);
        stock.addStock("kiwi",23.3,43.2,10);
        stock.addStock("pie apple",32.3,53.2,10);
        stock.addStock("watermelon",42.3,43.2,10);
//        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),323.23,"debit","pay"));
//        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),3343.3,"credit","paid"));
//
//        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),542.3,"debit","pay"));
//        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),2313.3,"debit","pay"));
//
//        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),23334.3,"credit","paid"));
//        for (int i = 0; i < transaction.getsize(); i++) {
//            if (getDebit(i)){
//                println(transaction.getAllBuyTransactions(i));
//            }


//        }
//        balance.decreaseBalance(totalPrice);
    }


}


//    println();
//    println("id\t"+"amount\t"+"pay type\t"+"delay/t" + "pay or get");
//                for (int i = 0; i < transactionDB.getBuyTransactionSize(); i++) {
//        println(transactionDB.getAllBuyTransactions(i));
//        }

