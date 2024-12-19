package commands;

import exception.CommandNotFound;
import jdk.jshell.execution.Util;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;

public class Cat implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String output = "";
        for(String arg : context.getArguments()){
            output = output + StringUtils.trim(Utility.readFile(arg));
        }
        System.out.println(output);
    }
}
