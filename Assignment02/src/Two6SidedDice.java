import acm.program.ConsoleProgram;

public class Two6SidedDice extends ConsoleProgram {
     int START_VALUE = 1;
     int SECOND_VALUE = 1;
    public void run() {
        oneToSixForRow();
    }
    void oneToSixForRow () {
        for (int i = 0; i < 6; i++) {
            SECOND_VALUE+=i;
            println(START_VALUE+','+SECOND_VALUE);
        }
    }
}
