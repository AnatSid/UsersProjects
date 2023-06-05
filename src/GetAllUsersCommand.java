public class GetAllUsersCommand implements Command {
    private UsersBook usersBook;

    public GetAllUsersCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void exucute() {
        usersBook.findAll().forEach(System.out::println);
    }
}
