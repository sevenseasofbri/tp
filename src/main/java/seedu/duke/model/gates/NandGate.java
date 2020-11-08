package seedu.duke.model.gates;

import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

/**
 * The NandGate class inherits from the AndGate class
 * and is used to create NandGate objects.
 */
public class NandGate extends AndGate {
    private static final String NAND = "NAND";

    /**
     * Performs bitwise NAND (!&) operation on the input instance variables and returns the output.
     *
     * @return boolean value of the gate output.
     * @throws InputsNotSetException If both inputs aren't set yet.
     */
    @Override
    public boolean getOutput() throws InputsNotSetException {
        return !(super.getOutput());
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
