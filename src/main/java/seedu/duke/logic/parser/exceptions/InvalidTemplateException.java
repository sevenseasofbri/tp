package seedu.duke.logic.parser.exceptions;

/**
 * The InvalidTemplateException class inherits from the ParserException class
 * and is thrown if the tutorial mode entered is invalid.
 */
public class InvalidTemplateException extends ParserException {
    public InvalidTemplateException() {
        super("Please enter a valid tutorial type!\n\tUse 'tutorial circuit' or 'tutorial boolean'.");
    }
}
