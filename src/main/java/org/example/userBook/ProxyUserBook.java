package org.example.userBook;

import org.example.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyUserBook implements UserBook {
    private final RealUsersBook realUsersBook = new RealUsersBook();
    private final Map<Integer, User> userCache = new HashMap<>();

    @Override
    public void addUser(User user) {
        realUsersBook.addUser(user);
    }

    @Override
    public List<User> findAll() {
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
        realUsersBook.removeById(userId);
    }

    @Override
    public User getLastAddedUser() {
        return realUsersBook.getLastAddedUser();
    }
}
