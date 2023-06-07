import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserToIdCommand implements Command {
    private final UsersBook usersBook;
    private final String info = "If you want to get user data by ID , enter the command => 'getUserForId'";

    public GetUserToIdCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
        System.out.println(this);
    }

    @Override
    public void execute() {
        int id;
            System.out.println("Введите id пользователя: ");
            Scanner scanner = new Scanner(System.in);
            try {
                id = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка ввода, нужно вводить только числа (целочисленные)");
                System.out.println(SEPARATOR);
                return;
            }
        
        if (usersBook.getUserById(id) != null) {
            System.out.println("Пользователь с id: " + id + " -> " + usersBook.getUserById(id));
        } else {
            System.out.println("Пользователь с id: " + id + " не найден");
        }
        System.out.println(SEPARATOR);
    }
    @Override
    public String toString() {
        return info;
    }
}
