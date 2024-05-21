import acm.program.ConsoleProgram;

public class InchesToCenti extends ConsoleProgram {
    public void run() {
        setFont("Courier New-20");
        final double CENTI_PER_INCH = 2.54;
        double inches = readDouble("Enter inches: ");
        double centimeter = inches * CENTI_PER_INCH; // literal constant
        println(inches + "in = " + centimeter + "cm");

        double value = CENTI_PER_INCH * 22;
        
        double value2 = CENTI_PER_INCH * 10;
    }
}
