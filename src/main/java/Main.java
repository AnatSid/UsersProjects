import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserBook usersBook = new ProxyUserBook();
        Scanner scanner = new Scanner(System.in);
        Console console = new RealConsole(scanner);
        NotificationData notificationData = new NotificationData();
        NotificationService notificationService = new RealEmailNotificationService(
                "ansidtyrksony1995@gmail.com",
                "icgnrnkfveoqzgpz",
                "Userbook greeting you",
                "You have successfully registered in our service");
        Commands commands = new Commands(usersBook,console,notificationService,notificationData);

        while (true) {
            System.out.println(commands);
            String inputCommand = console.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


