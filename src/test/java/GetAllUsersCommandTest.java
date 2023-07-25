import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetAllUsersCommandTest {


    @Test
    void execute() {
        User user = new User("test", "test", 22, 22);
        FakeUserbook userbook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("test", 22);
        GetAllUsersCommand getAllUsersCommand = new GetAllUsersCommand(userbook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        getAllUsersCommand.execute();
        boolean isUserInfoMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("Name = 'test', Surname = 'test', Age = 22', Id = 22"));

        Assertions.assertTrue(isUserInfoMessagePresent, "Test fail. Test-message is empty.");


    }
}