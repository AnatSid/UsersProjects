import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetUserByIdCommandTest {

    @Test
    void shouldExecutedIfIdWasFound() {
        UsersBook usersBook = new UsersBook();
        User user = new User("test", "test", 1);
        usersBook.addUser(user);

        GetUserByIdForTest getUserByIdForTest = new GetUserByIdForTest(usersBook);
        getUserByIdForTest.execute();

        String expectedInfoAboutUser = "User with id: 1 -> Name = 'test', Surname = 'test', Age = 1', Id = 1";
        Assertions.assertEquals(expectedInfoAboutUser, getUserByIdForTest.getFinalOutputInformation());
    }

    @Test
    void shouldGiveMessageUserIdNoFound() {
        UsersBook usersBook = new UsersBook();

        GetUserByIdForTest getUserByIdForTest = new GetUserByIdForTest(usersBook);
        getUserByIdForTest.execute();

        String expectedInfoAboutUser = "User with id: 1 not found";
        Assertions.assertEquals(expectedInfoAboutUser, getUserByIdForTest.getFinalOutputInformation());
    }

}