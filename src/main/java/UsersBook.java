import java.util.*;
public class UsersBook implements Book{
    private final Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Integer userId) {
        if (userId != null && users.containsKey(userId)) {
            return users.get(userId);
        }
        return null;
    }

    public void removeById(Integer userId) {
        if (userId != null) {
            users.remove(userId);
        }
    }

    public User getLastAddedUser() {
        return users.values().stream()
                .max(Comparator.comparing(User::getId))
                .orElse(null);
    }
}