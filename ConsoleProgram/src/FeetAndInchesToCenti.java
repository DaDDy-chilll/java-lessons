import acm.program.ConsoleProgram;

public class FeetAndInchesToCenti extends ConsoleProgram {
    public void run(){
        final int INCHES_PER_FEET = 12;
        final double CENTI_PER_INCH = 2.54;
        int feet = readInt("How many feet? ");
        double inches = readDouble("How many inches? ");
        double totalInches = feet * INCHES_PER_FEET + inches;
        double totalCenti = totalInches * CENTI_PER_INCH;
        println(feet + "ft" + inches + "in = " + totalCenti);
    }
}
