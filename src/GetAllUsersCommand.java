public class GetAllUsersCommand implements Command {
    private final UsersBook usersBook;
    private final String SEPORATOR = "____________________________________________________________________________";

    public GetAllUsersCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        usersBook.findAll().forEach(System.out::println);
        System.out.println(SEPORATOR);
    }
}
