import java.util.HashMap;

public class Commands {
    private final HashMap<String, Command> commands;
    private static final String ADD = "add";
    private static final String GET_ALL_USERS = "getAllUsers";
    private static final String GET_USER_TO_ID = "getUserForId";

    public Commands(UsersBook usersBook) {
        commands = new HashMap<>();
        commands.put(ADD, new AddCommand(usersBook));
        commands.put(GET_ALL_USERS, new GetAllUsersCommand(usersBook));
        commands.put(GET_USER_TO_ID, new GetUserToIdCommand(usersBook));
    }

    public void executeCommand(String inputCommand) {
        if (commands.containsKey(inputCommand)) {
            commands.get(inputCommand).execute();
        } else {
            System.out.println("Incorrect commands");
        }
    }

    @Override
    public String toString() {
        return """
                If you want to add a new user, enter the command => 'add'
                If you want to get the data of all users, enter the command => 'getAllUsers'
                If you want to get user data by ID , enter the command => 'getUserForId'""";

    }
}
