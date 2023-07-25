import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class FakeConsoleForAddCommandTest implements Console{
    public final List<String> messages;
    private final String nextLine;

    public FakeConsoleForAddCommandTest(String nextLine) {
        this.nextLine = nextLine;
        this.messages = new ArrayList<>();
    }


    @Override
    public int nextInt() {
        throw new InputMismatchException("Enter letters instead of numbers");
    }

    @Override
    public void printLn(String message) {
        messages.add(message);
    }

    @Override
    public String nextLine() {
        return nextLine;
    }
}
