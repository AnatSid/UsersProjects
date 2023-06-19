public class AddAndNotifyCommand implements Command {

    private final UsersBook usersBook;
    private final String info = "If you want to add a new user and notify him, enter the command => 'addAndNotify'";

    public AddAndNotifyCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        AddCommand add = new AddCommand(usersBook);
        User user = add.createNewUser();
        usersBook.addUser(user);

        Notifications emailNotification = new EmailNotification();
        emailNotification.sendNotification("You have successfully registered in our service. Your ID: "+ user.getId());
        System.out.println(SEPARATOR);
    }

    @Override
    public String toString() {
        return info;
    }
}
