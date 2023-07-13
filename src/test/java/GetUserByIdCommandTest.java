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

        Command command = new GetUserByIdCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        Optional<String> successMsqForTest = Optional.ofNullable(console.messages
                .stream()
                .filter(message -> message.startsWith("User with id: 1"))
                .findFirst()
                .orElseThrow(RuntimeException::new));

        if (successMsqForTest.isEmpty()) {
            throw new RuntimeException("Test fail. Test-message is empty.");
        }

    }


}