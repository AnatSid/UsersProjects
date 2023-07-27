import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class AddCommandTest {

    @Test
    void shouldPrintInfoOfNewUserThatHasBeenAddedToUserbook() {
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
    void shouldNotAddUserAndPrintErrorMessageWhenInvalidDataIsEntered(){
        User user = new User("test", "test", 1, 1);
        FakeUserbook usersBook = new FakeUserbook(user);
        FakeConsoleForAddCommandTest console = new FakeConsoleForAddCommandTest("test");
        Command command = new AddCommand(usersBook, console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();
        Assertions.assertFalse(usersBook.userAdded, "method Add is not called");

        boolean isInfoMessageAboutAddingUserIsPresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith
                        ("Input error, for age/id you need to enter only numbers (integer)"));

        Assertions.assertTrue(isInfoMessageAboutAddingUserIsPresent, "Test fail. Test-message is empty.");




    }
    public static class FakeConsoleForAddCommandTest implements Console{
        public final List<String> messages;
        private final String nextLine;

        public FakeConsoleForAddCommandTest(String nextLine) {
            this.nextLine = nextLine;
            this.messages = new ArrayList<>();
        }


        @Override
        public int nextInt() {
            throw new InputMismatchException("Enter letters instead of numbers");
        }

        @Override
        public void printLn(String message) {
            messages.add(message);
        }

        @Override
        public String nextLine() {
            return nextLine;
        }
    }
}

