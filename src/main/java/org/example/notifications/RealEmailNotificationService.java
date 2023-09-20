package org.example.notifications;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class RealEmailNotificationService implements NotificationService {
    @Value("${fromEmail}")
    private String fromEmail;
    @Value("${passwordKey}")
    private String passwordKey;
    @Value("${subjectMailMessage}")
    private String subjectMailMessage;
    @Value("${emailNotificationText}")
    private String emailNotificationText;

    @Override
    public void sendNotification(NotificationData notificationData) {
        this.sendEmail(notificationData.getEmailTo());
    }

    private void sendEmail(String toEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
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
            msg.setText(emailNotificationText, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            Transport.send(msg);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
