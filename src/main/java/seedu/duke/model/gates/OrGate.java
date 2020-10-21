package seedu.duke.model.gates;

public class OrGate extends TwoInputGate {
    private static final String OR = "--(|)--";

    /**
     * Performs bitwise OR (|) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
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
