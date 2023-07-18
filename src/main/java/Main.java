import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersBook usersBook = new UsersBook();
        Scanner scanner = new Scanner(System.in);
        Console console = new RealConsole(scanner);
        Commands commands = new Commands(usersBook,console);

        while (true) {
            System.out.println(commands);
            String inputCommand = scanner.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


