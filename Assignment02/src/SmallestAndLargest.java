import acm.program.ConsoleProgram;

public class SmallestAndLargest extends ConsoleProgram {
    public void  run(){
        int sentinel = 0;

        int min = 0;
        int max = 0;

        println("This program finds the largest and smallest number");

        while (true) {
            int number = readInt("?");

            if (number == sentinel) {
                break; // Exit the loop when the sentinel is entered
            }
            if (number > max) {
                max = number;
               if (max < min) {
                   min = max;
               }
            }

            if (number < min) {
                min = number;
            }


        }

        if ((min + max) == 0) {
            println("No valid numbers entered.");
        } else {
            println("Smallest number: " + min);
            println("Largest number: " + max);
        }
    }

    // Set the sentinel value

}
