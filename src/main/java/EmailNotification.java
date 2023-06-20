
public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(NotificationData notificationData) {
        TLSEmail tlsEmail = new TLSEmail();
        tlsEmail.sendEmail(
                notificationData.getEmailFrom(),
                notificationData.getEmailPasswordKey(),
                notificationData.getEmailTo(),
                notificationData.getEmailNotificationText());
    }
}
