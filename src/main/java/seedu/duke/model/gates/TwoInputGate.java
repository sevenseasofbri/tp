package seedu.duke.model.gates;

public abstract class TwoInputGate extends Gate {
    protected int secondInput;

    public TwoInputGate(int input, int secondInput) {
        this.input = input;
        this.secondInput = secondInput;
    }

    public TwoInputGate() {
        this(-1, -1);
    }

    /**
     * Sets second input to the gate.
     *
     * @param input int type value that can be either 0 or 1.
     */
    public void setSecondInput(int input) {
        secondInput = input;
    }
}
