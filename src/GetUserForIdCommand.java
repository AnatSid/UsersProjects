import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserForIdCommand implements Command {
    private UsersBook usersBook;
    private int id;

    @Override
    public void exucute(UsersBook usersBook) {
        this.usersBook = usersBook;
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
        }else {
            System.out.println("Пользователь с id: " + id + " не найден");
        }
    }
}
