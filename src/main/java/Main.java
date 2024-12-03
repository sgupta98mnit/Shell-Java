import commands.Command;
import commands.CommandRegistry;
import exception.CommandNotFound;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        while(true) {
            System.out.print("$ ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

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
