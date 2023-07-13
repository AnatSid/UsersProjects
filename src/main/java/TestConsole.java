import java.util.ArrayList;
import java.util.List;

public class TestConsole implements Console {
    private final int nextInt;
    public final List <String> messages;

    public TestConsole(int nextInt) {
        this.nextInt = nextInt;
        this.messages = new ArrayList<>();
    }

    @Override
    public int nextInt() {
        return nextInt;
    }

    @Override
    public void printLn(String message) {
        messages.add(message);
    }
}
