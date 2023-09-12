import acm.program.ConsoleProgram;

public class CreditCardBill extends ConsoleProgram {
    int months = 0;
    double totalPayment = 0;
    double tempBalance = 0;
    public  void run() {
        double balance = readDouble("Enter total amt to pay: $");
        double monthlyPayment = readDouble("Enter the monthly payment amount: $");
        double monthlyInterestRate = readDouble("Enter the monthly interest rate: %");

        while (balance > 0) {
            double interest = balance * (monthlyInterestRate / 100);
            balance = (balance - monthlyPayment) + interest;

            if (balance > 0 ) {
                tempBalance = balance;
                totalPayment += monthlyPayment;
            }else {
                totalPayment+=tempBalance;
                balance = 0.0;
            }
            months++;
            println("Month: "+ months +" \t " + "Bal: " + balance +" \t "+ "Paid: "+ totalPayment);
        }

       println("It will take " + months + " months to pay off the debt.");
    }
}
