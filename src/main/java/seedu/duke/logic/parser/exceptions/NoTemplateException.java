package seedu.duke.logic.parser.exceptions;

/**
 * The NoTemplateException class inherits from the ParserException class and
 * is thrown if the template has yet to be chosen.
 */
public class NoTemplateException extends ParserException {
    public NoTemplateException() {
        super("No template set yet! Use the 'summary' command to see the available templates.");
    }
}
