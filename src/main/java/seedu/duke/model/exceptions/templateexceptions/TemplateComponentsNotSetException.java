package seedu.duke.model.exceptions.templateexceptions;

public class TemplateComponentsNotSetException extends TemplateException {
    public TemplateComponentsNotSetException() {
        super("Component(s) in the circuit haven't been set yet! :(");
    }
}
