package org.example.notifications;

import org.springframework.stereotype.Component;

@Component
public class NotificationData {

    private String emailTo;

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailTo() {
        return emailTo;
    }

}
