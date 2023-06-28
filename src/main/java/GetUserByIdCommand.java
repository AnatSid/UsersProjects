
public class GetUserByIdCommand implements Command {
    private final UsersBook usersBook;
    private InterfaceForGetUserByIdCommand interfaceForGetUserByIdCommand;

    public GetUserByIdCommand(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        interfaceForGetUserByIdCommand = new GetUserByIdForMain(usersBook);
        interfaceForGetUserByIdCommand.assignAndExecute();
        System.out.println(SEPARATOR);
    }

    public void setInterfaceForGetUserByIdCommand(InterfaceForGetUserByIdCommand interfaceForGetUserByIdCommand) {
        this.interfaceForGetUserByIdCommand = interfaceForGetUserByIdCommand;
    }

    @Override
    public String toString() {
        return "If you want to get user data by ID , enter the command => 'getUserForId'";
    }
}
