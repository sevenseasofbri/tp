package seedu.duke.logic.parser.exceptions;

public class InvalidPositionException extends ParserException {
    public InvalidPositionException() {
        super("Invalid position chosen! Make sure the single letter position used is shown within the tree seen.");
    }
}
