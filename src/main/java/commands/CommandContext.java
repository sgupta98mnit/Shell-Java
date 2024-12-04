package commands;

public class CommandContext {
    private String argument;

    private String command;

    private String line;

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "CommandContext{" +
                "argument='" + argument + '\'' +
                ", command='" + command + '\'' +
                '}';
    }
}
