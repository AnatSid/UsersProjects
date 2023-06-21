import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(NotificationData notificationData) {
        this.takeDataAndSendEmail(
                notificationData.getEmailFrom(),
                notificationData.getEmailPasswordKey(),
                notificationData.getEmailTo(),
                notificationData.getEmailNotificationText());
    }

    private void takeDataAndSendEmail(String fromMail, String pass, String toMail, String msg) {
        final String fromEmail = fromMail;
        final String password = pass;
        final String toEmail = toMail;
        final String message = msg;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        SendingMail(session, toEmail, "Userbook greeting you" , message);
    }

    private static void SendingMail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!!");

        } catch (Exception e) {
            System.out.println("Error. Try again");
        }
    }
}
