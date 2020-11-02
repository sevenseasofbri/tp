package seedu.duke.logic.parser.exceptions;

public class InvalidArgumentException extends ParserException {
    public InvalidArgumentException() {
        super("Invalid argument! Please follow the format for the command being used.\n"
                + "You can use the command 'summary' to take a look at all the commands.");
    }
}
