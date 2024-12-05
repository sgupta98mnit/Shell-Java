package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class Cd implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String path = context.getArgument();

        String currentDirectory = System.getProperty("user.dir");
        File file = new File(currentDirectory, path);
        if(StringUtils.startsWithIgnoreCase(path, "/")) {
            file = new File(path);
        }

        if(file.exists()){
            System.setProperty("user.dir", file.getAbsolutePath());
        } else {
            System.out.println("cd: " + context.getArgument() + ": No such file or directory");
        }
    }
}
