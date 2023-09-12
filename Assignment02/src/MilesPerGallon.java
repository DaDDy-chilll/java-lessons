import acm.program.ConsoleProgram;

public class MilesPerGallon extends ConsoleProgram {
    public void run() {
       println("Miles Per Gallon Program");

        while (true) {
            int initialMiles = readInt("Initial miles: ");
            if (initialMiles < 0) break;

            int finalMiles = readInt("Final miles: ");
            double gallons = readInt("Gallons: ");
            double mpg = (finalMiles - initialMiles) / gallons;
            println("Miles per Gallon: " + mpg);
            println();
        }
        println("Thanks You for using...! Bye");
    }
}
