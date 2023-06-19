import java.util.HashMap;

public class Commands {
    private final HashMap<String, Command> commands;
    private static final String ADD = "add";
    private static final String GET_ALL_USERS = "getAllUsers";
    private static final String GET_USER_TO_ID = "getUserForId";
    Adding a new command to delete a user by id    private static final String REMOVE_BY_ID = "removeById";


    public Commands(UsersBook usersBook) {
        commands = new HashMap<>();
        commands.put(ADD, new AddCommand(usersBook));
        commands.put(GET_ALL_USERS, new GetAllUsersCommand(usersBook));
        commands.put(GET_USER_TO_ID, new GetUserByIdCommand(usersBook));
        commands.put(REMOVE_BY_ID, new RemoveUserByIdCommand(usersBook));

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
        StringBuilder commandInfo = new StringBuilder();
        for (Command info : commands.values()) {
            commandInfo.append(info.toString()).append("\n");
        }
        return commandInfo.toString();
    }
}
