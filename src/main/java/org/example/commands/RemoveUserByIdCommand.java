package org.example.commands;

import org.example.console.Console;
import org.example.userBook.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class RemoveUserByIdCommand implements Command {
    private final UserBook usersBook;
    private final Console console;

    @Autowired
    public RemoveUserByIdCommand(UserBook usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {
        console.printLn("Enter user id: ");
        try {
            int userId = console.nextInt();
            if (usersBook.getUserById(userId) != null) {
                usersBook.removeById(userId);
                console.printLn("org.example.user.User with id: " + userId + " -> has been deleted");
            } else {
                console.printLn("org.example.user.User with id: " + userId + " not found");
            }
            console.printLn(SEPARATOR);

        } catch (InputMismatchException exception) {
            console.printLn("Input error, you need to enter only numbers (integer)");
            console.printLn(SEPARATOR);
        }
    }

    @Override
    public String getName() {
        return "removeById";
    }

    @Override
    public String toString() {
        return "If you want to delete a user by id, write the command => 'removeById'";
    }
}
