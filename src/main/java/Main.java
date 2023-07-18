import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealUsersBook realUsersBook = new RealUsersBook();
        Scanner scanner = new Scanner(System.in);
        Console console = new RealConsole(scanner);
        Commands commands = new Commands(realUsersBook,console);

        while (true) {
            System.out.println(commands);
            String inputCommand = scanner.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


