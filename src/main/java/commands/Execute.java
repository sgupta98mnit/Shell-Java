package commands;

import exception.CommandNotFound;
import utility.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Execute implements Command {

    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        if(Utility.checkFileExistsOnPath(context.getCommand())) {
            try {
                Process process = Runtime.getRuntime().exec(context.getLine());
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        throw new CommandNotFound(context.getLine());
    }
}
