import acm.program.ConsoleProgram;

public class AddTwoIntegers extends ConsoleProgram {
    public void run() {
        int n1 = readInt("Enter the first number: ");
        int n2 = readInt("Enter the second number: ");
        int result = n1 + n2;
        println();
        println("The result is: " + result);
    }
}
