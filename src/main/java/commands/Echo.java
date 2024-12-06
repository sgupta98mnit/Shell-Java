package commands;

import org.apache.commons.lang3.StringUtils;

public class Echo implements Command {
    @Override
    public void execute(CommandContext context) {
        System.out.println(StringUtils.join(context.getArguments(), " "));
    }
}
