import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        User user1 = new User("dsfsd","fdsfsf",25);
        User user2 = new User("dsfsd","fdsfsf",4);

        usersBook.addUser(user1);
        usersBook.addUser(user2);

        ArrayList<User> users = new ArrayList<>();
        users.addAll(usersBook.getAllUsers());

        for (User user:users) System.out.println(user);

        System.out.println(usersBook.getUserForId(1));
        System.out.println(usersBook.getUserForId(4));

        while (true) {
            System.out.println("Введите id пользователя: ");
            Scanner scannerId = new Scanner(System.in);
            // если не создавать новый сканнер ещё раз,то после возникновение исключение в блок catch...
            // ... начинался бесконечный цикл вывода
            try {
                int inputId = scannerId.nextInt();
                scannerId.nextLine();
                // уточнить про обработку сканнером не до конца, после nextInt ( оставался в конце пробел)
                // который мешал следующему циклу
                if (inputId > 0) {
                    usersBook.getUserForId(inputId);
                    break;
                } else {
                    System.out.println("Вы ввели отрицательное число. Попробуйте ещё раз");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка ввода, нужно вводить только числа (целочисленные) ");

            }
        }

    }


}

