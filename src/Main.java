import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersBook usersBook = new UsersBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Commands commands = new Commands(usersBook);
            String inputCommand = scanner.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


