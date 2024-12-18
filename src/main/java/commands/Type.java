package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;


public class Type implements Command {

    @Override
    public void execute(CommandContext context) {
        CommandRegistry registry = CommandRegistry.getInstance();

        try {
            registry.getCommandByCommandName(context.getArguments()[0]);
            System.out.println(context.getArguments()[0] + " is a shell builtin");
        } catch (CommandNotFound e) {
            // Check if command exist in PATH
            String filePath = Utility.checkFileExistsOnPath(context.getArguments()[0]);
            if (StringUtils.isNotBlank(filePath)) {
                System.out.println(context.getArguments()[0] + " is " + filePath);
                return ;
            }
            System.out.println(e.getMessage());
        }
    }
}
