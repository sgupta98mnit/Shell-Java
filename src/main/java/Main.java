import commands.Command;
import commands.CommandRegistry;
import exception.CommandNotFound;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static commands.CommandRegistry.commandRegistry;

public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        while(true) {
            System.out.print("$ ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // Handle Exit Command case
            if(StringUtils.equals(input, "exit 0")) {
                break;
            }

            CommandRegistry commandRegistry = CommandRegistry.getInstance();
            try {
                Command command = commandRegistry.getCommand(input);
                command.execute();
            } catch (CommandNotFound e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
