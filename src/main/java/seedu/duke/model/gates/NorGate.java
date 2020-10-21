package seedu.duke.model.gates;

public class NorGate extends OrGate {
    private static final String NOR = "--(~|)--";

    /**
     * Performs bitwise NOR (~|) operation on the input instance variables.
     *
     * @return int value of the gate output.
     */
    @Override
    public int getOutput() {
        return ~(super.getOutput());
    }

    /**
     * Returns String representation of the NOR gate.
     *
     * @return String type depiction of NOR gate.
     */
    @Override
    public String toString() {
        return NOR;
    }
}

