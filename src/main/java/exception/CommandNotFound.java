package exception;

public class CommandNotFound extends Exception {
    public CommandNotFound(String message) {
        super(message + ": command not found");
    }

}
