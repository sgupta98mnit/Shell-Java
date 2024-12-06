package commands;

import java.util.Arrays;

public class CommandContext {
    private String[] arguments;

    private String command;

    private String line;

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
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
                "arguments=" + Arrays.toString(arguments) +
                ", command='" + command + '\'' +
                ", line='" + line + '\'' +
                '}';
    }
}
