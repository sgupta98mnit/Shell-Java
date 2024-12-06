package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

public class Cd implements Command {
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String path = context.getArgument();
        String currentDirectory = System.getProperty("user.dir");

        if(StringUtils.equals("~", context.getArgument())) {
            System.setProperty("user.dir", System.getenv("HOME"));
            return;
        }

        String fullPath;
        if (StringUtils.startsWithIgnoreCase(path, "/")) {
            fullPath = path;
        } else {
            // Relative path: combine with the current directory
            fullPath = new File(currentDirectory, path).getAbsolutePath();
        }

        try {
            // Normalize the path to resolve . and .. segments
            File file = new File(fullPath).getCanonicalFile();

            if (file.exists() && file.isDirectory()) {
                System.setProperty("user.dir", file.getAbsolutePath());
            } else {
                System.out.println("cd: " + context.getArgument() + ": No such file or directory");
            }
        } catch (IOException e) {
            System.out.println("cd: Error resolving path: " + e.getMessage());
        }
    }
}
