package seedu.duke.model.gates;

public class OrGate extends TwoInputGate {

    public OrGate(int input1, int input2) {
        input = input1;
        secondInput = input2;
    }

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
        return input + "OR" + secondInput;
    }
}
