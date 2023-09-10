import acm.program.ConsoleProgram;

public class Diamond extends ConsoleProgram {
    public void run() {
        int width = readInt("Enter the width (odd number) of the diamond: ");

        if (width % 2 == 0) {
            println("Please enter an odd number for the width.");
            return;
        }

        char spaceChar = ' '; // Change this character for spaces inside the diamond
        char starChar = '*';  // Change this character for stars around the diamond

        int halfWidth = (width / 2) + 1;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                print(starChar);
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                print(starChar);
            }

            println();
        }

        for (int i = halfWidth; i >= 0; i--) {
            for (int j = 0; j < halfWidth - i; j++) {
                print(spaceChar);
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                print(starChar);
            }

            println();
        }
    }
}
