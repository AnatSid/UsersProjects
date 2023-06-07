import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        Commands commands = new Commands(usersBook);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputCommand = scanner.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


