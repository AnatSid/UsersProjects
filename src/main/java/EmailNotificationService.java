import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailNotificationService implements NotificationService {

    private final String fromEmail;
    private final String passwordKey;
    private final String subjectMailMessage;
    private final String emailNotificationText;

    public EmailNotificationService(String fromEmail, String passwordKey, String subjectMailMessage, String emailNotificationText) {
        this.fromEmail = fromEmail;
        this.passwordKey = passwordKey;
        this.subjectMailMessage = subjectMailMessage;
        this.emailNotificationText = emailNotificationText;
    }

    @Override
    public void sendNotification(NotificationData notificationData) {
        this.SendEmail(
                fromEmail,
                passwordKey,
                notificationData.getEmailTo(),
                subjectMailMessage,
                emailNotificationText);
    }

    private void SendEmail(String fromEmail, String passwordKey, String toEmail, String subjectMailMessage, String message) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, passwordKey);
            }
        };
        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subjectMailMessage, "UTF-8");

            msg.setText(message, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!!");

        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
