package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Execute implements Command {

    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        System.out.println("inside execute");
        String filePath = Utility.checkFileExistsOnPath(context.getCommand());
        if (StringUtils.isNotBlank(filePath)) {
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
            throw new CommandNotFound(context.getLine());
        }

    }
}
