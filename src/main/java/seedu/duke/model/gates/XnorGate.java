package seedu.duke.model.gates;

public class XnorGate extends XorGate {
    private static final String XNOR = "XNOR";

    /**
     * Performs bitwise XNOR (~^) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
        return ~(super.getOutput());
    }

    /**
     * Returns String representation of the XNOR gate.
     *
     * @return String type depiction of XNOR gate.
     */
    @Override
    public String toString() {
        return XNOR;
    }
}
