package seedu.duke.model.component.gates;

public class NotGate extends Gate {

    public NotGate(int input1) {
        input = input1;
    }

    /**
     * Performs bitwise NOT (~) operation on the input instance variable.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
        return ~input;
    }

    /**
     * Returns String representation of the NOT gate.
     *
     * @return String type depiction of NOT gate.
     */
    @Override
    public String toString() {
        return "NOT";
    }
}
