package org.example;

import org.example.commands.Commands;
import org.example.config.SpringConfig;
import org.example.console.Console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Console console = context.getBean("realConsole", Console.class);
        Commands commands = context.getBean("commands", Commands.class);

        while (true) {
            System.out.println(commands);
            String inputCommand = console.nextLine();
            commands.executeCommand(inputCommand);
        }
    }
}


