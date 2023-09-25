package org.example.commands;

import org.example.console.Console;
import org.example.notifications.NotificationData;
import org.example.notifications.NotificationService;
import org.example.userBook.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Commands {
    private final Map<String, Command> commands;

    @Autowired
    public Commands(UserBook userBook, Console console, NotificationService notificationService,
                    NotificationData notificationData, List<Command> commandList) {
        commands = commandList.stream().collect(Collectors.toMap(Command::getName, command -> command));
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
