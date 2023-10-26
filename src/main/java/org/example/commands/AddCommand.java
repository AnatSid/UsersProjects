package org.example.commands;

import org.example.console.Console;
import org.example.user.User;
import org.example.userBook.UserBook;
import org.example.user.UserIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class AddCommand implements Command {
    private final UserBook usersBook;
    private final Console console;
    private final UserIdGenerator idGenerator;

    @Autowired
    public AddCommand(UserBook usersBook, Console console, UserIdGenerator idGenerator) {
        this.usersBook = usersBook;
        this.console = console;
        this.idGenerator = idGenerator;
    }

    @Override
    public void execute() {
        try {
            console.printLn("Enter your name: ");
            String name = console.nextLine();

            console.printLn("Enter last name:");
            String surName = console.nextLine();

            console.printLn("Enter age:");
            int age = console.nextInt();

            int id = idGenerator.getNextId();

            User user = new User(name, surName, age, id);
            usersBook.addUser(user);

            console.printLn("New user created: " + user);

        } catch (InputMismatchException exception) {
            console.printLn("Input error, for age/id you need to enter only numbers (integer)");
        }
        console.nextLine();
        console.printLn(SEPARATOR);
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String toString() {
        return "If you want to add a new user, enter the command => 'add'";
    }
}
