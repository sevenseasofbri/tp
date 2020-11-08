package seedu.duke.logic.parser.exceptions;

/**
 * The InvalidNumberException class inherits from the ParserException class
 * and is thrown if the input value is invalid.
 */
public class InvalidNumberException extends ParserException {
    public InvalidNumberException() {
        super("Invalid number! You should use a positive number.");
    }
}
