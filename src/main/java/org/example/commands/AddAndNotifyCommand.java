package org.example.commands;

import org.example.notifications.NotificationData;
import org.example.notifications.NotificationService;
import org.example.console.Console;
import org.example.user.UserIdGenerator;
import org.example.userBook.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddAndNotifyCommand implements Command {
    private final UserBook userbook;
    private final Console console;
    private final UserIdGenerator idGenerator;
    private final NotificationService notificationService;
    private final NotificationData notificationData;

    @Autowired
    public AddAndNotifyCommand(UserBook userbook, Console console, UserIdGenerator idGenerator,
                               NotificationService notificationService, NotificationData notificationData) {
        this.userbook = userbook;
        this.console = console;
        this.idGenerator = idGenerator;
        this.notificationService = notificationService;
        this.notificationData = notificationData;
    }

    @Override
    public void execute() {
        AddCommand add = new AddCommand(userbook, console, idGenerator);
        add.execute();
        console.printLn("Please enter the recipient's email to send notification");
        String emailTo = console.nextLine();
        notificationData.setEmailTo(emailTo);
        try {
            notificationService.sendNotification(notificationData);
            console.printLn("Email has been successfully sent to your email: " + emailTo);
        } catch (RuntimeException exception) {
            console.printLn("Error. Failed to send email");
        }
        console.printLn(SEPARATOR);
    }

    @Override
    public String getName() {
        return "addAndNotify";
    }

    @Override
    public String toString() {
        return "If you want to add a new user and notify him, enter the command => 'addAndNotify'";
    }
}
