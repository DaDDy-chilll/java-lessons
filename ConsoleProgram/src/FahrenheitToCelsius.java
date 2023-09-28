import acm.program.ConsoleProgram;

public class FahrenheitToCelsius extends ConsoleProgram {
    public void run(){
        final float ADD_ON =  (float) 5 /9;
        final int ADD_ON_SECOND = 32;
        int fahrenheit = readInt("Enter Fahrenheit temperature: ");
        int celsius = (int) (ADD_ON * (fahrenheit - ADD_ON_SECOND));
        println("Celsius equivalent = " + celsius);
    }
}
