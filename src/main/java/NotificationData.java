public class NotificationData {
    private final String emailFrom = "ansidtyrksony1995@gmail.com";
    private final String emailPasswordKey = "icgnrnkfveoqzgpz";
    private String emailTo;
    private String emailNotificationText;




    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }
    public void setEmailNotificationText(String emailNotificationText) {
        this.emailNotificationText = emailNotificationText;
    }


    public String getEmailNotificationText() {
        return emailNotificationText;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public String getEmailPasswordKey() {
        return emailPasswordKey;
    }

    public String getEmailTo() {
        return emailTo;
    }




}
