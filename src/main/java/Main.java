import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealUsersBook realUsersBook = new RealUsersBook();
        Scanner scanner = new Scanner(System.in);
        Console console = new RealConsole(scanner);
        NotificationService notificationService = new RealEmailNotificationService(
                "ansidtyrksony1995@gmail.com",
                "icgnrnkfveoqzgpz",
                "Userbook greeting you",
                "You have successfully registered in our service",
                console);

        Commands commands = new Commands(realUsersBook,console,notificationService);

        while (true) {
            System.out.println(commands);
            String inputCommand = console.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


