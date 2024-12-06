import commands.Command;
import commands.CommandContext;
import commands.CommandRegistry;
import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        while(true) {
            System.out.print("$ ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            try {
                CommandRegistry commandRegistry = CommandRegistry.getInstance();
                CommandContext context = new CommandContext();
                context.setLine(input);
                parseCommand(context);
                Command command = commandRegistry.getCommand(context);
                command.execute(context);
                if(StringUtils.equalsIgnoreCase(context.getCommand(), "exit"))
                    break;
            } catch (CommandNotFound e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void parseCommand(CommandContext context) {
//        int firstSpaceIndex = StringUtils.indexOf(context.getLine(), ' ');
//
//        if (firstSpaceIndex == -1) {
//            //System.out.println("No space found: " + context.getLine());
//            context.setCommand(context.getLine());
//            return;
//        }
//        String command = StringUtils.substring(context.getLine(), 0, firstSpaceIndex);
//        String argument = StringUtils.substring(context.getLine(), firstSpaceIndex + 1);
//
//        context.setCommand(command);
//        context.setArgument(argument);
        //System.out.println("Context: " + context);

        String[] splitString = StringUtils.split(context.getLine(), " ");

        for(int i = 0; i < splitString.length; i++) {
            if(i == 0) {
                context.setCommand(splitString[i]);
            } else {
                // rest are arguments
                String[] arguments = new String[splitString.length - 1];
                for(int j = 1; j < splitString.length; j++) {
                    if(StringUtils.contains(splitString[j], "'")) {
                        //Pattern.compile("'(.*?)'") creates a pattern to match text between single quotes.
                        Pattern pattern = Pattern.compile("'(.*?)'");
                        Matcher matcher = pattern.matcher(splitString[j]);
                        arguments[j-1] = matcher.group(1);
                    }
                }
                context.setArguments(arguments);
            }
        }
    }
}
