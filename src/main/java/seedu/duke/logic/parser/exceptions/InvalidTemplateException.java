package seedu.duke.logic.parser.exceptions;

public class InvalidTemplateException extends ParserException {
    public InvalidTemplateException() {
        super("Please enter a valid tutorial type!\nUse 'tutorial circuit' or 'tutorial boolean'.");
    }
}
