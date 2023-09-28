import acm.program.ConsoleProgram;

public class AreaOfCircle extends ConsoleProgram {
    public void run(){
        final double PI = 3.14;
        double radius = readDouble("Enter radius: ");
        double area = PI * radius * radius;
        println("Area of the circle: " + area);
    }
}
