import java.util.InputMismatchException;

public class GetUserByIdCommand implements Command {
    private final UserBook usersBook;
    private final Console console;

    public GetUserByIdCommand(UserBook usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {
        console.printLn("Enter user id: ");
        try {
            int userId = console.nextInt();
            if (usersBook.getUserById(userId) != null) {
                console.printLn("User with id: " + userId + " -> " + usersBook.getUserById(userId));
            } else {
                console.printLn("User with id: " + userId + " not found");
            }
            console.printLn(SEPARATOR);

        }catch (InputMismatchException exception){
            console.printLn("Input error, you need to enter only numbers (integer)");
            console.printLn(SEPARATOR);
        }
    }

    @Override
    public String toString() {
        return "If you want to get user data by ID , enter the command => 'getUserForId'";
    }
}