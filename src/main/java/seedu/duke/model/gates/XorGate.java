package seedu.duke.model.gates;

public class XorGate extends TwoInputGate {
    private static final String XOR = "--(^)--";

    /**
     * Performs bitwise XOR (^) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
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
