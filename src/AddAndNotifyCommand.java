public class AddAndNotifyCommand implements InterfaceCommand {

    private final UsersBook usersBook;
    private final String info = "If you want to add a new user and notify him, enter the command => 'addAndNotify'";

    public AddAndNotifyCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        InterfaceCommand add = new AddCommand(usersBook);
        add.execute();

        Notifications emailNotification = new EmailNotification();
        emailNotification.sendNotification("You have successfully registered in our service." +
                " A notification has been sent to your email");

        System.out.println(SEPARATOR);
    }

    @Override
    public String toString() {
        return info;
    }
}
