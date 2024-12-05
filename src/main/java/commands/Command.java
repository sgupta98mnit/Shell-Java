package commands;

import exception.CommandNotFound;

public interface Command {

    void execute(CommandContext context) throws CommandNotFound;
}
