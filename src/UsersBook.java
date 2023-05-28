import java.util.*;

public class UsersBook {
    private Map <Integer, User> users = new HashMap<>();
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Integer userId) {
        if (userId != null && users.containsKey(userId)) {
            return users.get(userId);
        }
        return null;
    }

}
