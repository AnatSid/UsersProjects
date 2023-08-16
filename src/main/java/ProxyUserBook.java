import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyUserBook implements UserBook {

    private RealUsersBook realUsersBook;
    private final Map<Integer, User> userCache = new HashMap<>();

    @Override
    public void addUser(User user) {
        if (realUsersBook == null) {
            realUsersBook = new RealUsersBook();
        }
        realUsersBook.addUser(user);
    }

    @Override
    public List<User> findAll() {
        if (realUsersBook == null) {
            realUsersBook = new RealUsersBook();
        }
        return realUsersBook.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        if (userCache.containsKey(userId)) {
            return userCache.get(userId);
        }

        User user = realUsersBook.getUserById(userId);
        if (user != null) {
            userCache.put(userId, user);
        }
        return user;
    }

    @Override
    public void removeById(Integer userId) {
        if (realUsersBook == null) {
            realUsersBook = new RealUsersBook();
        }
        realUsersBook.removeById(userId);
    }

    @Override
    public User getLastAddedUser() {
        if (realUsersBook == null) {
            realUsersBook = new RealUsersBook();
        }
        return realUsersBook.getLastAddedUser();
    }
}
