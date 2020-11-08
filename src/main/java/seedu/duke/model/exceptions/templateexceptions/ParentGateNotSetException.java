package seedu.duke.model.exceptions.templateexceptions;

/**
 * The ParentGateNotSetException class inherits from the TemplateException class and
 * is thrown when the parent gate has yet to be set.
 */
public class ParentGateNotSetException extends TemplateException {
    public ParentGateNotSetException() {
        super("Parent gate not set yet!");
    }
}
