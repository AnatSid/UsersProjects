public class GetByIdForTest implements Command {

    public boolean executionResult = false;
    private final UsersBook usersBook;

    public GetByIdForTest(UsersBook usersBook) {
        this.usersBook = usersBook;
    }

    @Override
    public void execute() {
        executionResult = true;
    }

    public boolean executionResult() {
        return executionResult;
    }


}