package org.example.userBook;

import org.example.user.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component()
public class RealUsersBook implements UserBook {
    private final Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Integer userId) {
        if (userId != null && users.containsKey(userId)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
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