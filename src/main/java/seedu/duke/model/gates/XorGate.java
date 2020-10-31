package seedu.duke.model.gates;

import seedu.duke.DukeException;

public class XorGate extends Gate {
    private static final String XOR = "XOR";

    /**
     * Performs bitwise XOR (^) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public boolean getOutput() throws DukeException {
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
