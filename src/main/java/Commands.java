import java.util.HashMap;

public class Commands {
    private final HashMap<String, Command> commands;
    private static final String ADD = "add";
    private static final String GET_ALL_USERS = "getAllUsers";
    private static final String GET_USER_TO_ID = "getUserForId";
    private static final String REMOVE_BY_ID = "removeById";
    private static final String ADD_AND_NOTIFY = "addAndNotify";


    public Commands(RealUsersBook realUsersBook, Console console) {
        commands = new HashMap<>();
        commands.put(ADD, new AddCommand(realUsersBook,console));
        commands.put(GET_ALL_USERS, new GetAllUsersCommand(realUsersBook));
        commands.put(GET_USER_TO_ID, new GetUserByIdCommand(realUsersBook, console));
        commands.put(REMOVE_BY_ID, new RemoveUserByIdCommand(realUsersBook,console));
        commands.put(ADD_AND_NOTIFY, new AddAndNotifyCommand(realUsersBook, console));
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
