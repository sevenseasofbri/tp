package seedu.duke.model.exceptions.templateexceptions;

public class GateSetException extends TemplateException {
    public GateSetException() {
        super(":( The current position you are trying to set to a logic level is already set as a gate!");
    }
}
