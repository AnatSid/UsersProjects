import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetUserByIdCommandTest {

    @Test
    void shouldPrintInfoAboutUserReceivedByIdIfUserIdPresentInUsersBook() {
        User user = new User("name", "surname", 1,1);
        UserBook usersBook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("1");

        Command command = new GetUserByIdCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        boolean isUserInfoMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("User with id: 1 -> Name = 'name', " +
                        "Surname = 'surname', Age = 1', Id = 1"));


        Assertions.assertTrue(isUserInfoMessagePresent, "Test fail. Test-message is empty.");
    }

    @Test
    void shouldPrintUserNotFoundWhenUserIdNotPresentInUsersBook() {

        UserBook usersBook = new FakeUserbook(null);
        FakeConsole console = new FakeConsole("2");

        Command command = new GetUserByIdCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        boolean isUserNotFoundMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("User with id: 2 not found"));

        Assertions.assertTrue(isUserNotFoundMessagePresent, "Message is Empty. 'Else' block failed");


    }


}