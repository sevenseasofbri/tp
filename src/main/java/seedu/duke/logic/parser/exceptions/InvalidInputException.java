package seedu.duke.logic.parser.exceptions;

public class InvalidInputException extends ParserException {
    public InvalidInputException() {
        super("Invalid input chosen! You should only choose 0 or 1 as input.");
    }
}
