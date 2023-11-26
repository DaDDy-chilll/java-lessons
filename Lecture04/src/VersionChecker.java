import acm.program.ConsoleProgram;

public class VersionChecker extends ConsoleProgram {
    public void run(){
        String value = readLine("Enter What You want to know.Eg. react, node, next, express, mongodb: ");
        checkAnswer(value);
    }

    private void checkAnswer(String value) {
        switch (value) {
            case "react" -> {
                String react_version = "18.2.0";
                println("React latest Version is: " + react_version);
            }
            case "node" -> {
                String node_version = "18.17.1";
                println("Node latest Version is: " + node_version);
            }
            case "next" -> {
                String next_version = "13.4.17";
                println("Next latest Version is: " + next_version);
            }
            case "express" -> {
                String express_version = "4.18.2";
                println("Express latest Version is: " + express_version);
            }
            case "mongodb" -> {
                String mongodb_version = "7.0";
                println("Mongodb latest Version is: " + mongodb_version);
            }
            default -> println("Thanks For Coming....!");
        }
    }
}
