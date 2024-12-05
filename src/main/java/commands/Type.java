package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;


public class Type implements Command {

    @Override
    public void execute(CommandContext context) {
        CommandRegistry registry = CommandRegistry.getInstance();

        try {
            registry.getCommandByCommandName(context.getArgument());
            System.out.println(context.getArgument() + " is a shell builtin");
        } catch (CommandNotFound e) {
            // Check if command exist in PATH
            if(Utility.checkFileExistsOnPath(context.getArgument()))
                return;
            System.out.println(e.getMessage());
        }
    }
}
