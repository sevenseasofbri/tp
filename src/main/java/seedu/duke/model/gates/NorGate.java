package seedu.duke.model.gates;

import seedu.duke.DukeException;

public class NorGate extends OrGate {
    private static final String NOR = "NOR";

    /**
     * Performs bitwise NOR (~|) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() throws DukeException {
        checkHasSetBothInput();
        return ~(super.getOutput());
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

