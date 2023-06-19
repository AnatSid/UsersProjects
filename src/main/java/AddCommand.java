import java.util.Scanner;

public class AddCommand implements Command {
    private final UsersBook usersBook;
    private final String info = "If you want to add a new user, enter the command => 'add'";

    public AddCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public String toString() {
        return info;
    }

    @Override
    public void execute() {
        User user = this.createNewUser();
        usersBook.addUser(user);
        System.out.println("New user created:\n" + user + "\nUser ID: " + user.getId());
        System.out.println(SEPARATOR);
    }

    public User createNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter last name:");
        String surName = scanner.nextLine();

        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        return new User(name, surName, age);
    }
}
