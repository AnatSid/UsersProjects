public class GetAllUsersCommand implements Command {
    private UsersBook usersBook;

    @Override
    public void exucute(UsersBook usersBook) {
        this.usersBook = usersBook;
        usersBook.findAll().forEach(System.out::println);
    }
}
