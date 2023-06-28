import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoveUserByIdCommand implements Command {

    private final UsersBook usersBook;

    public RemoveUserByIdCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        int id;
        System.out.println("Enter user id to delete: ");
        Scanner scanner = new Scanner(System.in);
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Input error, you need to enter only numbers (integer)");
            System.out.println(SEPARATOR);
            return;
        }
        if (usersBook.getUserById(id) != null) {
            usersBook.removeById(id);
            System.out.println("User with id: " + id + " -> has been deleted");
        } else {
            System.out.println("User with id: " + id + " not found");
        }
        System.out.println(SEPARATOR);
    }

    @Override
    public String toString() {
        return "If you want to delete a user by id, write the command => 'removeById'";
    }
}
