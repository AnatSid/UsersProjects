package org.example.commands;

import org.example.console.Console;
import org.example.userBook.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class GetUserByIdCommand implements Command {
    private final UserBook usersBook;
    private final Console console;

    @Autowired
    public GetUserByIdCommand(UserBook usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {
        console.printLn("Enter user id: ");
        try {
            int userId = console.nextInt();
            if (usersBook.getUserById(userId) != null) {
                console.printLn("User with id: " + userId + " -> " + usersBook.getUserById(userId));
            } else {
                console.printLn("User with id: " + userId + " not found");
            }
        } catch (InputMismatchException exception) {
            console.printLn("Input error, for age you need to enter only numbers (integer)");
        }
        console.nextLine();
        console.printLn(SEPARATOR);
    }

    @Override
    public String getName() {
        return "getUserForId";
    }

    @Override
    public String toString() {
        return "If you want to get user data by ID , enter the command => 'getUserForId'";
    }
}