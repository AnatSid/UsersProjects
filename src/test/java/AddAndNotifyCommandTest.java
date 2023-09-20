import org.example.commands.AddAndNotifyCommand;
import org.example.commands.Command;
import org.example.notifications.NotificationData;
import org.example.notifications.NotificationService;
import org.example.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddAndNotifyCommandTest {
    @Test
    void notificationMustBeSentToEmailThatWasEnteredByUser() {

        User user = new User("userName", "userSurname", 1, 10);
        FakeUserbook userbook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("userEmail", 1);
        FakeIdGenerator idGenerator = new FakeIdGenerator(10);
        NotificationData notificationData = new NotificationData();
        FakeEmailNotificationService notificationService = new FakeEmailNotificationService();
        Command command = new AddAndNotifyCommand(userbook, console, idGenerator, notificationService, notificationData);

        command.execute();
        Assertions.assertTrue(notificationService.isMailSend);
        Assertions.assertEquals("userEmail", notificationData.getEmailTo());

    }

    @Test
    void shouldPrintErrorMessageIfMailWasNotSent() {

        User user = new User("userName", "userSurname", 1, 10);
        FakeUserbook userbook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("userEmail", 1);
        FakeIdGenerator idGenerator = new FakeIdGenerator(10);
        NotificationData notificationData = new NotificationData();
        NotificationService notificationService = notificationData1 -> {
            throw new RuntimeException();
        };
        Command command = new AddAndNotifyCommand(userbook, console, idGenerator, notificationService, notificationData);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();

        boolean isErrorMessageIsPresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith
                        ("Error. Failed to send email"));
        Assertions.assertTrue(isErrorMessageIsPresent, "Test fail. Test-message is empty.");

    }

    static class FakeEmailNotificationService implements NotificationService {
        public boolean isMailSend = false;

        @Override
        public void sendNotification(NotificationData notificationData) {
            isMailSend = true;
        }
    }
}