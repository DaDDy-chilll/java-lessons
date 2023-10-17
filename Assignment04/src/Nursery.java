import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.Objects;


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
   TransactionDB transaction = new TransactionDB();
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

                String subMenu = readLine( "You want to buy tree as "+ "\"" + BUY+ " or Exist " + "\""+ STOP+ "\" "+": ");
                println();

                if(BUY.equals(subMenu)){
                    buyTree();
                } else if (STOP.equals(subMenu)) {
                    continue;
                }else {
                    println("Your Input is Invalid!");
                }

            } else if (BALANCE.equals(mainMenu)) {
                println("Your Main Balance " + balance.getBalance());
                println();
            } else if (TRANSACTION.equals(mainMenu)) {
                println("id\t"+"amount\t"+"pay type\t"+"delay\t" + "pay or get");

                for (int i = 0; i < transaction.getsize(); i++) {
                    println(transaction.getAllTransactions(i));
                }
                println();
                getAllDebit();
            }
        }


    }

    public void buyTree() {
        while (true){
            String name = readLine("Name: ");
            double buyPrice = readDouble("buyPrice: ");
            double sellPrice = readDouble("sellPrice: ");
            int quantity = readInt("quantity: ");
            stock.addStock(name,buyPrice,sellPrice,quantity);
            String addOrExit = readLine("Want to more buy "+ "\""+ BUY+ "\""+ " or Exit "+ "\""+ STOP  + "\""+ ": ");
            println();
            if(BUY.equals(addOrExit)){
                continue;
            }else if (STOP.equals(addOrExit)) {
                print("name \t" + "Stock \t" + "Buy Price \t " + "Sell Price\n" );
                for (int i = 0; i < stock.getSize(); i++) {
                    totalPrice += stock.getPrice(i);
                    println(stock.getAllStock(i));
                }
                println("Total Buy Price is: " + totalPrice);
                println();
                payment();
                break;
            }else{
                println("Your Input is Valid.Please Try again!");
                println();
                continue;
            }

        }

    }

    public void payment(){

            String payment = readLine("Want to pay as credit "+ "\""+ CREDIT + "\""+ " or  debit "+ "\""+ DEBIT + "\"" +" ");

            if(CREDIT.equals(payment)){
                transaction.setAllTransactions(new Transaction(id.createID(),totalPrice,"credit",0,"paid"));
                balance.decreaseBalance(totalPrice);
                println("Successfully Buy.");
                println();

            } else if (DEBIT.equals(payment)) {
                transaction.setAllTransactions(new Transaction(id.createID(),totalPrice,"debit","pay"));
                println("Successfully Buy. Don't forget to pay to the suppliers");
                println();

            }else{
                println("Your Input is Valid.Please Try again!");
                println();
                println("id\t"+"amount\t"+"pay type\t"+"delay/t" + "pay or get");
                for (int i = 0; i < transaction.getsize(); i++) {
                    println(transaction.getAllTransactions(i));
                }

            }

    }

    public void getAllDebit() {
        while(true){
            String submenu = readLine("Show all debits as " +"\""+ DEBIT + "\"" +": " );
            if(DEBIT.equals(submenu)){
                println("id\t"+"amount\t"+"pay type\t"+"delay/t" + "pay or get");
                for (int i = 0; i < transaction.getsize(); i++) {
                    if (getDebit(i)) {
                        println(transaction.getAllTransactions(i));
                    }
                }
            }else break;

        }

    }
    public boolean getDebit(int i){return transaction.getAllTransactions(i).contains("debit");}

    //this is for testing
    public void test(){
        stock.addStock("apple",22.3,23.2,10);
        stock.addStock("orange",20.3,33.2,10);
        stock.addStock("kiwi",23.3,43.2,10);
        stock.addStock("pie apple",32.3,53.2,10);
        stock.addStock("watermelon",42.3,43.2,10);
        transaction.setAllTransactions(new Transaction(id.createID(),323.23,"debit","pay"));
        transaction.setAllTransactions(new Transaction(id.createID(),3343.3,"credit","paid"));

        transaction.setAllTransactions(new Transaction(id.createID(),542.3,"debit","pay"));
        transaction.setAllTransactions(new Transaction(id.createID(),2313.3,"debit","pay"));

        transaction.setAllTransactions(new Transaction(id.createID(),23334.3,"credit","paid"));
//        for (int i = 0; i < transaction.getsize(); i++) {
//            if (getDebit(i)){
//                println(transaction.getAllTransactions(i));
//            }


//        }
//        balance.decreaseBalance(totalPrice);
    }


}




