import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class AddAndNotifyCommandTest {

    @Test
    void execute() {

        User user = new User("testTest","testTest",1,10);
        FakeUserbook userbook = new FakeUserbook(user);
        FakeConsole console = new FakeConsole("testTest",1);
        FakeIdGenerator idGenerator = new FakeIdGenerator(10);
        FakeEmailNotificationService notificationService = new FakeEmailNotificationService();
        Command command = new AddAndNotifyCommand(userbook,console,idGenerator,notificationService);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        command.execute();
        Assertions.assertTrue(notificationService.IsMailSend);


    }




    static class FakeEmailNotificationService implements NotificationService {


        public boolean IsMailSend = false;
        @Override
        public void sendNotification(NotificationData notificationData) {
            IsMailSend=true;
        }
    }

}