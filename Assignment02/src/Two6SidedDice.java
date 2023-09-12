import acm.program.ConsoleProgram;

public class Two6SidedDice extends ConsoleProgram {
    final int sides = 6;
    public void run() {
        firstDice();
    }
    void firstDice() {
        for (int dice1 = 1; dice1 <= sides; dice1++) {
            secondDice(dice1);
            println();
        }
    }
    void secondDice (int dice1) {
        for (int dice2 = 1; dice2 <= sides; dice2++) {
            int total = dice1 + dice2;
            print("(" + dice1 + ", " + dice2 + ")"+"\t");
        }
    }
}
