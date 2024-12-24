package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;

import java.util.Arrays;
import java.util.List;

public class Type implements Command {

    @Override
    public void execute(CommandContext context) {
        if (context.getArguments() == null || context.getArguments().length == 0) {
            System.out.println("Error: No command provided");
            return;
        }

        String commandName = context.getArguments()[0];
        CommandRegistry registry = CommandRegistry.getInstance();

        // Check if the command is a shell built-in
        boolean isShellBuiltin = false;
        try {
            registry.getCommandByCommandName(commandName);
            isShellBuiltin = true;
        } catch (CommandNotFound e) {
            // Do nothing here; proceed to other checks
        }

        // Check if the command is an executable in PATH
        String filePath = Utility.checkFileExistsOnPath(commandName);
        boolean isExecutable = StringUtils.isNotBlank(filePath);

        // Determine the type of the command
        if (isShellBuiltin) {
            System.out.println(commandName + " is a shell builtin");
        } else if (isExecutable) {
            System.out.println(commandName + " is " + filePath);
        } else {
            System.out.println(commandName + " is not found");
        }
    }
}
