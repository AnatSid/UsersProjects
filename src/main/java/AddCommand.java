import java.util.Scanner;

public class AddCommand implements Command {
    private final UsersBook usersBook;

    public AddCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public String toString() {
        return"If you want to add a new user, enter the command => 'add'";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter last name:");
        String surName = scanner.nextLine();

        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        User user = new User(name, surName, age);
        usersBook.addUser(user);

        System.out.println("New user created:\n" + user + "\nUser ID: " + user.getId());
        System.out.println(SEPARATOR);
    }
}
