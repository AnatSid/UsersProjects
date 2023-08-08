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
        Assertions.assertTrue(notificationService.IsMailSend);
        Assertions.assertEquals("userEmail", notificationData.getEmailTo());

    }


    static class FakeEmailNotificationService implements NotificationService {
        public boolean IsMailSend = false;

        @Override
        public void sendNotification(NotificationData notificationData) {
            IsMailSend = true;
        }
    }
}