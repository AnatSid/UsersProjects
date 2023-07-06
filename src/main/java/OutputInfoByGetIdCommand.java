public class OutputInfoByGetIdCommand implements OutputService {

    private final UsersBook usersBook;
    private final int id;

    public OutputInfoByGetIdCommand(UsersBook usersBook, int id) {
        this.usersBook = usersBook;
        this.id = id;
    }

    @Override
    public String collectOutputInfo() {
        if (usersBook.getUserById(id) != null) {
            return "User with id: " + id + " -> " + usersBook.getUserById(id);
        } else {
            return "User with id: " + id + " not found";
        }
    }
}
