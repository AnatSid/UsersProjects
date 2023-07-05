import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GetUserByIdCommandTest {
    UsersBook usersBook = new UsersBook();
    GetByIdForTest getByIdForTest = new GetByIdForTest(usersBook);

    @Test
    void execute() {
        getByIdForTest.execute();
        Assertions.assertTrue(getByIdForTest.executionResult);

    }
}