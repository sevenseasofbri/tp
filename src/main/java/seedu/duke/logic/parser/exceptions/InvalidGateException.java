package seedu.duke.logic.parser.exceptions;

/**
 * The InvalidGateException class inherits from the ParserException class
 * and is thrown if the gate entered is invalid.
 */
public class InvalidGateException extends ParserException {
    public InvalidGateException() {
        super("Invalid gate chosen! You can take a look at possible gates using the 'summary' command.");
    }
}
