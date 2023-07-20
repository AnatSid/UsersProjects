import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;

class AddCommandTest {

    @Test
    void shouldPrintInfoOfUserThatHasBeenAddedToUserbook() {
        User user = new User("test", "test", 1, 1);

        FakeUserbook usersBook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("test", 1);

        Command command = new AddCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();
        Assertions.assertTrue(usersBook.userAdded, "method Add is not called");

        boolean isInfoMessageAboutAddingUserIsPresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith
                        ("New user created: Name = 'test', Surname = 'test', Age = 1', Id = 1"));

        Assertions.assertTrue(isInfoMessageAboutAddingUserIsPresent, "Console-message is Empty");
        Assertions.assertEquals(user, usersBook.getLastAddedUser());

    }

    @Test
    void shouldBeThrownExceptionIfUserEnteredStringInsteadOfInteger () {
        User user = new User("test", "test", 1, 1);

        FakeUserbook usersBook = new FakeUserbook(user);
        Console console = new Console() {
            @Override
            public int nextInt() {
                throw new InputMismatchException("Input error, you need to enter only numbers (integer)");
            }

            @Override
            public void printLn(String message) {

            }

            @Override
            public String nextLine() {
                return "test";
            }
        };

        Command command = new AddCommand(usersBook, console);

        Exception exceptionIfEnteredNotNumber = Assertions.assertThrows(InputMismatchException.class, command::execute);
        Assertions.assertEquals("Input error, you need to enter only numbers (integer)", exceptionIfEnteredNotNumber.getMessage());

    }
}