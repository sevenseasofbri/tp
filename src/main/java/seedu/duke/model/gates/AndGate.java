package seedu.duke.model.gates;

import seedu.duke.DukeException;
import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

/**
 * The AndGate class inherits from the Gate class
 * and is used to create AndGate objects.
 */
public class AndGate extends Gate {
    private static final String AND = "AND";

    /**
     * Performs bitwise AND (&) operation on the input instance variables and returns the output.
     *
     * @return boolean value of the gate output.
     * @throws InputsNotSetException If both inputs aren't set yet.
     */
    @Override
    public boolean getOutput() throws InputsNotSetException {
        checkHasSetBothInput();
        return input & secondInput;
    }

    /**
     * Returns String representation of the AND gate.
     *
     * @return String type depiction of AND gate.
     */
    @Override
    public String toString() {
        return AND;
    }
}
