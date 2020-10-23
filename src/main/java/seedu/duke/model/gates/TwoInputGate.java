package seedu.duke.model.gates;

public abstract class TwoInputGate extends Gate {
    protected int secondInput;
    protected boolean isSetSecondInput = false;

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
        isSetSecondInput = true;
    }

    /**
     * Returns second input of gate.
     *
     * @return int second input
     */
    public int getSecondInput() {
        return secondInput;
    }

    /**
     * Returns whether second input is set.
     *
     * @return boolean
     */
    public boolean isSetSecondInput() {
        return isSetSecondInput;
    }
}
