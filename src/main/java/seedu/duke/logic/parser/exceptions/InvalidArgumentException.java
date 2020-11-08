package seedu.duke.logic.parser.exceptions;

/**
 * The InvalidArgumentException class inherits from the ParserException class
 * and is thrown if the argument entered is invalid.
 */
public class InvalidArgumentException extends ParserException {
    public InvalidArgumentException() {
        super("Invalid argument! Please follow the format for the command being used." + System.lineSeparator()
                + "\tYou can use the command 'summary' to take a look at all the commands.");
    }
}
