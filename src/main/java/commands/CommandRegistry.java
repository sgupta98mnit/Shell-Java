package commands;

import exception.CommandNotFound;

import java.util.HashMap;
import java.util.Map;

//Singleton class with private constructor
public class CommandRegistry {

    private static final CommandRegistry instance = new CommandRegistry();
    private final Map<String, Command> commandRegistry;

    // Private constructor
    private CommandRegistry() {
        commandRegistry = new HashMap<>();
        initializeCommands();
    }

    // Initialize commands in a separate method to isolate logic
    private void initializeCommands() {
        try {
            commandRegistry.put("echo", new Echo());
            commandRegistry.put("exit", new Exit());
            commandRegistry.put("type", new Type());
            commandRegistry.put("pwd", new Pwd());
            commandRegistry.put("cd", new Cd());
            commandRegistry.put("cat", new Cat());
            commandRegistry.put("execute", new Execute());
        } catch (Exception e) {
            // Log initialization failure or rethrow as unchecked
            throw new RuntimeException("Failed to initialize commands", e);
        }
    }

    // Singleton access method
    public static CommandRegistry getInstance() {
        return instance;
    }

    // Get command by name
    public Command getCommand(CommandContext context) throws CommandNotFound {
        Command command = commandRegistry.getOrDefault(context.getCommand(), new Execute());
        if (command == null) {
            throw new CommandNotFound(context.getLine());
        }
        return command;
    }

    public Command getCommandByCommandName(String commandName) throws CommandNotFound {
        Command command = commandRegistry.get(commandName);
        if (command == null) {
            throw new CommandNotFound(commandName);
        }
        return command;
    }
}
