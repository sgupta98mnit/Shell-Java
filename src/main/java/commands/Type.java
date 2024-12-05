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
            String path = System.getenv("PATH");
            String[] paths = StringUtils.split(path, ":");

            for(String p : paths) {
                String filePath = p + "/" + context.getArgument();
                if(Utility.checkDirectory(filePath)) {
                    System.out.println(context.getArgument() + " is " + filePath);
                    return;
                }
            }
            System.out.println(e.getMessage());
        }
    }
}
