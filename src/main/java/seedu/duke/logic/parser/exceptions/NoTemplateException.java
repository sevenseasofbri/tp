package seedu.duke.logic.parser.exceptions;

public class NoTemplateException extends ParserException {
    public NoTemplateException() {
        super("No template set yet! Use the 'summary' command to see the available templates.");
    }
}
