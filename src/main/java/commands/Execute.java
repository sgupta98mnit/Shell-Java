package commands;

import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;
import utility.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Execute implements Command {

    @Override
    public void execute(CommandContext context) throws CommandNotFound {
        StringBuilder output = new StringBuilder();
        if(StringUtils.equals(context.getCommand(), "execute")) {
            for(String arg : context.getArguments()) {
                output.append(runProgram(arg, arg)).append("\n");
            }
        } else {
            output = new StringBuilder(runProgram(context.getCommand(), context.getLine()));
        }
        System.out.println(output);
    }

    private String runProgram(String filename, String fileNameWithArguments) throws CommandNotFound {
        String filePath = Utility.checkFileExistsOnPath(filename);
        if(StringUtils.isNotBlank(filePath)) {
            try {
                Process process = Runtime.getRuntime().exec(fileNameWithArguments);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                return line;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return new CommandNotFound(fileNameWithArguments).getMessage();
    }
}
