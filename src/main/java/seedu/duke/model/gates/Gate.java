package seedu.duke.model.gates;

import seedu.duke.DukeException;
import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;

public abstract class Gate {
    protected boolean output;
    protected boolean input;
    protected boolean secondInput;
    protected boolean isSetInput = false;
    protected boolean isSetSecondInput = false;

    public Gate(boolean input, boolean secondInput) {
        this.input = input;
        this.secondInput = secondInput;
    }

    public Gate() {
        this(false, false);
    }

    /**
     * Returns output of gate.
     *
     * @return int type output value.
     * @throws InputsNotSetException If the inputs aren't set.
     */
    public abstract boolean getOutput() throws InputsNotSetException;

    public void setInput(boolean input) {
        this.input = input;
        isSetInput = true;
    }

    /**
     * Sets second input to the gate.
     *
     * @param input int type value that can be either 0 or 1.
     */
    public void setSecondInput(boolean input) {
        secondInput = input;
        isSetSecondInput = true;
    }

    /**
     * Returns input of gate.
     *
     * @return int input
     */
    public boolean getInput() {
        return input;
    }

    /**
     * Returns second input of gate.
     *
     * @return int second input
     */
    public boolean getSecondInput() {
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
     * Checks is input has been set or not.
     *
     * @throws InputsNotSetException If an input is not set.
     */
    protected void checkHasSetBothInput() throws InputsNotSetException {
        if (!(isSetSecondInput && isSetInput)) {
            throw new InputsNotSetException("Input(s) not set yet!");
        }
    }

}
