package seedu.duke.model.gates;

import seedu.duke.DukeException;
import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

public class NandGate extends AndGate {
    private static final String NAND = "NAND";

    /**
     * Performs bitwise NAND (~&) operation on the input instance variables.
     *
     * @return int value of the gate output.
     * @throws InputsNotSetException If both inputs aren't set yet.
     */
    @Override
    public int getOutput() throws InputsNotSetException {
        return ~(super.getOutput());
    }

    /**
     * Returns String representation of the NAND gate.
     *
     * @return String type depiction of NAND gate.
     */
    @Override
    public String toString() {
        return NAND;
    }
}
