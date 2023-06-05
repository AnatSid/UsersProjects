import java.util.HashMap;
import java.util.Map;
public class CommandList {
    private final HashMap<String,Command> commandList;
    private static final String ADD = "add";
    private static final String GET_ALL_USERS = "getAllUsers";
    private static final String GET_USER_FOR_ID = "getUserForId";

    public CommandList() {
        commandList = new HashMap<>();
        commandList.put(ADD,new AddCommand());
        commandList.put(GET_ALL_USERS,new GetAllUsersCommand());
        commandList.put(GET_USER_FOR_ID,new GetUserForIdCommand());
    }

    public Map<String,Command> initilization(){
        return commandList;
    }

}
