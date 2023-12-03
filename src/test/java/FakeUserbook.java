import org.example.user.User;
import org.example.userBook.UserBook;

import java.util.List;

public class FakeUserbook implements UserBook {
    private final User user;
    public boolean userAdded;
    public boolean userRemoved;

    public FakeUserbook(User user) {
        this.user = user;
    }

    public void addUser(User user) {
        userAdded = true;
    }

    public List<User> findAll() {
        return List.of(user);
    }

    public User getUserById(Integer userId) {
        return user;
    }

    public void removeUserById(Integer userId) {
        userRemoved = true;
    }

    public User getLastAddedUser() {
        return user;
    }
}
