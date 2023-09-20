package org.example.commands;

import org.example.console.Console;
import org.example.userBook.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllUsersCommand implements Command {
    private final UserBook userBook;
    private final Console console;

    @Autowired
    public GetAllUsersCommand(UserBook userBook, Console console) {
        this.userBook = userBook;
        this.console = console;
    }

    @Override
    public void execute() {
        userBook.findAll().forEach(user -> console.printLn(user.toString()));
        console.printLn(SEPARATOR);
    }

    @Override
    public String getName() {
        return "getAllUsers";
    }

    @Override
    public String toString() {
        return "If you want to get the data of all users, enter the command => 'getAllUsers'";
    }
}
