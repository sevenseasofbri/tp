package seedu.duke.model.exceptions.templateexceptions;

/**
 * The TemplateComponentsNotSetException class inherits from the TemplateException class and
 * is thrown when any component in the current template has yet to be set.
 */
public class TemplateComponentsNotSetException extends TemplateException {
    public TemplateComponentsNotSetException() {
        super("Component(s) in the circuit haven't been set yet! :(");
    }
}
