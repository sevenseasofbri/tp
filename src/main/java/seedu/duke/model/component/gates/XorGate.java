package seedu.duke.model.component.gates;

public class XorGate extends TwoInputGate {
    public XorGate(int input1, int input2) {
        input = input1;
        secondInput = input2;
    }

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
        return input + "XOR" + secondInput;
    }
}
