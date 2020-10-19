package seedu.duke.model.component.gates;

public class XnorGate extends TwoInputGate {
    private static final String XNOR = "--(~^)--";

    public XnorGate(int input1, int input2) {
        input = input1;
        secondInput = input2;
    }

    /**
     * Performs bitwise XNOR (~^) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
        return ~(input ^ secondInput);
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
