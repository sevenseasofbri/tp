package seedu.duke.model.gates;

import seedu.duke.DukeException;
import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

public class OrGate extends Gate {
    private static final String OR = "OR";

    /**
     * Performs bitwise OR (|) operation on the input instance variables.
     *
     * @return int value of the gate output.
     * @throws InputsNotSetException If both inputs aren't set yet.
     */
    @Override
    public int getOutput() throws InputsNotSetException {
        checkHasSetBothInput();
        return input | secondInput;
    }

    /**
     * Returns String representation of the OR gate.
     *
     * @return String type depiction of OR gate.
     */
    @Override
    public String toString() {
        return OR;
    }
}
