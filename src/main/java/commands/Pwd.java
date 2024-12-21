package commands;

import exception.CommandNotFound;

public class Pwd implements Command {

    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        System.out.println(System.getProperty("user.dir"));
    }
}
