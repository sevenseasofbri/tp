package seedu.duke.model.component.gates;

public class AndGate extends TwoInputGate {
    public AndGate(int input1, int input2) {
        input = input1;
        secondInput = input2;
    }

    /**
     * Performs bitwise AND (&) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
        return input & secondInput;
    }

    /**
     * Returns String representation of the AND gate.
     *
     * @return String type depiction of AND gate.
     */
    @Override
    public String toString() {
        return input + "AND" + secondInput;
    }
}
