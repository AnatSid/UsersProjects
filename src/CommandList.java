
import java.util.HashMap;
import java.util.Map;
public class CommandList {
    HashMap<String,Command> testCommand;
    private String add = "add";
    private String getAllUsers = "getAllUsers";
    private String getUserForId = "getUserForId";

    AddCommand addCommand = new AddCommand();
    GetAllUsersCommand getAllUsersCommand = new GetAllUsersCommand();
    GetUserForIdCommand getUserForIdCommand = new GetUserForIdCommand();

    public CommandList() {
        testCommand = new HashMap<>();
        testCommand.put(add,addCommand);
        testCommand.put(getAllUsers,getAllUsersCommand);
        testCommand.put(getUserForId,getUserForIdCommand);;
    }

    public Map<String,Command> initilization(){
        return testCommand;
    }

//    public CommandList (AddCommand addCommand, GetAllUsersCommand getAllUsersCommand, GetUserForIdCommand getUserForIdCommand) {
//
//        testCommand = new HashMap<>();
//        this.addCommand = addCommand;
//        this.getAllUsersCommand = getAllUsersCommand;
//        this.getUserForIdCommand = getUserForIdCommand;
//        testCommand.put(add,addCommand);
//        testCommand.put(getAllUsers,getAllUsersCommand);
//        testCommand.put(getUserForId,getUserForIdCommand);;
//
//    }
}
