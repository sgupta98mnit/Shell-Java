package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class Cd implements Command {
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String path = context.getArgument();
        String currentDirectory = System.getProperty("user.dir");

        String fullPath;
        if (StringUtils.startsWithIgnoreCase(path, "/")) {
            fullPath = path;
        } else {
            // Relative path: combine with the current directory
            fullPath = new File(currentDirectory, path).getAbsolutePath();
        }

        File file = new File(fullPath);

        if (file.exists() && file.isDirectory()) {
            System.setProperty("user.dir", fullPath);
        } else {
            System.out.println("cd: " + context.getArgument() + ": No such file or directory");
        }
    }
}
