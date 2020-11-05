package seedu.duke.model.exceptions.gatesexceptions;

public class InputsNotSetException extends GateException {
    public InputsNotSetException() {
        super(":( Input(s) not set yet! Remember to set the values marked as ? before trying to calculate output.");
    }
}
