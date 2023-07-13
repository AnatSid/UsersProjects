import java.util.Scanner;

public class RealConsole implements Console {
    @Override
    public int nextInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void printLn(String message) {
        System.out.println(message);
    }
}
