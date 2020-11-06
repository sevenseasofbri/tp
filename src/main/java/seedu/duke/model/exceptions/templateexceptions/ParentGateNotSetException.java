package seedu.duke.model.exceptions.templateexceptions;

public class ParentGateNotSetException extends TemplateException {
    public ParentGateNotSetException() {
        super("Parent gate not set yet!");
    }
}
