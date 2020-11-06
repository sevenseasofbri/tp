package seedu.duke.logic.parser.exceptions;

public class InvalidPositionException extends ParserException {
    public InvalidPositionException() {
        super("Invalid position chosen! Make sure the single letter position specified\n"
                + "\tis depicted in the current logic diagram.");
    }
}
