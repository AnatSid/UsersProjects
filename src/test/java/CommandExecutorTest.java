import org.example.commands.Command;
import org.example.commands.CommandExecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CommandExecutorTest {
    @Test
    void executionStatusShouldBeTrueAfterCommandIsExecuted() {

        FakeCommand command = new FakeCommand();
        FakeConsole console = new FakeConsole("");

        List<Command> commandList = new ArrayList<>();
        commandList.add(command);

        CommandExecutor commandExecutor = new CommandExecutor(commandList, console);
        commandExecutor.executeCommand("test");

        Assertions.assertTrue(command.executed, "Test fail.Execution status is false. Command failed");
    }

    @Test
    void shouldWriteMessageIncorrectCommandIfEnteredWrongCommand() {

        FakeCommand command = new FakeCommand();
        FakeConsole console = new FakeConsole("");
        CommandExecutor commandExecutor = new CommandExecutor(List.of(command), console);

        boolean isConsoleEmpty = console.messages.isEmpty();
        Assertions.assertTrue(isConsoleEmpty);

        commandExecutor.executeCommand("incorrect");

        boolean isInfoMessageIncorrectCommandsIsPresent = console.messages
                .stream()
                .anyMatch(message -> message.startsWith
                        ("Incorrect commands"));

        Assertions.assertTrue(isInfoMessageIncorrectCommandsIsPresent, "Console-message is Empty");

    }

    public static class FakeCommand implements Command {
        boolean executed = false;

        @Override
        public void execute() {
            executed = true;
        }

        @Override
        public String getName() {
            return "test";
        }

    }

}