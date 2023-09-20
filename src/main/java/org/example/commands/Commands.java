package org.example.commands;

import org.example.notifications.NotificationData;
import org.example.notifications.NotificationService;
import org.example.console.Console;
import org.example.userBook.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class Commands {
    @Autowired
    private List<Command> command;
    private final HashMap<String, Command> commands;
    @Autowired
    public Commands(UserBook userBook, Console console, NotificationService notificationService,
                    NotificationData notificationData) {

        commands = new HashMap<>();
        for (Command comm : command) {
            String key = comm.getName();
            commands.put(key, comm);
        }
    }
    public void executeCommand(String inputCommand) {
        if (commands.containsKey(inputCommand)) {
            commands.get(inputCommand).execute();
        } else {
            System.out.println("Incorrect commands");
        }
    }
    @Override
    public String toString() {
        StringBuilder commandInfo = new StringBuilder();
        for (Command info : commands.values()) {
            commandInfo.append(info.toString()).append("\n");
        }
        return commandInfo.toString();
    }
}
