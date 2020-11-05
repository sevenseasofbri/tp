package seedu.duke.model.gates;

import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

public class NorGate extends OrGate {
    private static final String NOR = "NOR";

    /**
     * Performs bitwise NOR (~|) operation on the input instance variables.
     *
     * @return boolean value of the gate output.
     * @throws InputsNotSetException If both inputs aren't set yet.
     */
    @Override
    public boolean getOutput() throws InputsNotSetException {
        checkHasSetBothInput();
        return !(super.getOutput());
    }

    /**
     * Returns String representation of the NOR gate.
     *
     * @return String type depiction of NOR gate.
     */
    @Override
    public String toString() {
        return NOR;
    }
}

