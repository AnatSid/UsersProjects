package org.example.commands;

import org.example.console.Console;
import org.example.userBook.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class RemoveUserByIdCommand implements Command {
    private final UserBook usersBook;
    private final Console console;

    @Autowired
    public RemoveUserByIdCommand(@Qualifier("userBookToFile") UserBook usersBook, Console console) {
        this.usersBook = usersBook;
        this.console = console;
    }

    @Override
    public void execute() {
        console.printLn("Enter user id: ");
        try {
            int userId = console.nextInt();
            if (usersBook.getUserById(userId) != null) {
                usersBook.removeUserById(userId);
                console.printLn("User with id: " + userId + " -> has been deleted");
            } else {
                console.printLn("User with id: " + userId + " not found");
            }
        } catch (InputMismatchException exception) {
            console.printLn("Input error, you need to enter only numbers (integer)");
        }
        console.nextLine();
        console.printLn(SEPARATOR);
    }

    @Override
    public String getName() {
        return "removeUserById";
    }

    @Override
    public String toString() {
        return "If you want to delete a user by id, write the command => 'removeUserById'";
    }
}
