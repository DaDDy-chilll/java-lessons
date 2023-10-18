import acm.program.ConsoleProgram;


public class Nursery extends ConsoleProgram {
    private double totalPrice;
    private final static String STOP = "e";
    private final static String CREDIT = "c";
    private final static String DEBIT = "d";
    private final static String BUY = "b";
    private final static String DISPLAY = "display";
    private final static String TRANSACTION = "t";
    private final static String BALANCE = BUY;

   Stock stock = new Stock();
   TransactionDB transactionDB = new TransactionDB();
   UniqueID id = new UniqueID();
   Balance balance = new Balance();


    public void run(){
        test();
        while (true){
            println("Display Stock as "+"\""+ DISPLAY+ "\".");
            println("Main Balance as " + "\""+ BALANCE+ "\".");
            println("Show All Transactions as "+ "\""+ TRANSACTION+ "\".");
            String mainMenu = readLine( "\""+ DISPLAY+ "\" "+ "\""+ BALANCE+ "\" "+ "\""+ TRANSACTION+ "\""+": ");
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
                       buyTree();
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
            }
        }


    }

    public void buyTree() {
        String addOrExit;
        while (true){
            String name = readLine("Name: ");
            double buyPrice = readDouble("buyPrice: ");
            double sellPrice = readDouble("sellPrice: ");
            int quantity = readInt("quantity: ");
            stock.addStock(name,buyPrice,sellPrice,quantity);
            transactionDB.setStockTransactions(new Tree(name,buyPrice,sellPrice,quantity));
            while (true){
                 addOrExit = readLine("Want to more buy "+ "\""+ BUY+ "\""+ " or Exit "+ "\""+ STOP  + "\""+ ": ");
                println();
                if(BUY.equals(addOrExit)){
                    break;
                }else if (STOP.equals(addOrExit)) {
                   if(transactionDB.getStockTransactinsSize() > 0){
                       print("name \t" + "Stock \t" + "Buy Price \t " + "Sell Price\n" );
                       for (int i = 0; i < transactionDB.getStockTransactinsSize(); i++) {
                           totalPrice += transactionDB.getSingleStockTransactionsBuyPrice(i);
                           println(transactionDB.getStockTransactions(i));
                       }
                       println("Total Buy Price is: " + totalPrice);
                       println();
                       payment();
                   }
                    totalPrice=0;
                    break;
                }else{
                    println("Your Input is Valid.Please Try again!");
                    println();
                }
            }
            if(STOP.equals(addOrExit)){
                System.out.print("exist true");
                break;
            };
        }

    }

    public void payment(){
        while (true){
            String payment = readLine("Want to pay as credit "+ "\""+ CREDIT + "\""+ " or  debit "+ "\""+ DEBIT + "\"" +" ");
            if(CREDIT.equals(payment)){
                transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),totalPrice,"credit",0,"paid"));
                balance.decreaseBalance(totalPrice);
                transactionDB.removeAllStockTransactions();
                println("Successfully Buy.");
                println();
                break;
            } else if (DEBIT.equals(payment)) {
                transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),totalPrice,"debit","pay"));
                transactionDB.removeAllStockTransactions();
                println("Successfully Buy. Don't forget to pay to the suppliers");
                println();
                break;
            }else{
                println("Your Input is Valid.Please Try again!");
            }

        }

    }

    public void getAllDebit() {
        while(true){
            String submenu = readLine("Show all debits as " +"\""+ DEBIT + "\"" + " or Exit "+ "\""+ STOP  + "\""+ ": " );
            println();
            if(DEBIT.equals(submenu)){
                println("id\t"+"amount\t"+"pay type\t"+"delay\t" + "pay or get");
//                for (int i = 0; i < transactionDB.getBuyTransactionSize(); i++) {
//                    if (getDebit(i)) {
//                        println(transactionDB.getAllBuyTransactions(i));
//                    }
//                }
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
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),323.23,"debit","pay"));
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),3343.3,"credit","paid"));

        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),542.3,"debit","pay"));
        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),2313.3,"debit","pay"));

        transactionDB.setBuyTransactions(new BuyTransaction(id.createID(),23334.3,"credit","paid"));
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

