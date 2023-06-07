import java.util.Scanner;

public class AddCommand implements Command {
    private final UsersBook usersBook;
    private final String info = "If you want to add a new user, enter the command => 'add'";

    public AddCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return info;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String surName = scanner.nextLine();

        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();

        User user = new User(name, surName, age);
        usersBook.addUser(user);
        System.out.println("Новый пользователь создан\n" + user + "\nID пользователя: " + user.getId());
        System.out.println(SEPARATOR);
    }
}
