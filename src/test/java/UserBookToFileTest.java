import org.example.user.User;
import org.example.userBook.UserBook;
import org.example.userBook.UserBookToFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserBookToFileTest {

    private UserBook userBook;
    private static final String TEST_FILE_PATH = "FileForTest.txt";

    @BeforeEach
    public void setUp() throws IOException {
        Files.createFile(Paths.get(TEST_FILE_PATH));
        userBook = new UserBookToFile(TEST_FILE_PATH);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    }

    @Test
    void testFindAll() {
        UserBook userBook1 = new UserBookToFile("FileForTestUserbookToFile");
        List<User> users = userBook1.findAll();

        assertEquals(2, users.size());
        assertEquals("name1", users.get(0).getName());
        assertEquals("name2", users.get(1).getName());
    }

    @Test
    public void testAddUser() {
        User user = new User("testName", "testSurname", 30, 10);
        userBook.addUser(user);
        List<User> users = userBook.findAll();

        Assertions.assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    @Test
    void testGetLastAddedUser() {
        User user1 = new User("name1", "surname1", 30, 1);
        User user2 = new User("name2", "surname2", 25, 2);

        userBook.addUser(user1);
        userBook.addUser(user2);

        User lastAddedUser = userBook.getLastAddedUser();
        Assertions.assertEquals(user2, lastAddedUser);
    }

    @Test
    void testGetUserById() {
        User user1 = new User("name1", "surname1", 20, 10);
        User user2 = new User("name2", "surname2", 20, 222);

        userBook.addUser(user1);
        userBook.addUser(user2);

        User retrievedUser1 = userBook.getUserById(10);
        User retrievedUser2 = userBook.getUserById(222);

        assertEquals(user1, retrievedUser1);
        assertEquals(user2, retrievedUser2);
    }

    @Test
    void testRemoveUserById() {
        userBook.addUser(new User("name1", "surname1", 30, 1));
        userBook.addUser(new User("name2", "surname2", 20, 2));

        userBook.removeUserById(1);
        List<User> users = userBook.findAll();

        assertEquals(1, users.size());
        assertNull(userBook.getUserById(1));
    }

}