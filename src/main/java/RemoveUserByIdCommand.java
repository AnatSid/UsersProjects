import java.util.InputMismatchException;

public class RemoveUserByIdCommand implements Command {

    private final Book usersBook;
    private final Console console;

    public RemoveUserByIdCommand(Book usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {
        console.printLn("Enter user id: ");
        try {
            int userId = console.nextInt();
            if (usersBook.getUserById(userId) != null) {
                usersBook.removeById(userId);
                console.printLn("User with id: " + userId + " -> has been deleted");
            } else {
                console.printLn("User with id: " + userId + " not found");
            }
            console.printLn(SEPARATOR);

        } catch (InputMismatchException exception) {
            console.printLn("Input error, you need to enter only numbers (integer)");
            console.printLn(SEPARATOR);
        }
    }

    @Override
    public String toString() {
        return "If you want to delete a user by id, write the command => 'removeById'";
    }
}
