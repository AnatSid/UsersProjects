package org.example.userBook;

import org.example.user.User;

import java.io.IOException;
import java.util.List;

public interface UserBook {
     void addUser(User user);
     List<User> findAll();
     User getUserById(Integer userId);
     void removeUserById(Integer userId);
     User getLastAddedUser();

}
