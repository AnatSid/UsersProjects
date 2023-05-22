import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Чтобы получить данные всех пользователей, введите команду => 'getAllUsers'");
            System.out.println("Чтобы получить данные пользователя по ID , введите команду => 'getUserForId'");
            System.out.println("Чтобы добавить нового пользователя, введи команду => 'add'");

            String inputCommand = scanner.nextLine();

            if (inputCommand.equals("getAllUsers")) {
                usersBook.getAllUsers();
                break;
            }

            if (inputCommand.equals("getUserForId")) {
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
                            usersBook.getUserById(inputId);
                            break;
                        } else {
                            System.out.println("Вы ввели отрицательное число. Попробуйте ещё раз");
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println("Ошибка ввода, нужно вводить только числа (целочисленные)");
                    }
                }
            }

            if (inputCommand.equals("add")) {
                while (true) {
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();

                    System.out.println("Введите фамилию:");
                    String surName = scanner.nextLine();

                    System.out.println("Введите возраст:");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    User user = new User(name, surName, age);
                    usersBook.addUser(user);
                    System.out.println("Новый пользователь создан. Ваш id: " + user.getId());
                    System.out.println("_________________________");
                    break;
                }
            }
        }
    }
}
