import acm.program.ConsoleProgram;

public class Diamond extends ConsoleProgram {
    public void run() {
        int width = readInt("Enter the width (odd number) of the diamond: ");

        if (width % 2 == 0) {
            println("Please enter an odd number for the width.");
            return;
        }

        char spaceChar = ' ';
        char starChar = '*';

        int middle = width / 2;

        for (int i = 0; i < width; i++) {
            for (int j =0; j < width; j++) {
                if(i == 2 || i != (width -1)){
                    if (j == middle){
                        for (int k = 0; k < 2 * i + 1 ; k++) {
                            print(spaceChar);
                        }
                        middle-=1;
                    }else {
                        print(starChar);
                    }
                }else {
                    print(starChar);
                }
            }
            println();
        }

//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < width; j++) {
//                print(starChar);
//            }
//
//            for (int j = 0; j < 2 * i + 1; j++) {
//                print(starChar);
//            }
//
//            println();
//        }

//        for (int i = halfWidth; i >= 0; i--) {
//            for (int j = 0; j < halfWidth - i; j++) {
//                print(spaceChar);
//            }
//
//            for (int j = 0; j < 2 * i + 1; j++) {
//                print(starChar);
//            }
//
//            println();
//        }
    }
}
