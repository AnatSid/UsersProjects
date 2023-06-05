import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        CommandInfoList commandInfoList = new CommandInfoList();
        HashMap<String, Command> command = new HashMap<>(new CommandList().initilization());
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println();
            commandInfoList.printCommandInfoList(new ArrayList<>(commandInfoList.initialization()));
            String inputCommand = scanner.nextLine();
            for (String com : command.keySet()) {
                if (com.equals(inputCommand)) {
                    command.get(com).exucute(usersBook);
                }
            }
        }
    }
}


