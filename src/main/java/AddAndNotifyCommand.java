import java.util.Scanner;

public class AddAndNotifyCommand implements Command {
    private final UsersBook usersBook;
    private final String info = "If you want to add a new user and notify him, enter the command => 'addAndNotify'";

    public AddAndNotifyCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        AddCommand add = new AddCommand(usersBook);
        add.execute();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email to send a notification");
        String emailTo = scanner.nextLine();

        NotificationData notificationData = new NotificationData();
        notificationData.setEmailTo(emailTo);
        notificationData.setEmailNotificationText(
                "You have successfully registered in our service 'Users book'. " +
                        "Your ID: " + usersBook.getLastAddedUser().getId());

        NotificationService emailNotification = new EmailNotification();
        emailNotification.sendNotification(notificationData);

        System.out.println("EMail Sent Successfully!!!");
        System.out.println(SEPARATOR);
    }

    @Override
    public String toString() {
        return info;
    }
}
