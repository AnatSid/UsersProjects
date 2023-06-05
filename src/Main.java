import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        CommandInfoList commandInfoList = new CommandInfoList();
        Commands commands = new Commands(usersBook);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            commandInfoList.printCommandInfoList(new ArrayList<>(commandInfoList.initialization()));
            String inputCommand = scanner.nextLine();
            commands.getCommand(inputCommand);
        }
    }
}


