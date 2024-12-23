package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;


public class Type implements Command {

    @Override
    public void execute(CommandContext context) {
        CommandRegistry registry = CommandRegistry.getInstance();
        boolean isShellBuiltin = false;
        boolean isCommandBuiltin = false;
        try {
            registry.getCommandByCommandName(context.getArguments()[0]);
            isShellBuiltin = true;
        } catch (CommandNotFound e) {
            // Check if command exist in PATH
            String filePath = Utility.checkFileExistsOnPath(context.getArguments()[0]);
            if (StringUtils.isNotBlank(filePath)) {
                isCommandBuiltin = true;
            }
            if(!isCommandBuiltin && !isShellBuiltin) {
                System.out.println(e.getMessage());
            }
        }

        String filePath = Utility.checkFileExistsOnPath(context.getArguments()[0]);
        if (StringUtils.isNotBlank(filePath)) {
            isCommandBuiltin = true;
        }

        if(isCommandBuiltin)
            System.out.println(context.getArguments()[0] + " is " + Utility.checkFileExistsOnPath(context.getArguments()[0]));
        else
            System.out.println(context.getArguments()[0] + " is a shell builtin");


    }
}
