import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetUserByIdCommandTest {

    @Test
    void shouldExecuteIfUserIdWasFound() {
        User user = new User("name", "surname", 1);
        Book usersBook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("1");

        Command command = new GetUserByIdCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        String successfulExecutionConsole = console.messages
                .stream()
                .filter(message -> message.startsWith("User with id: 1"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Test fail. Test-message is empty."));

        if (successfulExecutionConsole.isEmpty()) {
            throw new RuntimeException("Test fail. Test-message is empty.");
        }

    }

    @Test
    void shouldExecuteIfUserIdNotWasFound() {

        Book usersBook = new FakeUserbook(null);
        FakeConsole console = new FakeConsole("2");

        Command command = new GetUserByIdCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        boolean successfulExecutionConsole = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("User with id: 2 not found"));

        Assertions.assertTrue(successfulExecutionConsole, "Message is Empty. 'Else' block failed");


    }


}