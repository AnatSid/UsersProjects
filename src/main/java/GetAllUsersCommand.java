public class GetAllUsersCommand implements Command {
    private final UserBook userBook;

    public GetAllUsersCommand(UserBook userBook) {
        this.userBook = userBook;
    }
    @Override
    public void execute() {
        userBook.findAll().forEach(System.out::println);
        System.out.println(SEPARATOR);
    }
    @Override
    public String toString() {
        return "If you want to get the data of all users, enter the command => 'getAllUsers'";
    }
}
