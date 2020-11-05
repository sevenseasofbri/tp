package seedu.duke.logic.parser.exceptions;

public class InvalidTemplateException extends ParserException {
    public InvalidTemplateException() {
        super("Please enter a valid tutorial type!\n\tUse 'tutorial circuit' or 'tutorial boolean'.");
    }
}
