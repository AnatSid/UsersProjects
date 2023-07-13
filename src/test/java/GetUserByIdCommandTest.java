import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class GetUserByIdCommandTest {

    @Test
    void shouldExecuteIfUserIdWasFound() {
        UsersBook usersBook = new UsersBook();
        TestConsole console = new TestConsole(1);
        User user = new User("name", "surname", 1);
        usersBook.addUser(user);

        GetUserByIdCommand getUserByIdCommand = new GetUserByIdCommand(usersBook, console);

        boolean consoleMessageBeforeExecuted = console.messages.isEmpty();
        Assertions.assertTrue(consoleMessageBeforeExecuted);

        getUserByIdCommand.execute();

        boolean consoleMessageAfterExecuted = console.messages.isEmpty();
        Assertions.assertFalse(consoleMessageAfterExecuted);

        Optional<String> successMsqForTest = console.messages
                .stream()
                .filter(message -> message.startsWith("User with id: 1"))
                .findFirst();

        if (successMsqForTest.isEmpty()) {
            throw new RuntimeException("Test fail. Test-message is empty.");
        }

    }


}