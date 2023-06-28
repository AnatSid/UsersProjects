
public class GetUserByIdForTest implements InterfaceForGetUserByIdCommand {
    UsersBook usersBook;
    int id;

    public GetUserByIdForTest(UsersBook usersBook,int id) {
        this.usersBook = usersBook;
        this.id = id;
    }

    @Override
    public User assignAndExecute() {
        return usersBook.getUserById(id);
    }
}
