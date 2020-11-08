package seedu.duke.logic.parser.exceptions;

/**
 * The InvalidInputException class inherits from the ParserException class
 * and is thrown if the input entered is invalid.
 */
public class InvalidInputException extends ParserException {
    public InvalidInputException() {
        super("Invalid input chosen! You should only choose 0 or 1 as input.");
    }
}
