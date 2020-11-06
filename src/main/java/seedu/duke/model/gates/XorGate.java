package seedu.duke.model.gates;

import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

public class XorGate extends Gate {
    private static final String XOR = "XOR";

    /**
     * Performs bitwise XOR (^) operation on the input instance variables.
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
