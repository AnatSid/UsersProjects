import org.example.commands.Command;
import org.example.commands.Commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CommandsTest {
    @Test
    void executionStatusShouldBeTrueAfterCommandIsExecuted() {
        FakeCommand command = new FakeCommand();
        FakeConsole console = new FakeConsole("");

        List<Command> commandList = new ArrayList<>();
        commandList.add(command);

        Commands commands = new Commands(commandList,console);
        commands.executeCommand("test");

        Assertions.assertTrue(command.executionStatus, "Test fail.Execution status is false. Command failed");
    }

    @Test
    void shouldWriteMessageIncorrectCommandIfEnteredWrongCommand(){
        FakeCommand command = new FakeCommand();
        FakeConsole console = new FakeConsole("");

        List<Command> commandList = new ArrayList<>();
        commandList.add(command);

        Commands commands = new Commands(commandList,console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        commands.executeCommand("incorrect");

        boolean isInfoMessageIncorrectCommandsIsPresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith
                        ("Incorrect commands"));

        Assertions.assertTrue(isInfoMessageIncorrectCommandsIsPresent, "Console-message is Empty");

    }

    public static class FakeCommand implements Command {
        boolean executionStatus = false;

        @Override
        public void execute() {
            executionStatus = true;
        }

        @Override
        public String getName() {
            return "test";
        }

    }

}