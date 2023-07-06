import java.util.InputMismatchException;

public class GetUserByIdCommand implements Command {
    private final UsersBook usersBook;

    public GetUserByIdCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        int id;
        System.out.println("Enter user id: ");
        ConsoleReader consoleReader = new ScannerForMain();
        try {
            id = consoleReader.readInt();
        } catch (InputMismatchException exception) {
            System.out.println("Input error, you need to enter only numbers (integer)");
            System.out.println(SEPARATOR);
            return;
        }
        OutputService outputService = new OutputInfoByGetIdCommand(usersBook,id);
        System.out.println(outputService.collectOutputInfo());

        System.out.println(SEPARATOR);
    }

    @Override
    public String toString() {
        return "If you want to get user data by ID , enter the command => 'getUserForId'";
    }
}