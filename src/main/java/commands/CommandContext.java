package commands;

public class CommandContext {
    private String argument;

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "CommandContext{" +
                "argument='" + argument + '\'' +
                '}';
    }
}
