import java.util.Scanner;

public class EmailNotification implements Notifications {
    @Override
    public void sendNotification(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email");
        String email = scanner.nextLine();

        System.out.println(message);
    }
}
