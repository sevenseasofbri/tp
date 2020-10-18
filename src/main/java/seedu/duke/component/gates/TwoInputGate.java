package seedu.duke.component.gates;

public abstract class TwoInputGate extends Gate {
    protected int secondInput;

    /**
     * Sets second input to the gate.
     *
     * @param input int type value that can be either 0 or 1.
     */
    public void setSecondInput(int input) {
        secondInput = input;
    }
}
