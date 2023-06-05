public class GetAllUsersCommand implements Command {
    @Override
    public void exucute(UsersBook usersBook) {
        usersBook.findAll().forEach(System.out::println);
    }
}
