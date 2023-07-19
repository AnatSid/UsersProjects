import java.util.InputMismatchException;
import java.util.Scanner;

public class RealConsole implements Console {

    private final Scanner scanner;
    public RealConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine(){
        return scanner.nextLine();
    }
    @Override
    public int nextInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input error, for age you need to enter only numbers (integer)");
        }
    }

    @Override
    public void printLn(String message) {
        System.out.println(message);
    }
}
