import acm.program.ConsoleProgram;

public class MilesPerGallon extends ConsoleProgram {
    public void run() {


       println("Miles Per Gallon Program");

        while (true) {

            int initialMiles = readInt("Initial miles: ");

            if (initialMiles < 0) {
                break; // Exit the loop if a negative initial odometer reading is entered
            }

            int finalMiles = readInt("Final miles: ");

            double gallons = readInt("Gallons: ");

            double mpg = (finalMiles - initialMiles) / gallons;

            println("Miles per Gallon: " + mpg);
            println();
        }

        println("Thank you for using the program!");
    }
}
