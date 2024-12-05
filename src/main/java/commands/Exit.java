package commands;

public class Exit implements Command {
    @Override
    public void execute(CommandContext context) {
        System.out.println("exit 0");
    }
}
