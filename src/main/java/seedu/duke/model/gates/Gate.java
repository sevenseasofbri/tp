package seedu.duke.model.gates;

public abstract class Gate {
    protected int output;
    protected int input;
    protected boolean isSetInput = false;

    public abstract int getOutput();

    public void setInput(int input) {
        this.input = input;
        isSetInput = true;
    }

    /**
     * Returns input of gate.
     *
     * @return int input
     */
    public int getInput() {
        return input;
    }

    /**
     * Returns whether input is set.
     *
     * @return boolean
     */
    public boolean isSetInput() {
        return isSetInput;
    }
}
