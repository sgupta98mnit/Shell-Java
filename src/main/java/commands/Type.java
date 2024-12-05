package commands;

import exception.CommandNotFound;

public class Type implements Command {

    @Override
    public void execute(CommandContext context) {
        CommandRegistry registry = CommandRegistry.getInstance();

        try {
            registry.getCommandByCommandName(context.getArgument());
            System.out.println(context.getArgument() + " is a shell builtin");
        } catch (CommandNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
