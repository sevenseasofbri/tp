package seedu.duke.logic.parser.exceptions;

/**
 * The InvalidPositionException class inherits from the ParserException class
 * and is thrown if the position entered is invalid.
 */
public class InvalidPositionException extends ParserException {
    public InvalidPositionException() {
        super("Invalid position chosen! Make sure the single letter position specified "
                + "is depicted in the current logic diagram.");
    }
}
