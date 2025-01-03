package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Type implements Command {

    @Override
    public void execute(CommandContext context) {
        CommandRegistry registry = CommandRegistry.getInstance();
        boolean isShellBuiltin = false;
        boolean isCommandBuiltin = false;
        List<String> executableCommands = Arrays.asList("cat", "cp", "mkdir");
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
                System.out.println(context.getArguments()[0] + ": not found");
                return;
            }
        }

        String filePath = Utility.checkFileExistsOnPath(context.getArguments()[0]);
        if (StringUtils.isNotBlank(filePath)) {
            isCommandBuiltin = true;
        }

        if(executableCommands.contains(context.getArguments()[0])) {
            System.out.println(context.getArguments()[0] + " is " + Utility.checkFileExistsOnPath(context.getArguments()[0]));
        }
        else if(isShellBuiltin)
            System.out.println(context.getArguments()[0] + " is a shell builtin");
        else
            System.out.println(context.getArguments()[0] + " is " + Utility.checkFileExistsOnPath(context.getArguments()[0]));



    }
}
