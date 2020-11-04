package seedu.duke.model.exceptions.templateexceptions;

public class InputNotSetException extends TemplateException {
    public InputNotSetException() {
        super("Oops! An input hasn't been set yet.");
    }
}
