package seedu.duke.logic.parser.exceptions;

public class InvalidPositionException extends ParserException {
    public InvalidPositionException() {
        super("Invalid position chosen! Make sure the single letter position specified "
                + "is depicted in the current logic diagram.");
    }
}
