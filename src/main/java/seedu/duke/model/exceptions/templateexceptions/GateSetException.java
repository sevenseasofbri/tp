package seedu.duke.model.exceptions.templateexceptions;

/**
 * The GateSetException class inherits from the TemplateException class and
 * is thrown when the current position is already set as a gate.
 */
public class GateSetException extends TemplateException {
    public GateSetException() {
        super(":( The current position you are trying to set to a logic level is already set as a gate!");
    }
}
