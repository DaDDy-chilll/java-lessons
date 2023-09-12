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
        int next = middle-1;
        for (int i = 0; i < width; i++) {
            if (i >= 1 && i <= (width -2)){
                if (i < middle){
                    for (int j = 0; j < middle - i + 1; j++) {
                        print(starChar);
                    }
                    for (int j = 0; j < 2 * i -1; j++) {
                        print(spaceChar);
                    }
                    for (int j = 0; j < middle - i + 1; j++) {
                        print(starChar);
                    }
                }else{
                    if( i == middle){
                        print(starChar);
                        for (int j = 0; j < 2 * i -1; j++) {
                            print(spaceChar);
                        }
                        print(starChar);
                    }else {
                        for (int j = 0; j < i - middle +1 ; j++) {
                            print(starChar);
                        }
                        for (int j = 0; j <  2 * next - 1; j++) {
                            print(spaceChar);
                        }
                        for (int j = 0; j < i - middle +1 ; j++) {
                            print(starChar);
                        }
                        next--;
                    }
                }
            }else{
                for (int j = 0; j < width; j++) {
                    print(starChar);
                }
            }
            println();
        }
//        for (int i = 0; i < width; i++) {
//            if (i < middle){
//               if (i >= 1 && i <= (width -2)){
//                   for (int j = 0; j < middle - i + 1; j++) {
//                       print(starChar);
//                   }
//                   for (int j = 0; j < 2 * i -1; j++) {
//                       print(spaceChar);
//                   }
//                   for (int j = 0; j < middle - i + 1; j++) {
//                       print(starChar);
//                   }
//               }else {
//                   for (int j = 0; j < width; j++) {
//                       print(starChar);
//                   }
//               }
//            }else {
//                if( i == middle){
//                    print(starChar);
//                    for (int j = 0; j < 2 * i -1; j++) {
//                        print(spaceChar);
//                    }
//                    print(starChar);
//                }else {
//                    for (int j = 0; j < i - middle +1 ; j++) {
//                        print(starChar);
//                    }
//                    for (int j = 0; j < 2 * i -1; j++) {
//                        print(spaceChar);
//                    }
//                    for (int j = 0; j < i - middle +1 ; j++) {
//                        print(starChar);
//                    }
//                }
//            }
//            println();
//        }
    }
}
