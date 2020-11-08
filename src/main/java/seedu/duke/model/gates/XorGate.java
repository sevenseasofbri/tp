package seedu.duke.model.gates;

import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

/**
 * The XorGate class inherits from the Gate class
 * and is used to create XorGate objects.
 */
public class XorGate extends Gate {
    private static final String XOR = "XOR";

    /**
     * Performs bitwise XOR (^) operation on the input instance variables and returns output.
     *
     * @return boolean value of the gate output.
     * @throws InputsNotSetException If both inputs aren't set yet.
     */
    @Override
    public boolean getOutput() throws InputsNotSetException {
        checkHasSetBothInput();
        return input ^ secondInput;
    }

    /**
     * Returns String representation of the XOR gate.
     *
     * @return String type depiction of XOR gate.
     */
    @Override
    public String toString() {
        return XOR;
    }
}
