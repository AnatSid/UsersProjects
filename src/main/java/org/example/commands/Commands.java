package org.example.commands;

import org.example.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Commands {
    private final Map<String, Command> commands;
    private final Console console;

    @Autowired
    public Commands(List<Command> commandList, Console console){
        commands = commandList.stream().collect(Collectors.toMap(Command::getName, command -> command));
        this.console = console;
    }

    public void executeCommand(String inputCommand) {
        if (commands.containsKey(inputCommand)) {
            commands.get(inputCommand).execute();
        } else {
           console.printLn("Incorrect commands");
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
