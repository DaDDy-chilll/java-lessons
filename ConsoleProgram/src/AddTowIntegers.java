import acm.program.ConsoleProgram;

public class AddTowIntegers extends ConsoleProgram   {
    public void run() {
       int n1 = readInt("first Number : ");
       int n2 = readInt("second Number : ");
       int total = n1 + n2;
       print("Total Number is: " + total);
    }
}
