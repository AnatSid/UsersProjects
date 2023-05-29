import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        Scanner scanner = new Scanner(System.in);
//      boolean saveToDisk = true;

        while (true) {
            System.out.println("Чтобы получить данные всех пользователей, введите команду => 'getAllUsers'");
            System.out.println("Чтобы получить данные пользователя по ID , введите команду => 'getUserForId'");
            System.out.println("Чтобы добавить нового пользователя, введи команду => 'add'");

            String inputCommand = scanner.nextLine();

            if ("getAllUsers".equals(inputCommand)) {
                for (User user : usersBook.findAll()) {
                    System.out.println(user);
                }
                continue;
            }

            if ("getUserForId".equals(inputCommand)) {
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
                System.out.println("Пользователь с id:" + id + " -> " +
                        usersBook.getUserById(id));

            }

            if ("add".equals(inputCommand)) {
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

            }
        }
    }
}


