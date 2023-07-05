import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetUserByIdCommandTest {

    @Test
    void execute() {
        UsersBook usersBook = new UsersBook();
        GetByIdForTest getByIdForTest = new GetByIdForTest(usersBook);
        getByIdForTest.execute();

        Assertions.assertTrue(getByIdForTest.executionResult());
    }
}