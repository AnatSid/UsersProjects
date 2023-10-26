import org.example.commands.GetAllUsersCommand;
import org.example.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetAllUsersCommandTest {

    @Test
    void shouldPrintMessageAboutUsersWhichContainedInUserbook() {

        User user = new User("test", "test", 22, 22);
        FakeUserbook userbook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("");
        GetAllUsersCommand getAllUsersCommand = new GetAllUsersCommand(userbook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        getAllUsersCommand.execute();

        boolean isUserInfoMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("test|test|22|22"));

        Assertions.assertTrue(isUserInfoMessagePresent, "Test fail. Test-message is empty.");

    }
}