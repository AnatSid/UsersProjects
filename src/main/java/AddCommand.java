import java.util.InputMismatchException;

public class AddCommand implements Command {
    private final UserBook usersBook;
    private final Console console;

    private static int idGenerator = 1;

    public AddCommand(UserBook usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {

        try {
            console.printLn("Enter your name: ");
            String name = console.nextLine();

            console.printLn("Enter last name:");
            String surName = console.nextLine();

            console.printLn("Enter age:");
            int age = console.nextInt();

            int id = idGenerator;

            User user = new User(name, surName, age, id);
            usersBook.addUser(user);
            idGenerator++;

            console.printLn("New user created: " + user);

        } catch (InputMismatchException exception){
            console.printLn("Input error, for age/id you need to enter only numbers (integer)");
        }
        console.nextLine();
        console.printLn(SEPARATOR);
    }

    @Override
    public String toString() {
        return "If you want to add a new user, enter the command => 'add'";
    }
}
