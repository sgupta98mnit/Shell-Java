package commands;

public class Echo implements Command {
    @Override
    public void execute(CommandContext context) {
        System.out.println(context.getArgument());
    }
}
