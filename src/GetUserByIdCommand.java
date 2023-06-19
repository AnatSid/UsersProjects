import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserByIdCommand implements InterfaceCommand {
    private final UsersBook usersBook;
    private final String info = "If you want to get user data by ID , enter the command => 'getUserForId'";

    public GetUserByIdCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        int id;
        System.out.println("Enter user id: ");
        Scanner scanner = new Scanner(System.in);
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Input error, you need to enter only numbers (integer)");
            System.out.println(SEPARATOR);
            return;
        }

        if (usersBook.getUserById(id) != null) {
            System.out.println("User with id: " + id + " -> " + usersBook.getUserById(id));
        } else {
            System.out.println("User with id: " + id + " not found");
        }
        System.out.println(SEPARATOR);
    }

    @Override
    public String toString() {
        return info;
    }
}
