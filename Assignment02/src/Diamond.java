import acm.program.ConsoleProgram;

public class Diamond extends ConsoleProgram {
    char spaceChar = ' ';
    char starChar = '*';
    public void run() {
        int width = readInt("Enter the width (odd number) of the diamond: ");
        int middle = width / 2;
        int next = middle-1;

        if (width % 2 == 0) {
            println("Please enter an odd number for the width.");
            return;
        }

        for (int i = 0; i < width; i++) {
            if (i >= 1 && i <= (width -2)){
                if (i < middle){
                    //For Top half
                    star(i,middle);
                    space(i);
                    star(i,middle);
                }else if( i == middle){
                    //For middle row
                        print(starChar);
                        space(i);
                        print(starChar);
                    }else {
                    //For Bottom half
                    star(middle,i);
                    space(next);
                    star(middle,i);
                        next--;
                    }
            }else{
                //Top and Bottom line
                for (int j = 0; j < width; j++) {
                    print(starChar);
                }
            }
            println();
        }
    }

    void star(int i,int middle) {
        for (int j = 0; j < middle - i + 1; j++) {
            print(starChar);
        }
    }

    void space (int i){
        for (int j = 0; j < 2 * i -1; j++) {
            print(spaceChar);
        }
    }
}
