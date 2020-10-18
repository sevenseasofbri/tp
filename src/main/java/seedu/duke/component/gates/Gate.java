package seedu.duke.component.gates;

public abstract class Gate {
    protected int output;
    protected int input;

    public abstract int getOutput();

    public void setInput(int input) {
        this.input = input;
    }

}
