import java.util.ArrayList;
import java.util.List;

public class CommandInfoList {
    private List<String> commandInfoList;
    private String addCommand = "Чтобы добавить нового пользователя, введи команду => 'add'";
    private String getAllUsers = "Чтобы получить данные всех пользователей, введите команду => 'getAllUsers'";
    private String getUserForId = "Чтобы получить данные пользователя по ID , введите команду => 'getUserForId'";

    public List <String> initialization(){
        commandInfoList = new ArrayList<>();
        commandInfoList.add(addCommand);
        commandInfoList.add(getAllUsers);
        commandInfoList.add(getUserForId);
        return commandInfoList;
    }

    public void printCommandInfoList(List<String> commandInfoList){
        for(String com:commandInfoList) System.out.println(com);
    }

}
