import acm.program.ConsoleProgram;

public class InchesToCenti extends ConsoleProgram {
    public void run() {
        setFont("Courier New-20");
        final double CENTI_PRE_INCH = 2.54;
        double inches = readDouble("Enter Inches: ");
        double centi = inches * CENTI_PRE_INCH;
        println(inches + "in= " + centi + "cm");
    }
}
