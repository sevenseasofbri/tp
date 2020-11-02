package seedu.duke.model.gates;

import seedu.duke.DukeException;

public class OrGate extends Gate {
    private static final String OR = "OR";

    /**
     * Performs bitwise OR (|) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public boolean getOutput() throws DukeException {
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
