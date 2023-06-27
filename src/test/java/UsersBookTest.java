import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersBookTest {

    UsersBook usersBook;
    User user1;
    User user2;
    User user3;


    @BeforeEach
    void setUp() {
        usersBook = new UsersBook();
        user1 = new User("name1", "surname1", 20);
        user2 = new User("name2", "surname2", 22);
        user3 = new User("name3", "surname3", 24);
    }

    @Test
    void testAddUser() {
        usersBook.addUser(user1);
        assertEquals(user1, usersBook.getUserById(user1.getId()));
    }

    @Test
    void testFindAll() {
        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);

        usersBook.addUser(user1);
        usersBook.addUser(user2);
        usersBook.addUser(user3);

        assertEquals(userArrayList, usersBook.findAll());
    }

    @Test
    void testGetUserById() {
        usersBook.addUser(user1);
        int id = user1.getId();
        assertEquals(user1, usersBook.getUserById(id));
    }

    @Test
    void testRemoveById() {
        int id = user1.getId();
        usersBook.addUser(user1);
        usersBook.removeById(id);
        assertNull(usersBook.getUserById(id));
    }

    @Test
    void testGetLastAddedUser() {
        usersBook.addUser(user1);
        assertEquals(user1, usersBook.getLastAddedUser());

        usersBook.addUser(user2);
        assertEquals(user2, usersBook.getLastAddedUser());

        usersBook.addUser(user3);
        assertEquals(user3, usersBook.getLastAddedUser());
    }
}