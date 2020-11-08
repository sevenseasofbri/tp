package seedu.duke.logic.parser.exceptions;

/**
 * The InvalidCommandException class inherits from the ParserException class
 * and is thrown if the command entered is invalid.
 */
public class InvalidCommandException extends ParserException {
    public InvalidCommandException() {
        super("Invalid Command! Use the command 'summary' to take a look at all the available commands.");
    }
}
