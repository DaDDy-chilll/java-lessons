import acm.program.ConsoleProgram;

public class test extends ConsoleProgram {
    public void  run() {
        int height = readInt("enter width");
        if (height % 2 == 0) {
            println("Height must be an odd number.");
            return;
        }

        int n = height / 2;

        // Print the top half of the diamond
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                print("*");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                print(" ");
            }

            for (int j = 0; j < n - i; j++) {
                print("*");
            }

            println();
        }

        // Print the middle row with all stars
//        for (int i = 0; i < height; i++) {
//            print("*");
//        }
//        println();

        // Print the bottom half of the diamond
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                print("*");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                print(" ");
            }

            for (int j = 0; j < n - i; j++) {
                print("*");
            }

            println();
        }
    }
}
