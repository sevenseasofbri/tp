package seedu.duke.logic.parser.exceptions;

public class InvalidGateException extends ParserException {
    public InvalidGateException() {
        super("Invalid gate chosen! You can take a look at possible gates using the 'summary' command.");
    }
}
