package seedu.duke.model.exceptions.gatesexceptions;

/**
 * The InputsNotSetException class inherits from the GateException class and
 * is thrown when any inputs have yet to be set.
 */
public class InputsNotSetException extends GateException {
    public InputsNotSetException() {
        super(":( Input(s) not set yet! Remember to set the values marked as ? before trying to calculate output.");
    }
}
