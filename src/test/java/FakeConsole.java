import java.util.ArrayList;
import java.util.InputMismatchException;
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
        try {
            if(nextInt==null){
                return Integer.parseInt(nextLine);
            }
        } catch (Exception exception) {
            throw new InputMismatchException ("Input error, you need to enter only numbers (integer)");
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

