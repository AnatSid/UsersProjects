import java.util.Scanner;

public class RealConsole implements Console {

    private final Scanner scanner;

    public RealConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }


    @Override
    public void printLn(String message) {
        System.out.println(message);
    }
}
