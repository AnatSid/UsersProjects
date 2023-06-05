import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        Scanner scanner = new Scanner(System.in);
        CommandInfoList commandInfoList = new CommandInfoList();

        AddCommand addCommand = new AddCommand();
        GetAllUsersCommand getAllUsersCommand = new GetAllUsersCommand();
        GetUserForIdCommand getUserForIdCommand = new GetUserForIdCommand();

        Context context = new Context();

        while (true) {
            System.out.println();
            commandInfoList.printCommandInfoList(new ArrayList<>(commandInfoList.initialization()));
            String inputCommand = scanner.nextLine();
            if ("add".equals(inputCommand)) {
                context.setCommand(addCommand);
                context.exucuteCommand(usersBook);
            }
            if ("getAllUsers".equals(inputCommand)) {
                context.setCommand(getAllUsersCommand);
                context.exucuteCommand(usersBook);
            }
            if ("getUserForId".equals(inputCommand)) {
                context.setCommand(getUserForIdCommand);
                context.exucuteCommand(usersBook);
            }
        }
    }
}

