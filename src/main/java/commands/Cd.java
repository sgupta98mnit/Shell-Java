package commands;

import exception.CommandNotFound;

import java.io.File;

public class Cd implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String path = context.getArgument();

        String currentDirectory = System.getProperty("user.dir");

        File file = new File(currentDirectory, path);

        if(file.exists()){
            System.setProperty("user.dir", path);
        } else {
            System.out.println("cd: " + context.getArgument() + ": No such file or directory");
        }
    }
}
