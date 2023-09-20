package org.example.commands;

public interface Command {
    String SEPARATOR = "____________________________________________________________________________";
    void execute();
    String getName();

}
