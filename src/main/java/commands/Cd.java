package commands;

import exception.CommandNotFound;

import java.io.File;

public class Cd implements Command{
    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        String path = context.getArgument();

        File file = new File(path);

        if(file.exists()){
            System.setProperty("user.dir", path);
        } else {
            System.out.println(context.getLine() + ": No such file or directory");
        }
    }
}
