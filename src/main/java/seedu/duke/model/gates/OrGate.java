package seedu.duke.model.gates;

import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

/**
 * The OrGate class inherits from the Gate class
 * and is used to create OrGate objects.
 */
public class OrGate extends Gate {
    private static final String OR = "OR";

    /**
     * Performs bitwise OR (|) operation on the input instance variables.
     *
     * @return boolean value of the gate output.
     * @throws InputsNotSetException If both inputs aren't set yet.
     */
    @Override
    public boolean getOutput() throws InputsNotSetException {
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
