import org.example.user.User;
import org.example.userBook.UserBook;
import org.example.userBook.FileUserBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUserBookTest {

    private UserBook userBook;
    private static final String TEST_FILE_PATH = "FileForTest.txt";

    @BeforeEach
    public void setUp() throws IOException {
        Files.createFile(Paths.get(TEST_FILE_PATH));
        userBook = new FileUserBook(TEST_FILE_PATH);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    }

    @Test
    void testFindAll() {
        UserBook userBook1 = new FileUserBook("FileForTestUserbookToFile");
        List<User> users = userBook1.findAll();

        assertEquals(2, users.size());
        assertEquals("name1", users.get(0).getName());
        assertEquals("name2", users.get(1).getName());
    }

    @Test
    void testGetUserById() {
        UserBook userBook1 = new FileUserBook("FileForTestUserbookToFile");
        User user = new User("name1","surname",1,1);

        assertEquals(user,userBook1.getUserById(1));
        assertEquals("name2", userBook1.getUserById(2).getName());
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
        UserBook userBook1 = new FileUserBook("FileForTestUserbookToFile");
        Assertions.assertEquals(2, userBook1.getLastAddedUser().getId());
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