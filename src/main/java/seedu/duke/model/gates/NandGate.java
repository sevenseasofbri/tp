package seedu.duke.model.gates;

public class NandGate extends AndGate {
    private static final String NAND = "NAND";

    /**
     * Performs bitwise NAND (~&) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
        return ~(super.getOutput());
    }

    /**
     * Returns String representation of the NAND gate.
     *
     * @return String type depiction of NAND gate.
     */
    @Override
    public String toString() {
        return NAND;
    }
}
