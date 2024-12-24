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
        List<String> executableCommands = Arrays.asList(new String[]{"cat", "cp", "mkdir"});
        try {
            registry.getCommandByCommandName(context.getCommand());
            isShellBuiltin = true;
        } catch (CommandNotFound e) {
            // Check if command exist in PATH

            String filePath = Utility.checkFileExistsOnPath(context.getArguments()[0]);
            if (StringUtils.isNotBlank(filePath)) {
                isCommandBuiltin = true;
            }
            if(!executableCommands.contains(context.getArguments()[0]) && StringUtils.equalsIgnoreCase(context.getCommand(), "my_exe")) {
                System.out.println("Command not found");
                System.out.println(isCommandBuiltin);
                System.out.println(isShellBuiltin);
            }
            if(!isCommandBuiltin && !isShellBuiltin) {
                System.out.println(e.getMessage());
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
