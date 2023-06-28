import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserByIdForMain implements InterfaceForGetUserByIdCommand {
    UsersBook usersBook;
    int id;

    public GetUserByIdForMain(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public User assignAndExecute() {
        System.out.println("Enter user id: ");
        Scanner scanner = new Scanner(System.in);
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Input error, you need to enter only numbers (integer)");
            return null;
        }

        if (usersBook.getUserById(id) != null) {
            System.out.println("User with id: " + id + " -> " + usersBook.getUserById(id));
        } else {
            System.out.println("User with id: " + id + " not found");
        }
        return null;
    }
}
