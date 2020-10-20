package seedu.duke.model.gates;

public class AndGate extends TwoInputGate {
    private static final String AND = "--(&|--";

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
        return AND;
    }
}
