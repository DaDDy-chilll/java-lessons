import acm.program.ConsoleProgram;

public class TwoYearInterest extends ConsoleProgram {
    public void run(){
        final int CONVERT_PERCENT = 100;
        double balance = readDouble("Enter balance: ");
        double interestRate = readDouble("Enter interest: ");
        double balanceAfterOneYear = balance + (balance * interestRate/CONVERT_PERCENT);
        double balanceAfterTwoYear = balanceAfterOneYear + (balanceAfterOneYear * interestRate/CONVERT_PERCENT);

        println("Balance After One Year: " + balanceAfterOneYear);
        println("Balance After Two Year: " + balanceAfterTwoYear);
    }
}
