import org.example.commands.Command;
import org.example.commands.Commands;
import org.example.commands.GetUserByIdCommand;
import org.example.notifications.NotificationData;
import org.example.notifications.NotificationService;
import org.example.user.User;

import org.example.userBook.UserBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class CommandsTest {
    @Test
    void shouldPrintInfoAboutUserReceivedByIdIfCommandWasExecuted() {
        User user = new User("name", "surname", 1, 1);
        UserBook usersBook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("1");
        NotificationData notificationData = new NotificationData();
        NotificationService notificationService = notificationData1 -> {
        };

        Command command = new GetUserByIdCommand(usersBook, console);
        List<Command> commandList = new ArrayList<>();
        commandList.add(command);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        Commands commands = new Commands(usersBook, console, notificationService, notificationData, commandList);
        commands.executeCommand("getUserForId");

        boolean isUserInfoMessagePresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith("User with id: 1 -> Name = 'name', " +
                        "Surname = 'surname', Age = 1', Id = 1"));

        Assertions.assertTrue(isUserInfoMessagePresent, "Test fail. Test-message is empty.");
    }


}