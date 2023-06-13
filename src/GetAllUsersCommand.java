public class GetAllUsersCommand implements Command {
    private final UsersBook usersBook;
    private final String info = "\nIf you want to get the data of all users, enter the command => 'getAllUsers'";
    public GetAllUsersCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }
    @Override
    public void execute() {
        usersBook.findAll().forEach(System.out::println);
        System.out.println(SEPARATOR);
    }
    @Override
    public String toString() {
        return info;
    }
}
