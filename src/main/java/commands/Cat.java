package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;

public class Cat implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        StringBuilder output = new StringBuilder();
        for(String arg : context.getArguments()){
            output.append(Utility.readFile(arg));
        }
        System.out.println(output);
    }
}
