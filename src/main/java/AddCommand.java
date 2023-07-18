
public class AddCommand implements Command {
    private final Book usersBook;
    private final Console console;

    public AddCommand(Book usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {

        console.printLn("Enter your name: ");
        String name = console.nextLine();

        console.printLn("Enter last name:");
        String surName = console.nextLine();

        console.printLn("Enter age:");
        int age = console.nextInt();

        User user = new User(name, surName, age);
        usersBook.addUser(user);

        console.printLn("New user created:\n" + user + "\nUser ID: " + user.getId());
        console.printLn(SEPARATOR);
    }
    @Override
    public String toString() {
        return "If you want to add a new user, enter the command => 'add'";
    }
}
