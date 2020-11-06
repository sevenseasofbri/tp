package seedu.duke.logic.parser.exceptions;

public class InvalidNumberException extends ParserException {
    public InvalidNumberException() {
        super("Invalid number! You should use a positive number.");
    }
}
