import java.util.InputMismatchException;

public class AddCommand implements Command {
    private final UserBook usersBook;
    private final Console console;

    public AddCommand(UserBook usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {
        boolean bool = true;
        while (bool) {
            try {
                console.printLn("Enter your name: ");
                String name = console.nextLine();

                console.printLn("Enter last name:");
                String surName = console.nextLine();

                console.printLn("Enter age:");
                int age = console.nextInt();

                console.printLn("Enter id");
                int id = console.nextInt();

                User user = new User(name, surName, age, id);
                usersBook.addUser(user);

                console.printLn("New user created: " + user);
                console.printLn(SEPARATOR);
                bool = false;

            }catch (InputMismatchException exception){
                console.printLn("Input error, for age/id you need to enter only numbers (integer)");
                console.printLn(SEPARATOR);
            }
            console.printLn("Try again to create a new user");
            console.nextLine();
        }


    }

    @Override
    public String toString() {
        return "If you want to add a new user, enter the command => 'add'";
    }
}
