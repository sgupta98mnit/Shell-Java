package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;


public class Type implements Command {

    @Override
    public void execute(CommandContext context) {
        CommandRegistry registry = CommandRegistry.getInstance();

        try {
            String path = System.getenv("PATH");
            System.out.println(path);
            String[] paths = StringUtils.split(path, ":");

            for(String p : paths) {
                if(Utility.checkDirectory(p + "/" + context.getArgument())) {
                    System.out.println(context.getArgument() + " is a shell builtin");
                    return;
                }
            }
            registry.getCommandByCommandName(context.getArgument());
            System.out.println(context.getArgument() + " is a shell builtin");
        } catch (CommandNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
