import java.util.HashMap;
import java.util.Map;
public class Commands {
    private final HashMap<String,Command> commands;
    private static final String ADD = "add";
    private static final String GET_ALL_USERS = "getAllUsers";
    private static final String GET_USER_FOR_ID = "getUserForId";

    public Commands(UsersBook usersBook) {
        commands = new HashMap<>();
        commands.put(ADD,new AddCommand(usersBook));
        commands.put(GET_ALL_USERS,new GetAllUsersCommand(usersBook));
        commands.put(GET_USER_FOR_ID,new GetUserForIdCommand(usersBook));
    }

    public Map<String,Command> initialization(){
        return commands;
    }

    public void getСommand(String inputCommand){
        for (String command : commands.keySet()) {
            if (command.equals(inputCommand)) {
                commands.get(command).exucute();
            }
        }
    }
}
