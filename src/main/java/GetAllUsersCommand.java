public class GetAllUsersCommand implements Command {
    private final RealUsersBook realUsersBook;

    public GetAllUsersCommand(RealUsersBook realUsersBook) {
        this.realUsersBook = realUsersBook;
    }
    @Override
    public void execute() {
        realUsersBook.findAll().forEach(System.out::println);
        System.out.println(SEPARATOR);
    }
    @Override
    public String toString() {
        return "If you want to get the data of all users, enter the command => 'getAllUsers'";
    }
}
