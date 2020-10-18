package seedu.duke.component.gates;

public abstract class TwoInputGate extends Gate {
    protected int secondInput;

    public void setSecondInput(int input) {
        secondInput = input;
    }
}
