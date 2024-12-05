package commands;

import exception.CommandNotFound;

public class Cd implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String path = context.getArgument();

        System.setProperty("user.dir", path);
    }
}
