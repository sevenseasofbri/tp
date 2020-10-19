package seedu.duke.model.component.gates;

public class NandGate extends TwoInputGate {

    private static final String NAND = "--(~&|--";

    /**
     * Performs bitwise NAND (~&) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
        return ~(input & secondInput);
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
