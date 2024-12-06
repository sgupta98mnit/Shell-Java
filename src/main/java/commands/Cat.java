package commands;

import exception.CommandNotFound;

public class Cat implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        Command executeCommand = CommandRegistry.getInstance().getCommandByCommandName("execute");
        executeCommand.execute(context);
    }
}
