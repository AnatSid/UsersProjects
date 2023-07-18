import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class AddCommandTest {

    @Test
    void shouldPrintInfoOfUserThatHasBeenAddedToUserbook() {
        User user = new User("test","test",200);

        FakeUserbook usersBook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("test",200);

        Command command = new AddCommand(usersBook,console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();
        Assertions.assertTrue(usersBook.userAdded,"method Add is not called");

        boolean isInfoMessageAboutAddingUserIsPresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith
                        ("New user created: Name = 'test', Surname = 'test', Age = 200'"));

        Assertions.assertTrue(isInfoMessageAboutAddingUserIsPresent, "Console-message is Empty");


    }

    @Test
    void userbookSavesUserWhichWasEnteredInConsole(){
        User user = new User("test","test",10);
        FakeUserbook usersBook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("TEST",10);

        Command command = new AddCommand(usersBook,console);
        command.execute();

        Assertions.assertTrue(usersBook.userAdded,"method Add is not called");
        Assertions.assertEquals(user,usersBook.getLastAddedUser());
    }
}