import java.util.Scanner;

public class ScannerForMain implements ConsoleReader {
    @Override
    public int readInt() {
        return new Scanner(System.in).nextInt();
    }

    @Override
    public String readLine() {
        return new Scanner(System.in).nextLine();
    }
}
