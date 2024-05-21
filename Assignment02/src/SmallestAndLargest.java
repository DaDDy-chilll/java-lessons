import acm.program.ConsoleProgram;

public class SmallestAndLargest extends ConsoleProgram {
    int sentinel = 0;
    int min = 0;
    int max = 0;
    public void  run(){
        println("This program finds the largest and smallest number");

        while (true) {
            int number = readInt("?");

            if (number == sentinel) {
                break;
            }else if (number > max) {
                max = number;
               if (min == 0 || min > number) {
                   min = number;
               }
            }else if (number < min) {
                min = number;
            }
        }
        if ((min + max) == 0) {
            println("No largest or smallest to be choose since you have entered no values!");
        } else {
            println("Smallest number: " + min);
            println("Largest number: " + max);
        }
    }
}
