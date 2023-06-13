import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersBook usersBook = new UsersBook();
        Scanner scanner = new Scanner(System.in);
        Commands commands = new Commands(usersBook);

        while (true) {
            System.out.println(commands);
            String inputCommand = scanner.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


