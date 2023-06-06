import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserToIdCommand implements Command {
    private final UsersBook usersBook;
    private final String SEPARATOR = "____________________________________________________________________________";

    public GetUserToIdCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        int id;
        while (true) {
            System.out.println("Введите id пользователя: ");
            Scanner scannerId = new Scanner(System.in);
            try {
                int inputId = scannerId.nextInt();
                scannerId.nextLine();
                id = inputId;
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка ввода, нужно вводить только числа (целочисленные)");
            }
        }
        if(usersBook.getUserById(id)!=null) {
            System.out.println("Пользователь с id: " + id + " -> " + usersBook.getUserById(id));
            System.out.println("________________________________________________________________");
        }else {
            System.out.println("Пользователь с id: " + id + " не найден");
            System.out.println(SEPARATOR);
        }
    }
}
