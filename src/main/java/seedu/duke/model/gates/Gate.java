package seedu.duke.model.gates;

import seedu.duke.DukeException;

public abstract class Gate {
    protected int output;
    protected int input;
    protected int secondInput;
    protected boolean isSetInput = false;
    protected boolean isSetSecondInput = false;

    public Gate(int input, int secondInput) {
        this.input = input;
        this.secondInput = secondInput;
    }

    public Gate() {
        this(-1, -1);
    }

    public abstract int getOutput() throws DukeException;

    public void setInput(int input) {
        this.input = input;
        isSetInput = true;
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
     * Returns input of gate.
     *
     * @return int input
     */
    public int getInput() {
        return input;
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
     * Returns whether input is set.
     *
     * @return boolean
     */
    public boolean isSetInput() {
        return isSetInput;
    }

    /**
     * Returns whether second input is set.
     *
     * @return boolean
     */
    public boolean isSetSecondInput() {
        return isSetSecondInput;
    }

    /**
     * Returns if both inputs are set or not.
     *
     * @return boolean value
     */
    public boolean hasSetBothInput() {
        return isSetSecondInput && isSetInput;
    }

    /**
     * Checks is input has been set or not.
     *
     * @throws DukeException If an input is not set.
     */
    protected void checkHasSetBothInput() throws DukeException {
        if (!hasSetBothInput()) {
            throw new DukeException("Input(s) not set yet!");
        }
    }

}
