import java.util.InputMismatchException;

public class GetUserByIdForTest implements Command {

    private final UsersBook usersBook;
    private String finalOutputInformation;


    public GetUserByIdForTest(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        int id;
        ConsoleReader consoleReader = new ScannerForTest();
        try {
            id = consoleReader.readInt();
        } catch (InputMismatchException exception) {
            return;
        }
        OutputService outputService = new OutputInfoByGetIdCommand(usersBook,id);
        finalOutputInformation = outputService.collectOutputInfo();


    }

    public String getFinalOutputInformation() {
        return finalOutputInformation;
    }

    @Override
    public String toString() {
        return "If you want to get user data by ID , enter the command => 'getUserForId'";
    }


}
