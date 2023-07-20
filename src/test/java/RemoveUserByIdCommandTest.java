import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RemoveUserByIdCommandTest {

    @Test
    void shouldPrintUserWithIdHasBeenDeletedIfUserIdPresentInUsersBook() {

        User user = new User("name", "surname", 20,1);
        FakeUserbook usersBook = new FakeUserbook(user);

        FakeConsole console = new FakeConsole("1");
        Command command = new RemoveUserByIdCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        Assertions.assertTrue(usersBook.userRemoved, "method remove is not called");

        boolean isDeleteMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("User with id: 1 -> has been deleted"));

        Assertions.assertTrue(isDeleteMessagePresent, "Message is Empty");

    }

    @Test
    void shouldPrintUserNotFoundWhenUserIdNotPresentInUsersBook() {

        UserBook usersBook = new FakeUserbook(null);
        FakeConsole console = new FakeConsole("2");

        Command command = new RemoveUserByIdCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        boolean isUserNotFoundMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("User with id: 2 not found"));

        Assertions.assertTrue(isUserNotFoundMessagePresent, "Message is Empty. 'Else' block failed");
    }
}