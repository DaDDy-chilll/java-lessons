import acm.program.ConsoleProgram;

public class CreditCardBill extends ConsoleProgram {
    public  void run() {
        double balance = readDouble("Enter the beginning balance: $");
//        double balance = scanner.nextDouble();

        double monthlyInterestRate = readDouble("Enter the monthly interest rate:");
//        double monthlyInterestRate = scanner.nextDouble();

        double monthlyPayment = readDouble("Enter the monthly payment amount: $");

//        double monthlyPayment = scanner.nextDouble();

        int months = 0;

        // Calculate the number of months needed to pay off the debt
        while (balance > 0) {
            double interest = balance * monthlyInterestRate;
            balance += interest;

            if (balance < monthlyPayment) {
                // Final payment to bring balance to zero
                monthlyPayment = balance;
                balance = 0;
            } else {
                balance -= monthlyPayment;
            }

            months++;
            println("Month:"+months+"\t"+"Bal:"+balance+"\t"+"Paid:"+monthlyPayment);
        }

       println("It will take " + months + " months to pay off the debt.");
    }
}
