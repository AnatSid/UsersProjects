import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersBookTest {

    UsersBook usersBook;
    User user;

    @BeforeEach
    void setUp() {
        usersBook = new UsersBook();
        user = new User("name1", "surname1", 20);
    }

    @Test
    void addUser() {
        usersBook.addUser(user);
        assertEquals(user, usersBook.getUserById(user.getId()));
    }

    @Test
    void findAll() {
        User user2 = new User("name2", "surname2", 22);
        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(user);
        userArrayList.add(user2);

        usersBook.addUser(user);
        usersBook.addUser(user2);

        assertEquals(userArrayList, usersBook.findAll());

    }

    @Test
    void getUserById() {
        usersBook.addUser(user);
        int id = user.getId();
        assertEquals(user, usersBook.getUserById(id));
    }

    @Test
    void removeById() {
        int id = user.getId();
        usersBook.addUser(user);
        usersBook.removeById(id);
        assertNull(usersBook.getUserById(id));
    }

    @Test
    void getLastAddedUser() {
        User user2 = new User("name2", "surname2", 22);
        User user3 = new User("name3", "surname3", 24);
        usersBook.addUser(user);
        usersBook.addUser(user2);
        usersBook.addUser(user3);
        assertEquals(user3, usersBook.getLastAddedUser());
    }
}