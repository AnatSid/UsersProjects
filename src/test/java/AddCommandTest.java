import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class AddCommandTest {

    @Test
    void shouldPrintInfoOfUserThatHasBeenAddedToUserbook() {
        User user = new User("test", "test", 20);
        FakeUserbook usersBook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("test",20);

        Command command = new AddCommand(usersBook,console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();
        Assertions.assertTrue(usersBook.userAdded,"method Add is not called");

        boolean isUserNotFoundMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("New user created:\n" +
                        "Name = 'test'"));

        Assertions.assertTrue(isUserNotFoundMessagePresent, "Console-message is Empty");

    }
}