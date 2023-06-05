import java.util.ArrayList;
import java.util.List;

public class CommandInfoList {

    public List <String> initialization(){
        List<String> commandInfoList = new ArrayList<>();

        String addCommand = "If you want to add a new user, enter the command => 'add'";
        commandInfoList.add(addCommand);

        String getAllUsers = "If you want to get the data of all users, enter the command => 'getAllUsers'";
        commandInfoList.add(getAllUsers);

        String getUserForId = "If you want to get user data by ID , enter the command => 'getUserForId'";
        commandInfoList.add(getUserForId);
        return commandInfoList;
    }

    public void printCommandInfoList(List<String> commandInfoList){
        for(String com:commandInfoList) System.out.println(com);
    }

}
