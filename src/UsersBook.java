import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersBook {
    private Map <Integer, User> users = new HashMap<>();
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public List<User> getAllUsers() {
        List <User> userList = new ArrayList<>();
        for (Integer key : users.keySet()) {
            userList.add(users.get(key));
        }
        return userList;
    }

    public User getUserById(Integer userId) {
        if (userId != null && users.containsKey(userId)) {
            return users.get(userId);
        }
        return null;
    }

}
