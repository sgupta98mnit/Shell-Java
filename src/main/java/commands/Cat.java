package commands;

import exception.CommandNotFound;
import jdk.jshell.execution.Util;
import utility.Utility;

public class Cat implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String output = "";
        for(String arg : context.getArguments()){
            output = output + Utility.readFile(arg);
        }
        System.out.println(output);
    }
}
