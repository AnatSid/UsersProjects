package org.example;

import org.example.commands.CommandExecutor;
import org.example.config.SpringConfig;
import org.example.console.Console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Console console = context.getBean("realConsole", Console.class);
        CommandExecutor commandExecutor = context.getBean("commandExecutor", CommandExecutor.class);

        while (true) {
            console.printLn(commandExecutor.toString());
            String inputCommand = console.nextLine();
            commandExecutor.executeCommand(inputCommand);
        }
    }
}


