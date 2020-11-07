package seedu.duke.model.exceptions.templateexceptions;

/**
 * The InputNotSetException class inherits from the TemplateException class and
 * is thrown when an input has yet to be set.
 */
public class InputNotSetException extends TemplateException {
    public InputNotSetException() {
        super("Oops! An input hasn't been set yet.");
    }
}
