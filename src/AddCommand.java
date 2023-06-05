import java.util.Scanner;

public class AddCommand implements Command {
    private UsersBook usersBook;
    private User user;

    @Override
    public void exucute( UsersBook usersBook) {
        this.usersBook = usersBook;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String surName = scanner.nextLine();

        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();

        user = new User(name,surName,age);
        usersBook.addUser(user);
        System.out.println("Новый пользователь создан\n" + user.toString()+ "\nID пользователя: " + user.getId());
        System.out.println("____________________________________________________________________________");
    }
}
