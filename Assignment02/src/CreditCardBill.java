import acm.program.ConsoleProgram;

public class CreditCardBill extends ConsoleProgram {
    public  void run() {
        double balance = readDouble("Enter total amt to pay: $");
        double monthlyPayment = readDouble("Enter the monthly payment amount: $");
        double monthlyInterestRate = readDouble("Enter the monthly interest rate: %");


        int months = 0;
        double totalPayment = 0;
        double tempBalance = 0;

        while (balance > 0) {
            double interest = balance * (monthlyInterestRate / 100);
            balance = (balance - monthlyPayment) + interest;
            System.out.println(balance);

            if (balance > 0 ) {
//                monthlyPayment = balance;
                tempBalance = balance;
                totalPayment += monthlyPayment;
            }else {
                totalPayment+=tempBalance;
                balance = 0.0;
            }

//            else {
//                balance -= monthlyPayment;
//            }

            months++;
            println("Month: "+ months +" \t " + "Bal: " + balance +" \t "+ "Paid: "+ totalPayment);
        }

       println("It will take " + months + " months to pay off the debt.");
    }
}
