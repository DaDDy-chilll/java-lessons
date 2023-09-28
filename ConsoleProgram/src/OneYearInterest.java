import acm.program.ConsoleProgram;

public class OneYearInterest extends ConsoleProgram {
    public void run(){
        double balance = readDouble("Enter balance: ");
        if(balance < 0){
            println("Balance should not be negative!");
        }
        double interestRate = readDouble("Enter interest rate: ");
        if (interestRate < 0){
            println("Interest rate should not be negative!");
        }
        double balanceAfterOneYear = balance + (balance * interestRate/100);
        println("Balance after one year: " + balanceAfterOneYear);
    }
}
