public class AddAndNotifyCommand implements Command {
    private final UserBook userbook;
    private final Console console;
    private final UserIdGenerator idGenerator;
    private final NotificationService notificationService;

    public AddAndNotifyCommand(UserBook userbook, Console console, UserIdGenerator idGenerator,
                               NotificationService notificationService) {
        this.userbook = userbook;
        this.console = console;
        this.idGenerator = idGenerator;
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        AddCommand add = new AddCommand(userbook,console, idGenerator);
        add.execute();

        console.printLn("Please enter the recipient's email to send notification");
        String emailTo = console.nextLine();

        NotificationData notificationData = new NotificationData();
        notificationData.setEmailTo(emailTo);
        notificationData.setNameService("'UserBook'");

//        NotificationService emailNotification = new EmailNotificationService(
//                "ansidtyrksony1995@gmail.com",
//                "icgnrnkfveoqzgpz",
//                "Userbook greeting you",
//                "You have successfully registered in our service" + notificationData.getNameService() +
//                        "Your ID: " + userbook.getLastAddedUser().getId());

        notificationService.sendNotification(notificationData);

        console.printLn(SEPARATOR);
    }

    @Override
    public String toString() {
        return "If you want to add a new user and notify him, enter the command => 'addAndNotify'";
    }
}
