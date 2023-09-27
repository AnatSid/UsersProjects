import org.example.console.Console;

import java.util.ArrayList;
import java.util.List;

public class FakeConsole implements Console {
    public final List<String> messages;
    private final String nextLine;
    private Integer nextInt;

    public FakeConsole(String nextLine) {
        this.nextLine = nextLine;
        this.messages = new ArrayList<>();
    }

    public FakeConsole(String nextLine, int nextInt) {
        this.nextLine = nextLine;
        this.nextInt = nextInt;
        this.messages = new ArrayList<>();
    }

    @Override
    public int nextInt() {
        if (nextInt == null) {
            return Integer.parseInt(nextLine);
        }
        return nextInt;
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

