package commands;

import exception.CommandNotFound;

import java.util.HashMap;
import java.util.Map;

//Singleton class with private constructor
public class CommandRegistry {

    private static final CommandRegistry instance = new CommandRegistry();
    public static final Map<String, Command> commandRegistry = new HashMap<>();

    private CommandRegistry() {
        commandRegistry.put("echo", new Echo());
    }

    public static CommandRegistry getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) throws CommandNotFound {
        Command command = commandRegistry.get(commandName);
        if(command == null)
            throw new CommandNotFound(commandName);
        return command;
    }
}
