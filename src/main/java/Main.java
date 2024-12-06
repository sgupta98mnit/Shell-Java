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

        int firstSpacePos = StringUtils.indexOf(context.getLine(), " ");
        String command = StringUtils.substring(context.getLine(), 0, firstSpacePos);
        context.setCommand(command);
        String argumentString = StringUtils.substring(context.getLine(), firstSpacePos + 1, context.getLine().length());
        String[] arguments;
        if(StringUtils.startsWith(argumentString, "'")) {
//            argumentString = StringUtils.remove(argumentString, " ");
            arguments = StringUtils.substringsBetween(argumentString, "'", "'");

        }
        else
            arguments = StringUtils.split(argumentString, " ");
        context.setArguments(arguments);
    }
}
